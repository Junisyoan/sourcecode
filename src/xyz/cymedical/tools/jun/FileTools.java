package xyz.cymedical.tools.jun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Junisyoan; 
 * 日期：2019年1月22日 时间：下午9:38:21 
 * 类说明：解析Excel文件
 */
public class FileTools {

	public static int getExcelFilePeopleAmount(String filePath) {

		File fileExcel = new File(filePath);
		int firstRowIndex = 0;
		int lastRowIndex = 0;
		// 判断文件是否存在
		if (fileExcel.isFile() && fileExcel.exists()) {
			// .是特殊字符，需要转义！！！！！
			String[] split = fileExcel.getName().split("\\.");
			// 根据文件后缀（xls/xlsx）进行判断
			Workbook wb = null;
			try {
				if ("xls".equals(split[1])) {
					// 文件流对象
					FileInputStream fis = new FileInputStream(fileExcel);
					wb = new HSSFWorkbook(fis);
				} else if ("xlsx".equals(split[1])) {
					wb = new XSSFWorkbook(fileExcel);
				} else {
					System.out.println("文件类型错误!");
					return 0;
				}
				// 开始解析
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			}
			Sheet sheet = wb.getSheetAt(0);
			// 读取sheet 0
			firstRowIndex = sheet.getFirstRowNum() + 1;
			// 第一行是列名，所以不读
			lastRowIndex = sheet.getLastRowNum();
			System.out.println("第一列索引: " + firstRowIndex);
			System.out.println("最后一列索引: " + lastRowIndex);
		}
		return lastRowIndex-firstRowIndex;
	}
	
}
