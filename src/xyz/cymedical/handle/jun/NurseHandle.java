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
import java.util.Set;

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

import oracle.net.aso.i;
import xyz.cymedical.biz.ctx.LogCompanyBiz;
import xyz.cymedical.biz.ctx.PatientBiz;
import xyz.cymedical.biz.jun.BillerBiz;
import xyz.cymedical.biz.jun.CompanyBiz;
import xyz.cymedical.biz.jun.CompanyFileBiz;
import xyz.cymedical.biz.jun.GroupBiz;
import xyz.cymedical.biz.jun.NurseBiz;
import xyz.cymedical.biz.zsc.ComboBiz;
import xyz.cymedical.entity.jun.Biller;
import xyz.cymedical.entity.jun.CompanyFile;
import xyz.cymedical.entity.jun.Group;
import xyz.cymedical.entity.jun.Nurse;
import xyz.cymedical.entity.jun.Patient;
import xyz.cymedical.entity.xin.Combo;
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
	
	private ModelAndView modelAndView;
	private CompanyFile companyFile;
	
	/*
	 * 已开单账单再次开单
	 */
	@RequestMapping(value="/getCheckPage.handle",method=RequestMethod.GET)
	public ModelAndView getCheckPage(String bid) {
		System.out.println("打印导检单："+bid);
		List<Patient> cps = nurseBiz.getCheckPage(bid);
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
			System.out.println(cps.get(i));
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
		//取得文件信息
		companyFile = companyFileBiz.queryFileByBillerId(bid);
		
		//	获取体检人员列表
		List<Patient> patientList = ExcelTools.getPatientList(companyFile,comboBiz.findCombos());
		
		try {
			//	插入病人
			List<Patient> pList = patientBiz.insertByBatch(patientList);
			
			if (pList!=null) {
				//	创建关系表
				if (nurseBiz.insertRelation(Integer.parseInt(bid), pList)&&
						billerBiz.updateBillerCreate(bid)) {
					//	修改记账表为开单
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
	 * 选中开单
	 */
//	@RequestMapping(value="/chooseOpen.handle",method=RequestMethod.POST)
//	public String chooseOpen(
//			HttpServletResponse response,
//			HttpServletRequest request,
//			String data,
//			String fid) {
//		System.out.println("选中开单的人员序号"+data);
//		String [] strData = data.split(",");
//		
//		//人员列表
//		List<Patient> patientList = (List<Patient>)request.getSession().getAttribute("patientList");
//		System.out.println("所有人员列表"+patientList);
//		//获得选中人员
//		List<Patient> chooseList = new ArrayList<>();
//		for(int i =0;i<patientList.size();i++) {
//			for(int j =0;j<strData.length;j++) {
//				if (patientList.get(i).getPaitent_id()==Integer.parseInt(strData[j])) {
//					chooseList.add(patientList.get(i));
//					break;
//				}
//			}
//		}
//		System.out.println("选中的人员"+chooseList);
//		
//		//获取所有人的套餐数量
//		HashMap<String, Integer> map = new HashMap<>();
//		// 基本套餐数量一
//		int iCombo = 1;
//		// 计算套餐数量
//		for (int i = 0; i < chooseList.size(); i++) {
//			// 如果这个套餐不存在
//			if (map.get(chooseList.get(i).getComboName()) == null) {
//				// 放进去
//				map.put(chooseList.get(i).getComboName(), iCombo);
//			} else {
//				// 套餐已经存在，取出，加一
//				iCombo = map.get(chooseList.get(i).getComboName())+1;
//				map.put(chooseList.get(i).getComboName(), iCombo);
//			}
//		}
//		System.out.println("一共" + map.keySet().size() + "种套餐，套餐数量"+iCombo);
//
//		// 套餐信息
//		Combo combo = null;
//		List<Combo> comboList = new ArrayList<>();
//		// 套餐数量
//		int iComboNum = 0;
//		// 计算套餐价格
//		float price = 0.0f;
//		for (int j = 0; j < map.keySet().size(); j++) {
//			if (map.keySet().iterator().hasNext()) {
//				// 取得套餐价格
//				combo = nurseBiz.queryComboByName(map.keySet().iterator().next());
//				// 如果套餐不存在，就添加进列表，存在则不添加
//				if (!comboList.contains(combo)) {
//					comboList.add(combo);
//				}
//				// 套餐数量
//				iComboNum = map.get(map.keySet().iterator().next());
//				// 套餐价格
//				price += combo.getPrice() * iComboNum;
//			}
//		}
//
//		System.out.println("总价：" + price);
//
//		try {
//			//修改团检表
//			boolean isSuccess = groupBiz.updateGroupInfo(Integer.parseInt(fid), patientList.size(), price);
//			if (isSuccess) {
//				System.out.println("修改团检表成功");
//			}else {
//				System.out.println("修改团检表失败");
//				response.getWriter().print("团检表生成失败");
//				return null;
//			}
//			//扣除费用
//			switch (nurseBiz.deductDeposit(patientList.get(0).getCompany_id(), price)) {
//			case "扣除成功":
//				System.out.println("扣除成功");
//				//当天时间
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				String strTime = sdf.format(System.currentTimeMillis());
//				//先插入日志
//				logCompanyBiz.insertLog(
//						patientList.get(0).getCompany_id(), 
//						"体检结算", 
//						String.valueOf(price), 
//						strTime);
//				//生成记账表和批次，批次就是当天的日期
//				sdf.applyPattern("yyyyMMdd");
//				String strBatch = sdf.format(System.currentTimeMillis());	//批次
//				//获得团检表信息
//				Group group = groupBiz.queryGroupByFileId(Integer.parseInt(fid));
//				System.out.println(group);
//				isSuccess = billerBiz.insertBiller(group.getGroup_id(), "已结算", strBatch,price);
//				if (isSuccess) {
//					System.out.println("生成记账表");
//					
//					//修改体检人员信息列表
//					for(int i =0;i<patientList.size();i++) {
//						for(int j=0;j<comboList.size();j++) {
//							//如果两个相等，就加入套餐id
//							if (patientList.get(i).getComboName().equals(comboList.get(j).getName())) {
//								patientList.get(i).setCombo_id(comboList.get(j).getCombo_id());
//								//顺便生成条形码
//								String jbarCode	 = BarCodeTools.randomNumStr(13);
//								patientList.get(i).setCode(jbarCode);
//							}
//						}
//					}
//					
//					//插入体检人员信息
//					if(patientBiz.insertByBatch(patientList)) {
//						System.out.println("体检人员信息更新成功");
//					}else {
//						System.out.println("体检人员信息更新失败");
//					}
//					
//					//查询记账表
//					Biller biller = billerBiz.queryBiller(group.getGroup_id(), strTime);
//					System.out.println(biller);
//					//插入记账病人关系表
//					isSuccess = nurseBiz.insertRelation(biller.getBiller_id(), patientList);
//					if (isSuccess) {
//						System.out.println("关系表插入成功");
//					}
//					response.getWriter().print("已生成导检单");
//				}else {
//					System.out.println("记账表生成失败");
//					response.getWriter().print("生成导检单失败");
//				}
//				
//				break;
//			case "扣除失败":
//				response.getWriter().print("费用扣除失败，请联系管理员！");
//				break;
//			case "余额不足":
//				response.getWriter().print("余额不足，请联系用户！");
//				break;
//			default:
//				break;
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

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
			//修改团检表
			boolean isSuccess = groupBiz.updateGroupInfo(Integer.parseInt(fid), patientList.size(), price);
			if (isSuccess) {
				System.out.println("修改团检表成功");
			}else {
				System.out.println("修改团检表失败");
				response.getWriter().print("团检表生成失败");
				return null;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//当天时间
//			String strTime = sdf.format(System.currentTimeMillis());
			
			//生成记账表和批次，批次就是当天的日期
			sdf.applyPattern("yyyyMMddHHmmss");
			String strBatch = sdf.format(System.currentTimeMillis());	//批次
			
			//获得团检表信息
			Group group = groupBiz.queryGroupByFileId(Integer.parseInt(fid));
			System.out.println(group);
			isSuccess = billerBiz.insertBiller(group.getGroup_id(), "未结算", strBatch,price);
			
			if (isSuccess) {
				System.out.println("生成记账表");
				
				//修改体检人员信息列表
//				for(int i =0;i<patientList.size();i++) {
//					for(int j=0;j<comboList.size();j++) {
//						//如果两个相等，就加入套餐id
//						if (patientList.get(i).getComboName().equals(comboList.get(j).getName())) {
//							patientList.get(i).setCombo_id(comboList.get(j).getCombo_id());
//							//顺便生成条形码
//							String jbarCode	 = BarCodeTools.randomNumStr(13);
//							patientList.get(i).setCode(jbarCode);
//						}
//					}
//				}
				
				//插入体检人员信息
//				if(patientBiz.insertByBatch(patientList)) {
//					System.out.println("体检人员信息更新成功");
//				}else {
//					System.out.println("体检人员信息更新失败");
//				}
				
				//查询记账表
//				Biller biller = billerBiz.queryBiller(group.getGroup_id(), strBatch);
//				System.out.println(biller);
				//插入记账病人关系表
//				isSuccess = nurseBiz.insertRelation(biller.getBiller_id(), patientList);
//				if (isSuccess) {
//					System.out.println("关系表插入成功");
//				}
				response.getWriter().print("已生成账单");
			}else {
				System.out.println("账单生成失败");
				response.getWriter().print("生成账单失败");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*
	 * 添加体检人员
	 */
	@SuppressWarnings("unchecked")
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
	 * 通过审核
	 */
	@RequestMapping(value="/passFile.handle",method=RequestMethod.POST)
	public String passFile(HttpServletResponse response, String fid) {
		
		response.setCharacterEncoding("utf-8");
		try {
			if (companyFileBiz.updateFileState(Integer.parseInt(fid))) {
				//获得文件具体信息
				companyFile = companyFileBiz.queryFile(fid);
				//得到公司id
				int cid = companyFile.getCompany_id();
				//创建团检表
				if(groupBiz.createGroup(cid, Integer.parseInt(fid))){
					System.out.println("创建团检表成功");
				}else {
					System.out.println("创建团检表失败");
				}
				
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