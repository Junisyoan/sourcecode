package xyz.cymedical.handle.jun;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jbarcode.util.ImageUtil;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.ctx.LogCompanyBiz;
import xyz.cymedical.biz.ctx.PatientBiz;
import xyz.cymedical.biz.jun.BillerBiz;
import xyz.cymedical.biz.jun.CompanyBiz;
import xyz.cymedical.biz.jun.CompanyFileBiz;
import xyz.cymedical.biz.jun.GroupBiz;
import xyz.cymedical.biz.jun.InvalideBiz;
import xyz.cymedical.biz.jun.NurseBiz;
import xyz.cymedical.biz.xin.DoctorBiz;
import xyz.cymedical.biz.zsc.ComboBiz;
import xyz.cymedical.entity.jun.Biller;
import xyz.cymedical.entity.jun.Company;
import xyz.cymedical.entity.jun.CompanyFile;
import xyz.cymedical.entity.jun.Group;
import xyz.cymedical.entity.jun.Invalide;
import xyz.cymedical.entity.jun.Nurse;
import xyz.cymedical.entity.jun.Patient;
import xyz.cymedical.entity.xin.Combo;
import xyz.cymedical.entity.xin.News;
import xyz.cymedical.tools.jun.BarCodeTools;
import xyz.cymedical.tools.jun.ExcelTools;
import xyz.cymedical.tools.jun.ResponseTools;

/**
*	@author Junisyoan;
*	日期：2019年1月28日
*	时间：下午2:17:14
*	类说明：体检工作站人员操作系列
*/

@Controller
@RequestMapping("/nurse")
public class NurseHandle {

	@Resource
	private CompanyBiz companyBiz;
	
	@Resource
	private LogCompanyBiz logCompanyBiz;
	
	@Resource
	private CompanyFileBiz companyFileBiz;
	
	@Resource
	private NurseBiz nurseBiz;
	
	@Resource
	private GroupBiz groupBiz;
	
	@Resource
	private BillerBiz billerBiz;
	
	@Resource
	private PatientBiz patientBiz;
	
	@Resource
	private ComboBiz comboBiz;
	
	@Resource
	private InvalideBiz invalideBiz;
	
	private ModelAndView modelAndView;
	private CompanyFile companyFile;
	
	
	private List<Map<String,Object>> plist; //项目列表
	
	@Resource
	private DoctorBiz doctorbiz;//医生业务
	
	private String mycode;
	
	private boolean isExsit;
	
	
	/*
	 * 删除不合格文件
	 */
	@RequestMapping(value="/delInvalide.handle",method=RequestMethod.POST)
	public @ResponseBody String delInvalide(String fid) {
		System.out.println("删除文件："+fid);
		
		String strRet = "";
		//先删除文件
		CompanyFile companyFile =companyFileBiz.queryFile(fid);
		if (companyFile!=null) {
			File file = new File(companyFile.getFpath());
			if (file.exists()) {
				System.out.println("删除文件："+file.delete());
			}
			
			if (invalideBiz.delete(Integer.parseInt(fid))) {
				strRet="1";
			}else {
				strRet="0";
			}
		}else {
			strRet="-1";
		}
		return strRet;
	}
	
	
	/*
	 * 查看不合格文件列表
	 */
	@RequestMapping(value="/getInvalideFile.handle",method=RequestMethod.GET)
	public ModelAndView getInvalideFile() {
		List<CompanyFile> invalides = invalideBiz.queryInvalide();
		System.out.println(invalides);
		modelAndView=new ModelAndView("WEB-INF/medical_workstation/invalide-file");
		modelAndView.addObject("invalides", invalides);
		return modelAndView;
	}
	
