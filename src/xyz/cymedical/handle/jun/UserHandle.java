package xyz.cymedical.handle.jun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.ctx.LogCompanyBiz;
import xyz.cymedical.biz.jun.CompanyBiz;
import xyz.cymedical.biz.jun.CompanyFileBiz;
import xyz.cymedical.biz.jun.NurseBiz;
import xyz.cymedical.entity.jun.CompanyFile;
import xyz.cymedical.entity.jun.Nurse;
import xyz.cymedical.entity.jun.Patient;
import xyz.cymedical.entity.xin.Combo;
import xyz.cymedical.tools.jun.ResponseTools;

/**
*	@author Junisyoan;
*	日期：2019年1月28日
*	时间：下午2:17:14
*	类说明：体检工作站人员操作系列
*/

@Controller
@RequestMapping("/nurse")
public class UserHandle {

	@Resource
	private CompanyBiz companyBiz;
	
	@Resource
	private LogCompanyBiz logCompanyBiz;
	
	@Resource
	private CompanyFileBiz companyFileBiz;
	
	@Resource
	private NurseBiz nurseBiz;
	
	
	
	private ModelAndView modelAndView;
	private CompanyFile companyFile;
	
	/*
	 * 全部开单
	 */
	@RequestMapping(value="/allOpen.handle",method=RequestMethod.POST)
	public String allOpen(HttpServletResponse response,HttpServletRequest request,String fid) {
		response.setCharacterEncoding("utf-8");
		List<Patient> patientList = (List<Patient>)request.getSession().getAttribute("patientList");
		//获取所有人的套餐，计算价格
		float price = 0.0f;
		for (int i = 0; i < patientList.size(); i++) {
			//查找套餐价格
			Combo combo = nurseBiz.queryComboByName(patientList.get(i).getComboName());
			//累计价格
			price+=combo.getPrice();
		}
		
		//扣除费用
		try {
			switch (nurseBiz.deductDeposit(patientList.get(0).getCompany_id(), price)) {
			case "扣除成功":
				//修改文件状态
				response.getWriter().print("已生成导检单");
				break;
			case "扣除失败":
				response.getWriter().print("费用扣除失败，请联系管理员！");
				break;
			case "余额不足":
				response.getWriter().print("余额不足，请联系用户！");
				break;
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*
	 * 添加体检人员
	 */
	@RequestMapping(value="/addPatient.handle",method=RequestMethod.POST)
	public ModelAndView addPatient(HttpServletRequest request, HttpServletResponse response, Patient patient) {
		System.out.println(patient);
		List<Patient> patientList = (List<Patient>)request.getSession().getAttribute("patientList");
		System.out.println("当前操作人员列表："+patientList);
		response.setCharacterEncoding("utf-8");
		try {
			patientList.add(0,patient);
			response.getWriter().print(ResponseTools.returnMsgAndBack("添加成功"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("patientList", patientList);
		modelAndView = new ModelAndView("WEB-INF/medical_workstation/patient_list");
		modelAndView.addObject("patientList",patientList);
		return modelAndView;
	}
	
	/*
	 * 导入体检人员，开单
	 */
	@RequestMapping(value="/importFile.handle",method = RequestMethod.GET)
	public ModelAndView importFile(HttpServletRequest request, String file_id) {
		//得到文件信息
		companyFile = companyFileBiz.queryFile(file_id);
		
		//得到文件
		File cfile = new File(companyFile.getFpath());
		System.out.println(cfile.getName());
		// 创建列表
		List<Patient> patientList = new ArrayList<>();
		// 创建excel工作区间
		Workbook wb = null;
		// 创建列存储空间
		List<String> dataList = new ArrayList<>();
		// 判断文件是否存在，并且必须是文件
		if (cfile.exists() && cfile.isFile()) {
			// 获取后缀
			String[] suffix = cfile.getName().split("\\.");
			// 分析后缀，确定打开方式
			try {
				if (suffix[1].equals("xls")) {
					wb = new HSSFWorkbook(new FileInputStream(cfile));
				} else if (suffix[1].equals("xlsx")) {
					wb = new XSSFWorkbook(cfile);
				} else {
					System.out.println("文件类型错误");
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 开始解析，读取第一页
			Sheet sheet = wb.getSheetAt(0);
			// 第一行是列名，所以不读
			int firstRowIndex = sheet.getFirstRowNum() + 1;
			int lastRowIndex = sheet.getLastRowNum();
			// 循环获取
			for (int i = firstRowIndex; i <= lastRowIndex; i++) {
				// 遍历每一行
				Row row = sheet.getRow(i);
				if (row != null) {
					// 获取总列数
					int colFirst = row.getFirstCellNum();
					int colLast = row.getLastCellNum();
					// 清空列存储
					dataList.clear();
					// 遍历每一列，如果列有空则进入下一行
					boolean isNull = false;
					for (int c = colFirst; c < colLast; c++) {
						Cell cell = row.getCell(c);
						if (cell.toString().equals("")) {
							isNull = true;
							break;
						} else if (cell != null) {
							dataList.add(cell.toString());
						}
					}
					// 如果列为空就下次循环
					if (isNull) {
						System.out.println("文档有空值");
						continue;
					} else {
						System.out.println(dataList);
						// 添加进数据
						patientList.add(new Patient(-1, // 病人id
								companyFile.getCompany_id(), // 公司id
								-1, // 套餐id
								dataList.get(0), // 姓名
								dataList.get(1), // 性别
								dataList.get(2), // 年龄
								dataList.get(3), // 身份证号
//												code, 					//条形码
								"-1", dataList.get(4), // 电话号码
								"-1", dataList.get(5) // 套餐名
						));
					}
				}
			}
			try {
				wb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(patientList);
			request.getSession().setAttribute("fid", file_id);
			request.getSession().setAttribute("patientList", patientList);
			modelAndView = new ModelAndView("WEB-INF/medical_workstation/patient_list");
			modelAndView.addObject("patientList", patientList);
			return modelAndView;
		} else {
			System.out.println("文件不存在");
			return null;
		}
		
	}
	
	
	/*
	 * 获取文件列表
	 */
	@RequestMapping(value = "/getFileList.handle", method = RequestMethod.GET)
	public ModelAndView getFileList() {
		List<CompanyFile> fileList = companyFileBiz.queryPassFileList();
		System.out.println(fileList);
		modelAndView = new ModelAndView("WEB-INF/medical_workstation/file-list");
		modelAndView.addObject("fileList", fileList);
		return modelAndView;
	}
	
	/*
	 * 通过审核
	 */
	@RequestMapping(value="/passFile.handle",method=RequestMethod.POST)
	public String passFile(HttpServletResponse response, String fid) {
		
		response.setCharacterEncoding("utf-8");
		try {
			if (companyFileBiz.updateFileState(Integer.parseInt(fid))) {
				response.getWriter().print("审核通过");
			} else {
				response.getWriter().print("审核失败，请联系管理员");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*
	 * 审核文件内容
	 */
	@RequestMapping(value="/checkFile.handle",method=RequestMethod.GET)
	public ModelAndView checkFile(HttpServletRequest request, HttpServletResponse response, String fid) {
		companyFile = companyFileBiz.queryFile(fid);
		System.out.println("审核文件"+companyFile.getFname());
		//得到文件
		File cfile = new File(companyFile.getFpath());
		System.out.println(cfile.getName());
		//创建列表
		List<Patient> patientList = new ArrayList<>();
		//创建excel工作区间
		Workbook wb = null;
		//创建列存储空间
		List<String> dataList = new ArrayList<>();
		//判断文件是否存在，并且必须是文件
		if (cfile.exists()&&cfile.isFile()) {
			//获取后缀
			String [] suffix = cfile.getName().split("\\.");
			//分析后缀，确定打开方式
			try {
				if (suffix[1].equals("xls")) {
					wb = new HSSFWorkbook(new FileInputStream(cfile));
				} else if (suffix[1].equals("xlsx")) {
					wb = new XSSFWorkbook(cfile);
				} else {
					System.out.println("文件类型错误");
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//开始解析，读取第一页
			Sheet sheet = wb.getSheetAt(0);
			//第一行是列名，所以不读
			int firstRowIndex = sheet.getFirstRowNum() + 1;
			int lastRowIndex = sheet.getLastRowNum();
			//循环获取
			for (int i = firstRowIndex; i <= lastRowIndex; i++) {
				//遍历每一行
				Row row = sheet.getRow(i);
				if (row!=null) {
					//获取总列数
					int colFirst = row.getFirstCellNum();
					int colLast = row.getLastCellNum();
					//清空列存储
					dataList.clear();
					//遍历每一列，如果列有空则进入下一行
					boolean isNull = false;
					for (int c = colFirst; c < colLast; c++) {
						Cell cell = row.getCell(c);
						if (cell.toString().equals("")) {
							isNull=true;
							break;
						} else if (cell != null) {
							dataList.add(cell.toString());
						}
					}
					//如果列为空就下次循环
					if (isNull) {
						System.out.println("文档有空值");
						continue;
					}else {
						System.out.println(dataList);
						//添加进数据
						patientList.add(
								new Patient(
										-1, 					//病人id
										companyFile.getCompany_id(), 	//公司id
										-1, 					//套餐id
										dataList.get(0), 		//姓名
										dataList.get(1),		//性别
										dataList.get(2), 		//年龄
										dataList.get(3), 		//身份证号
//										code, 					//条形码
										"-1",					
										dataList.get(4), 		//电话号码
										"-1",
										dataList.get(5)			//套餐名
								)
						);
					}
				}
			}
			try {
				wb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(patientList);
			request.getSession().setAttribute("fid", fid);
			request.getSession().setAttribute("patientList", patientList);
			modelAndView = new ModelAndView("WEB-INF/medical_workstation/check-patient");
			modelAndView.addObject("patientList",patientList);
			return modelAndView;
		} else {
			System.out.println("文件不存在");
			return null;
		}
		
	}
	
	
	/*
	 * 查询待审核文件
	 */
	@RequestMapping(value="/queryCheckFile.handle",method=RequestMethod.GET)
	public ModelAndView queryCheckFile(String pageNum) {
		List<CompanyFile> fileList = nurseBiz.queryCheckFile(pageNum);
		modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/medical_workstation/wait-check-file");
		modelAndView.addObject("fileList",fileList);
		return modelAndView;
	}
	
	
	/*
	 * 	体检工作站用户登录
	 */
	@RequestMapping(value = "/loginUser.handle", method = RequestMethod.POST)
	public ModelAndView companyLogin(HttpServletRequest request, 
			HttpServletResponse response, 
			String account,
			String pwd) {
		System.out.println("用户登录" + account);
		Nurse nurse = nurseBiz.queryNurseBylogin(account, pwd);
		modelAndView = new ModelAndView();
		if (nurse != null) {
			System.out.println("登录成功"+nurse);
			//网站路径
			String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/";
			
			//设置属性
			request.getSession().setAttribute("path", path);
			request.getSession().setAttribute("user", nurse);
			
			//设置地址和模型
			modelAndView.setViewName("WEB-INF/medical_workstation/index");
			return modelAndView;
		} else {
			try {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().println(ResponseTools.returnMsgAndBack("用户或者密码错误"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

	}
	
}
