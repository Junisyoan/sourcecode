package xyz.cymedical.tools.jun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import xyz.cymedical.entity.jun.CompanyFile;
import xyz.cymedical.entity.jun.Patient;
import xyz.cymedical.entity.xin.Combo;

/**
 * @author Junisyoan; 
 * 日期：2019年2月3日 
 * 时间：下午6:57:22 
 * 类说明：
 */
public class ExcelTools {

	/**
	 * 解析excel得到人员具体信息
	 * 
	 * @param companyFile 文件
	 * @param combos	套餐列表
	 * @return 人员信息列表
	 */
	public static List<Patient> getPatientList(CompanyFile companyFile,List<Combo> combos) {
		// 得到文件
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
			
			//套餐id
			int combo_id=-1;
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
					
						//查询套餐id
						for(int j=0;j<combos.size();j++) {
							if (combos.get(j).getName().equals(dataList.get(5))) {
								combo_id=combos.get(j).getCombo_id();
								break;
							}
						}
						
						//生成条码
						String code = BarCodeTools.randomNumStr(13);
						// 添加进数据
						patientList.add(
								new Patient(
									-1, // 病人id
									companyFile.getCompany_id(), // 公司id
									combo_id, // 套餐id
									dataList.get(0), // 姓名
									dataList.get(1), // 性别
									dataList.get(2), // 年龄
									dataList.get(3), // 身份证号
									code, 			 // 条码号
									dataList.get(4), // 电话号码
									code, 			 // 体检码
									dataList.get(5) // 套餐名
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
		}
		
		System.out.println("\n体检人员列表："+patientList);
		return patientList;
	}
	
	/**
	 * 获取人员信息
	 * @param companyFile
	 * @return
	 */
	public static List<Patient> getPatientList(CompanyFile companyFile) {
		// 得到文件
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
						patientList.add(
								new Patient(
									-1, // 病人id
									companyFile.getCompany_id(), // 公司id
									-1, // 套餐id
									dataList.get(0), // 姓名
									dataList.get(1), // 性别
									dataList.get(2), // 年龄
									dataList.get(3), // 身份证号
									"-1", 			 // 条码号
									dataList.get(4), // 电话号码
									"-1", 			 // 体检码
									dataList.get(5) // 套餐名
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
		}
		
		System.out.println("\n体检人员列表："+patientList);
		return patientList;
	}
	
	
}