	//退出
		@RequestMapping(value = "/exit.handle")
		public void brief(HttpServletRequest request,HttpServletResponse resp) {
			String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
			//退出时销毁登录信息
			request.getSession().invalidate();
			System.out.println("已销毁用户");
			try {
				resp.sendRedirect(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	/*
	 * 已开单账单再次开单
	 */
	@RequestMapping(value="/getCheckPage.handle",method=RequestMethod.GET)
	public ModelAndView getCheckPage(String bid) {
		System.out.println("打印导检单："+bid);
		List<Patient> cps = nurseBiz.getCheckPage(bid);
		
		companyFile = companyFileBiz.queryFileByBillerId(bid);
		String path = companyFile.getFpath();
		File file = new File(path);
		//生成条形码
		String imgFormat = "jpeg";
		for(int i = 0;i<cps.size();i++) {
			BarCodeTools.createBarCode(file.getPath(), cps.get(i).getCode(), imgFormat);
		}
		
		System.out.println("体检人员信息："+cps);
		HashMap<String, List<Patient>> checkMap = new HashMap<>();
		List<Patient> tmpList = new ArrayList<>();
		String tmpName = cps.get(0).getName();
		String ctime = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());
		for(int i = 0;i<cps.size();i++) {
			if (!tmpName.equals(cps.get(i).getName())) {
				checkMap.put(tmpName, tmpList);
				tmpName=cps.get(i).getName();
				tmpList = new ArrayList<>();
			}
			tmpList.add(cps.get(i));
			if (i==cps.size()-1) {
				checkMap.put(cps.get(i).getName(), tmpList);
			}
		}
		
		for(String n:checkMap.keySet()) {
			System.out.println(n+"--"+checkMap.get(n));
		}
		
		modelAndView = new ModelAndView("WEB-INF/medical_workstation/print-check");
		modelAndView.addObject("checkMap", checkMap);
		modelAndView.addObject("ctime", ctime);
		return modelAndView;
	}
	
	/*
	 * 查询已开单列表
	 */
	@RequestMapping(value="/getCreateList.handle",method=RequestMethod.GET)
	public ModelAndView getCreateList(){
		List<Biller> billerList = billerBiz.queryBillerListByCreate("已开单");
		System.out.println("查询已开单列表："+billerList);
		modelAndView = new ModelAndView("WEB-INF/medical_workstation/create-list");
		modelAndView.addObject("billerList", billerList);
		return modelAndView;
	}
	
	/*
	 * 账单生成导检单
	 */
	@RequestMapping(value="/createCheckList.handle",method=RequestMethod.POST)
	public String createCheckList(
			HttpServletResponse response,
			HttpServletRequest request,
			String bid) {
		
		response.setCharacterEncoding("utf-8");
		System.out.println("生成导检单："+bid);
		//取得文件信息
		companyFile = companyFileBiz.queryFileByBillerId(bid);
		
		//	获取体检人员列表
		List<Patient> patientList = ExcelTools.getPatientList(companyFile,comboBiz.findCombos());
		System.out.println(patientList);
		//获得公司存储路径
		String path = companyFile.getFpath();
		File file = new File(path);
		path = file.getPath();
		
		//生成条形码
		String imgFormat = ImageUtil.JPEG;
		for(int i = 0;i<patientList.size();i++) {
			BarCodeTools.createBarCode(path, patientList.get(i).getCode(), imgFormat);
		}
		System.out.println("条形码生成成功");
		//体检号
		Object obj=request.getServletContext().getAttribute("CN");
		int cn = 0;
		if (obj==null) {
			cn = 1;
		}
		for (Patient patient : patientList) {
			patient.setCheck_num(String.format("%08d", cn));
		}
		
		try {
			//	插入病人
			List<Patient> pList = patientBiz.insertByBatch(patientList);
			
			if (pList!=null) {
				//	创建关系表
				if (nurseBiz.insertRelation(Integer.parseInt(bid), pList)
						&& billerBiz.updateBillerCreate(bid)
						&& nurseBiz.insertPaitentCombo(pList,bid)) {
					
					String time = "2018-08-08";
					nurseBiz.insertPaitentProject(pList,time);
					
					response.getWriter().print("1");
					
					
					
				} else {
					response.getWriter().print("0");
				}
			}else {
				response.getWriter().print("0");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 获取未开单列表
	 */
	@RequestMapping(value="/getNoCreateList.handle",method=RequestMethod.GET)
	public ModelAndView getNoCreateList() {
		List<Biller> billerList = billerBiz.queryBillerListByCreate("未开单");
		System.out.println("查询未开单列表："+billerList);
		modelAndView = new ModelAndView("WEB-INF/medical_workstation/no-create-list");
		modelAndView.addObject("billerList", billerList);
		return modelAndView;
	}
	
	/*
	 * 删除未结算账单
	 */
	@RequestMapping(value="/delBiller.handle",method=RequestMethod.POST)
	public String delBiller(String bid,HttpServletResponse response) {
		System.out.println("删除账单id："+bid);
		boolean isSuccess = billerBiz.delBiller(bid);
		
		try {
			if (isSuccess) {
				response.getWriter().print("1");
			}else {
				response.getWriter().print("0");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 获取未结算的账单
	 */
	@RequestMapping(value="/getBillerNoPay.handle",method=RequestMethod.GET)
	public ModelAndView getBillerNoPay(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("查询未结算账单");
		List<Biller> billerList = billerBiz.queryBillerList("未结算");
		System.out.println(billerList);
		modelAndView = new ModelAndView("WEB-INF/medical_workstation/biller_list_nopay");
		modelAndView.addObject("billerList", billerList);
		return modelAndView;
		
	}
	
 	/*
	 * 全部生成账单
	 */
	@RequestMapping(value="/allOpen.handle",method=RequestMethod.POST)
	public String allOpen(HttpServletResponse response,HttpServletRequest request,String fid) {
		
		response.setCharacterEncoding("utf-8");
		//取得文件信息
		companyFile = companyFileBiz.queryFile(fid);
		//查询团检表是否存在，不存在则是未通过审核
		if (groupBiz.queryGroupByFileId(Integer.parseInt(fid))==null) {
			try {
				response.getWriter().print("团检表不存在");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		@SuppressWarnings("unchecked")
		//体检人员列表
		List<Patient> patientList = (List<Patient>)request.getSession().getAttribute("patientList");
		//获取所有人的套餐数量
		HashMap<String, Integer> map = new HashMap<>();
		//基本套餐数量一
		int iCombo = 1;	
		//计算套餐数量
		for (int i = 0; i < patientList.size(); i++) {
			//如果这个套餐不存在
			if (map.get(patientList.get(i).getComboName()) == null) {
				//放进去
				map.put(patientList.get(i).getComboName(), iCombo);
			} else {
				//套餐已经存在，取出，加一
				iCombo=map.get(patientList.get(i).getComboName())+1;
				map.put(patientList.get(i).getComboName(), iCombo);
			}
		}
		System.out.println("一共"+map.keySet().size()+"种套餐");
		
		//套餐信息
		Combo combo = null;
		List<Combo> comboList = new ArrayList<>();
		//套餐数量
		int iComboNum = 0;
		//计算套餐价格
		float price = 0.0f;
		for (int j = 0; j < map.keySet().size(); j++) {
			if (map.keySet().iterator().hasNext()) {
				//取得套餐价格
				combo = nurseBiz.queryComboByName(map.keySet().iterator().next());
				//如果套餐不存在，就添加进列表，存在则不添加
				if (!comboList.contains(combo)) {
					comboList.add(combo);
				}
				//套餐数量
				iComboNum = map.get(map.keySet().iterator().next());
				//套餐价格
				price += combo.getPrice()*iComboNum;
			}
		}
		
		System.out.println("总价："+price);
		
		try {
			//	修改团检表
			boolean isSuccess = groupBiz.updateGroupInfo(Integer.parseInt(fid), patientList.size(), price);
			if (isSuccess) {
				System.out.println("修改团检表成功");
			}else {
				System.out.println("修改团检表失败");
				response.getWriter().print("团检表生成失败");
				return null;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//	当天时间
//			String strTime = sdf.format(System.currentTimeMillis());
			
			//	生成记账表和批次，批次就是当天的日期
			sdf.applyPattern("yyyyMMddHHmmss");
			String strBatch = sdf.format(System.currentTimeMillis());	//批次
			
			//	获得团检表信息
			Group group = groupBiz.queryGroupByFileId(Integer.parseInt(fid));
			System.out.println(group);
			isSuccess = billerBiz.insertBiller(group.getGroup_id(), "未结算", strBatch,price);
			if (isSuccess) {
				System.out.println("生成记账表");
				response.getWriter().print("1");
			}else {
				System.out.println("账单生成失败");
				response.getWriter().print("0");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 体检列表
	 */
	@RequestMapping(value="/getList.handle",method=RequestMethod.GET)
	public ModelAndView getList(HttpServletRequest request) {
		System.out.println(request.getSession().getAttribute("patientList"));
		modelAndView = new ModelAndView("WEB-INF/medical_workstation/patient_list");
		modelAndView.addObject("patientList",request.getSession().getAttribute("patientList"));
		return modelAndView;
	}
	
	/*
	 * 删除体检人员
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/delPatient.handle",method=RequestMethod.POST)
	public @ResponseBody String delPatient(HttpServletRequest request, String id) {
		List<Patient> list = (List<Patient>) request.getSession().getAttribute("patientList");
		System.out.println(list.remove(Integer.parseInt(id)-1));
		String str = "1";
		request.getSession().setAttribute("patientList", list);
		return str;
		
	}

	/*
	 * 修改体检人员
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/updatePatient.handle",method=RequestMethod.POST)
	public @ResponseBody String updatePatient(HttpServletRequest request, 
			HttpServletResponse response, 
			Patient patient,
			String id) {
		List<Patient> patientList = (List<Patient>)request.getSession().getAttribute("patientList");
		System.out.println("当前操作人员列表："+patientList);
		System.out.println("修改人员："+patient);
		response.setCharacterEncoding("utf-8");
		String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath() + "/";
		boolean isSuccess =false;
		try {
			//比对身份证是否存在
			if (patientBiz.queryID(patient.getID())!=null) {
				response.getWriter().print(ResponseTools.returnMsgAndRedirect("身份证存在", "<%=path%>nurse/getList.handle"));
				isSuccess=false;
			//比对手机号码是否存在
			} else if(patientBiz.queryPhone(patient.getPhone())!=null){
				response.getWriter().print(ResponseTools.returnMsgAndRedirect("手机号码存在", path+"nurse/getList.handle"));
				isSuccess=false;
			//比对套餐是否存在
			} else if(comboBiz.queryComboByName(patient.getComboName())){
				response.getWriter().print(ResponseTools.returnMsgAndRedirect("套餐不存在", path+"nurse/getList.handle"));
				isSuccess=false;
			}else {
				//比对其他人
				for (Patient p : patientList) {
					if (p.getPhone().equals(patient.getPhone())) {
						response.getWriter().print(ResponseTools.returnMsgAndRedirect("手机号码重复", path+"nurse/getList.handle"));
						isSuccess=false;
						break;
					} else if(p.getID().equals(patient.getID())){
						response.getWriter().print(ResponseTools.returnMsgAndRedirect("身份证号码重复", path+"nurse/getList.handle"));
						isSuccess=false;
						break;
					}else {
						isSuccess=true;
					}
				}
			}
			if (isSuccess) {
				System.out.println(id);
				patientList.get(Integer.parseInt(id)-1).setName(patient.getName());
				patientList.get(Integer.parseInt(id)-1).setSex(patient.getSex());
				patientList.get(Integer.parseInt(id)-1).setAge(patient.getAge());
				patientList.get(Integer.parseInt(id)-1).setID(patient.getID());
				patientList.get(Integer.parseInt(id)-1).setPhone(patient.getPhone());
				patientList.get(Integer.parseInt(id)-1).setComboName(patient.getComboName());
				response.getWriter().print(ResponseTools.returnMsgAndRedirect("修改成功",path+"nurse/getList.handle"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("patientList", patientList);
		
		return null;
	}
	
	/*
	 * 添加体检人员
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/addPatient.handle",method=RequestMethod.POST)
	public @ResponseBody String addPatient(HttpServletRequest request, HttpServletResponse response, Patient patient) {
		System.out.println(patient);
		String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath() + "/";
		List<Patient> patientList = (List<Patient>)request.getSession().getAttribute("patientList");
		System.out.println("当前操作人员列表："+patientList);
		response.setCharacterEncoding("utf-8");
		try {
			patientList.add(0,patient);
			response.getWriter().print(ResponseTools.returnMsgAndRedirect("添加成功", path+"nurse/getList.handle"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("patientList", patientList);
		return null;
	}
	
	/*
	 * 导入体检人员
	 */
	@RequestMapping(value="/importFile.handle",method = RequestMethod.GET)
	public ModelAndView importFile(HttpServletRequest request, String file_id) {
		//得到文件信息
		companyFile = companyFileBiz.queryFile(file_id);
		//得到文件
		File cfile = new File(companyFile.getFpath());
		System.out.println(cfile.getName());
		//人员临时id
		int num=0;
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
							cell.setCellType(CellType.STRING);
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
						patientList.add(new Patient(num, // 病人id
								companyFile.getCompany_id(), // 公司id
								-1, // 套餐id
								dataList.get(0), // 姓名
								dataList.get(1), // 性别
								dataList.get(2), // 年龄
								dataList.get(3), // 身份证号
								"-1", 
								dataList.get(4), // 电话号码
								"-1", 
								dataList.get(5) // 套餐名
						));
						num++;
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
	 * 审核不通过
	 */
	@RequestMapping(value="/invalidFile.handle",method=RequestMethod.POST)
	public String invalidFile(HttpServletResponse response, HttpServletRequest request,String fid) {
		System.out.println("文件审核不通过："+fid);
		@SuppressWarnings("unchecked")
		List<Patient> patients =(List<Patient> ) request.getSession().getAttribute("patientList");
		for (Iterator<Patient> iterator = patients.iterator(); iterator.hasNext();) {
			Patient patient = (Patient) iterator.next();
			if (patient.getCheck_num()!=null||!patient.getCheck_num().equals("")) {
				Invalide invalide = new Invalide();
				invalide.setFile_id(Integer.valueOf(fid));
				invalide.setName(patient.getName());
				invalide.setReason(patient.getCheck_num());
				isExsit = invalideBiz.insert(invalide);
				System.out.println("插入不合格信息结果："+isExsit);
			}
		}
		
		
		response.setCharacterEncoding("utf-8");
		try {
			if(companyFileBiz.updateFileState(Integer.parseInt(fid),"不合格")){
				response.getWriter().print("1");
			}else {
				response.getWriter().print("0");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 通过审核
	 */
	@RequestMapping(value="/passFile.handle",method=RequestMethod.POST)
	public String passFile(HttpServletResponse response, String fid) {
		
		response.setCharacterEncoding("utf-8");
		try {
			if (companyFileBiz.updateFileState(Integer.parseInt(fid),"已审核")) {
				//获得文件具体信息
				companyFile = companyFileBiz.queryFile(fid);
				//得到公司id
				int cid = companyFile.getCompany_id();
				//创建团检表，以及关联表
				if(groupBiz.createGroup(cid, Integer.parseInt(fid))){
					System.out.println("创建团检表成功");
				}else {
					System.out.println("创建团检表失败");
				}
				
				response.getWriter().print("1");
			} else {
				response.getWriter().print("0");
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
		
		ExcelTools.getPatientList(companyFile);
		System.out.println("审核文件"+companyFile.getFname());
		//得到文件
		File cfile = new File(companyFile.getFpath());
		System.out.println(cfile.getName());
		//创建列表
		List<Patient> patientList = new ArrayList<>();
		
//		//创建excel工作区间
//		Workbook wb = null;
//		//创建列存储空间
//		List<String> dataList = new ArrayList<>();
		//判断文件是否存在，并且必须是文件
		if (cfile.exists()&&cfile.isFile()) {
//			//获取后缀
//			String [] suffix = cfile.getName().split("\\.");
//			//分析后缀，确定打开方式
//			try {
//				if (suffix[1].equals("xls")) {
//					wb = new HSSFWorkbook(new FileInputStream(cfile));
//				} else if (suffix[1].equals("xlsx")) {
//					wb = new XSSFWorkbook(cfile);
//				} else {
//					System.out.println("文件类型错误");
//				}
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (InvalidFormatException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			//	开始解析，读取第一页
//			Sheet sheet = wb.getSheetAt(0);
//			//	第一行是列名，所以不读
//			int firstRowIndex = sheet.getFirstRowNum() + 1;
//			int lastRowIndex = sheet.getLastRowNum();
//			//	循环获取
//			for (int i = firstRowIndex; i <= lastRowIndex; i++) {
//				//	遍历每一行
//				Row row = sheet.getRow(i);
//				if (row!=null) {
//					//	获取总列数
//					int colFirst = row.getFirstCellNum();
//					int colLast = row.getLastCellNum();
//					//	清空列存储
//					dataList.clear();
//					//	遍历每一列，如果列有空则进入下一行
//					boolean isNull = false;
//					for (int c = colFirst; c < colLast; c++) {
//						Cell cell = row.getCell(c);
//						if (cell.toString().equals("")) {
//							isNull=true;
//							break;
//						} else if (cell != null) {
//							cell.setCellType(CellType.STRING);
//							dataList.add(cell.toString());
//						}
//					}
//					//	如果列为空就下次循环
//					if (isNull) {
//						System.out.println("文档有空值");
//						continue;
//					}else {
//						System.out.println(dataList);
//						//	添加进数据
//						patientList.add(
//								new Patient(
//										-1, 					//	病人id
//										companyFile.getCompany_id(), 	//	公司id
//										-1, 					//	套餐id
//										dataList.get(0), 		//	姓名
//										dataList.get(1),		//	性别
//										dataList.get(2), 		//	年龄
//										dataList.get(3), 		//	身份证号
//										"-1",					
//										dataList.get(4), 		//	电话号码
//										"-1",
//										dataList.get(5)			//	套餐名
//								)
//						);
//					}
//				}
//			}
//			try {
//				wb.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			patientList = ExcelTools.getPatientList(companyFile);
			System.out.println(patientList);
			
			
			StringBuilder strState= new StringBuilder();
			Patient p=null;
			System.out.println("开始查询是否符合");
			for (Patient patient : patientList) {
				strState.setLength(0);
				isExsit = comboBiz.queryComboByName(patient.getComboName());
				if (!isExsit) {
					strState.append("套餐不存在-");
				}
				p=patientBiz.queryID(patient.getID());
				if (p!=null) {
					isExsit = patient.getName().equals(p.getName());
					if (!isExsit) {
						strState.append("身份证重复-");
					}
				}
				p=patientBiz.queryPhone(patient.getPhone());
				if (p!=null) {
					isExsit = patient.getName().equals(p.getName());
					if (!isExsit) {
						strState.append("手机号码重复-");
					}
				}
				patient.setCheck_num(strState.toString());
			}
			System.out.println("查询结束");
			
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
	public ModelAndView queryCheckFile() {
		List<CompanyFile> fileList = nurseBiz.queryCheckFile("未审核");
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
			request.getSession().setAttribute("nurse", nurse);
			
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
	
	
	
	/*
	 * toRefund xinyang
	 */
	@RequestMapping(value = "/toRefund.handle")
	public ModelAndView toRefund(HttpServletRequest req) {
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/Refund_receive");
		return mav;
	}
	/*
	 * findProject xinyang
	 */
	// 查询一维码对应病人的导检单
		@RequestMapping(value = "/findProject.handle")
		public ModelAndView findProject(String onecode) {

			mycode=onecode;
			System.out.println("onecode=" + onecode);
			System.out.println(doctorbiz.findMyProject(onecode));
			
			String flag="无需退费";//初始化flag，用于控制状态
			
			//根据条码获取项目列表
			plist=doctorbiz.findMyProject(onecode);
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("prolist", plist);
			
			if(plist!=null && plist.size()>0) {
				
				//若存在退费项目，返回false
				for (int i = 0; i < plist.size(); i++) {
					
					if(plist.get(i).get("state").equals("未接收")) {
						flag="可退费";
						break;
					}
					
					
					if(plist.get(i).get("balance").equals("已退费")) {
						flag="已退费";
						break;
					}
				}
				
				mav.addObject("flag", flag);
				mav.addObject("patient", plist.get(0));//该列表已包含病人信息
			}
			mav.setViewName("WEB-INF/medical_workstation/Refund_receive");
			return mav;

		}
		
		
		//退费操作
		@RequestMapping(value = "/Refund.handle")
		public ModelAndView Refund() {
			
			//根据条码获取项目列表
			plist=doctorbiz.findMyProject(mycode);
			System.out.println("plist2="+plist);
			//初始化退费金额
			Double sum = 0.0;
			
			for (int i = 0; i < plist.size(); i++) {
				Map m=plist.get(i);
				if(m.get("state").equals("未接收")) {
					
					//将已结算项目改为已退费项目
					Integer id=Integer.parseInt(m.get("patient_project_id").toString());
					System.out.println(id);
					doctorbiz.BalanceChange(id);
					
					//累计未接收项目的金额
					sum=sum+Double.parseDouble(m.get("price").toString());
				}
			}
			
			System.out.println("sum="+sum);
			
			//找到公司信息
			int id=Integer.parseInt(plist.get(0).get("company_id").toString());
			Company company=companyBiz.findCompany(id);
			
			//当前余额
			double deposit=company.getDeposit();
			deposit=deposit+sum;
			
			companyBiz.Refund(company.getCompany_id(),deposit);
			
			//根据条码获取项目列表
			plist=doctorbiz.findMyProject(mycode);
			
			//插入日志
			logCompanyBiz.insertLog(company.getCompany_id(),    
					"退费", 
					""+sum, 
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("prolist", plist);
			mav.addObject("flag", "已退费");
			mav.addObject("patient", plist.get(0));
			
			mav.setViewName("WEB-INF/medical_workstation/Refund_receive");
			return mav;

		}
	
		@RequestMapping(value = "/home.handle")
		public ModelAndView turnhome() {

			ModelAndView mav = new ModelAndView();
			mav.setViewName("WEB-INF/medical_workstation/index");
			return mav;

		}
		
		@RequestMapping(value = "/systemhome.handle")
		public ModelAndView turnsystemhome() {

			ModelAndView mav = new ModelAndView();
			mav.setViewName("WEB-INF/medical_workstation/welcome");
			return mav;

		}
		
		
		
		
	
}
