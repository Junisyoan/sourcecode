package xyz.cymedical.handle.jun;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jbarcode.JBarcode;
import org.jbarcode.encode.EAN13Encoder;
import org.jbarcode.paint.EAN13TextPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.jbarcode.util.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.ctx.PatientBiz;
import xyz.cymedical.biz.jun.CompanyBiz;
import xyz.cymedical.biz.jun.CompanyFileBiz;
import xyz.cymedical.entity.jun.Company;
import xyz.cymedical.entity.jun.CompanyFile;
import xyz.cymedical.entity.jun.Patient;
import xyz.cymedical.handle.ctx.TestBarcode;
import xyz.cymedical.tools.jun.ResponseTools;

/**
 * 2019年1月19日
 * 
 * @author Junisyoan
 * @version 1.0
 */
@Controller
@RequestMapping("/company")
public class CompanyHandle {

	@Resource
	private CompanyBiz companyBiz; // 公司的业务逻辑
	@Resource
	private CompanyFileBiz companyFileBiz; // 上传文件业务
	@Resource
	private PatientBiz patientBiz; // 体检人业务逻辑

	private ModelAndView modelAndView; // 视图和模型
	private Company company; // 公司信息
	private List<CompanyFile> listFile; // 文件列表

	private static Random numGen = new Random();
	private static char[] numbers = ("0123456789").toCharArray();

	public CompanyHandle() {
	}

	/*
	 * 导入excel
	 */
	@RequestMapping(value = "/analysisExcel.handle", method = RequestMethod.GET)
	public ModelAndView analysisExcel(HttpServletRequest request, String file_id) {
		
		String code = randomNumStr(13);
		company = (Company) request.getSession().getAttribute("user");
		// 要插入的病人信息表
		List<Patient> listPatient = new ArrayList<>();
		// 1得到文件信息
		CompanyFile companyFile = companyFileBiz.queryFile(file_id);
		System.out.println(companyFile);
		// 2载入文件，解析
		// 得到文件
		try {
			// String encoding = "GBK";
			System.out.println("文件路径：" + companyFile.getFpath());
			File excel = new File(companyFile.getFpath());
			// 判断文件是否存在
			if (excel.isFile() && excel.exists()) {
				// 点.是特殊字符，需要转义
				String[] split = excel.getName().split("\\.");
				Workbook wb = null;
				// 根据文件后缀（xls/xlsx）进行判断
				if ("xls".equals(split[1])) {
					// 文件流对象
					FileInputStream fis = new FileInputStream(excel);
					wb = new HSSFWorkbook(fis);
				} else if ("xlsx".equals(split[1])) {
					wb = new XSSFWorkbook(excel);
				} else {
					System.out.println("文件类型错误!");
				}
				//	开始解析，读取sheet 0
				Sheet sheet = wb.getSheetAt(0);
				//	第一行是列名，所以不读
				int firstRowIndex = sheet.getFirstRowNum() + 1;
				int lastRowIndex = sheet.getLastRowNum();

				System.out.println("一共这么多行数据: " + (lastRowIndex - firstRowIndex + 1));
				for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {
					//	遍历行
					Row row = sheet.getRow(rIndex);
					ArrayList<String> listData = new ArrayList<>();
					if (row != null) {
						int firstCellIndex = row.getFirstCellNum();
						int lastCellIndex = row.getLastCellNum();

						for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {
							//	遍历列
							Cell cell = row.getCell(cIndex);
							if (cell != null) {
								System.out.print(cell.toString() + "\t");
								listData.add(cell.toString());
							}
						}
						System.out.println(listData);
					}
					listPatient.add(new Patient(
							-1, 
							company.getCompany_id(), 
							-1, 
							listData.get(0), 
							listData.get(1),
							listData.get(2), 
							listData.get(3), 
							code, 
							listData.get(4), 
							"-1"));
					System.out.println();
					TestBarcode.createBarCode("D://test//", code, ImageUtil.JPEG);
				}
				wb.close();
				System.out.println(listPatient);
				System.out.println("开始入库");
				boolean isSuccess = patientBiz.insertByBatch(listPatient);
				if (isSuccess) {
					System.out.println("导入成功");
				}
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 获得所上传的文件列表
	 */
	@RequestMapping(value = "/getFileList.handle", method = RequestMethod.GET)
	public ModelAndView getFileList(String pageNum) {
		System.out.println("查询文件列表，页码" + pageNum);
		listFile = companyFileBiz.queryFileList(pageNum);
		modelAndView = new ModelAndView("WEB-INF/medical_workstation/file-list");
		modelAndView.addObject("listFile", listFile);
		return modelAndView;
	}

	/*
	 * 获取上传文档的路径
	 */
	@RequestMapping(value = "/getUpFilePath.handle", method = RequestMethod.GET)
	public ModelAndView getUpFilePath() {
		System.out.println("获取上传文件地址");
		modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/medical_workstation/upfile-group");
		return modelAndView;
	}

	/*
	 * 上传团检文件
	 */
	@RequestMapping(value = "/fileUpload.handle", method = RequestMethod.POST)
	public String fileUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile companyFile) {
		company = (Company) request.getSession().getAttribute("user");
		System.out.println(companyFile.getSize());
		File fileDir = new File(request.getServletContext().getRealPath("/WEB-INF/uploadFile/" + company.getName()));
		System.out.println(fileDir.getPath());
		// 目录是否存在
		if (fileDir.isDirectory()) {
			// 创建文件
			File file = new File(fileDir.getAbsolutePath() + "/" + companyFile.getOriginalFilename());
			if (file.exists()) {
				System.out.println("文件存在");
			} else {
				try {
					byte[] bytes = companyFile.getBytes();
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
					stream.write(bytes);
					stream.close();
					System.out.println("上传成功，准备写入数据库");

					CompanyFile insertFile = new CompanyFile(-1, company.getCompany_id(),
							companyFile.getOriginalFilename(), companyFile.getSize(), file.getAbsolutePath(),
							new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis()));
					if (companyFileBiz.insertFile(insertFile)) {
						System.out.println("写入成功，开始解析文件");

						response.getWriter().println(ResponseTools.returnMsgAndBack("上传文件成功"));
					} else {
						response.getWriter().println(ResponseTools.returnMsgAndBack("上传文件失败"));
					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("目录不存在");
		}
		return null;
	}

	/*
	 * 公司用户登录
	 */
	@RequestMapping(value = "/loginCompany.handle", method = RequestMethod.POST)
	public ModelAndView companyLogin(HttpServletRequest request, HttpServletResponse response, String userName,
			String password) {
		System.out.println("用户登录" + userName);
		Company company = companyBiz.companyLogin(userName, password);
		ModelAndView modelAndView = new ModelAndView();
		if (company != null) {
			String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/";
			request.getSession().setAttribute("path", path);
			request.getSession().setAttribute("user", company);
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
	 * 公司注册
	 */
	@RequestMapping(value = "/regCompany.handle", method = RequestMethod.POST)
	public String regCompany(HttpServletResponse response, HttpServletRequest request, Company company) {
		System.out.println(company);
		// 执行注册
		String res = companyBiz.regCompany(company);
		try {
			response.setContentType("text/html;charset=utf-8");
			switch (res) {
			case "已被注册":
				System.out.println("公司已被注册");
				response.getWriter().println(ResponseTools.returnMsgAndBack(res));
				break;

			case "注册失败":
				System.out.println("公司注册失败");
				response.getWriter().println(ResponseTools.returnMsgAndBack(res));
				break;

			case "注册成功":
				System.out.println("公司注册成功，生成公司目录" + company.getName());
				File file = new File(
						request.getServletContext().getRealPath("/WEB-INF/uploadFile/" + company.getName()));
				System.out.println(file.getPath());
				if (file.mkdir()) {
					System.out.println("目录创建成功");
				} else {
					System.out.println("创建失败");
				}
				response.getWriter().println(ResponseTools.returnMsgAndRedirect(res, "../login_company.html"));
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
	 * 查询公司名字
	 */
	@RequestMapping(value = "/queryName.handle", method = RequestMethod.POST)
	public String queryName(HttpServletResponse response, String name) {
		System.out.println("查询要注册的公司名：" + name);
		try {
			if (companyBiz.queryName(name)) {
				System.out.println("公司已存在");
				response.getWriter().print("公司已存在");
			} else {
				System.out.println("可用");
				response.getWriter().print("可用");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 查询账户是否存在
	 */
	@RequestMapping(value = "/queryAccount.handle", method = RequestMethod.POST)
	public String queryAccount(HttpServletResponse response, String account) {
		System.out.println("查询要注册的用户名：" + account);
		try {
			if (companyBiz.queryAccount(account)) {
				response.getWriter().print("用户已存在");
			} else {
				response.getWriter().print("可用");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 查询公司座机号
	 */
	@RequestMapping(value = "/queryTel.handle", method = RequestMethod.POST)
	public String queryTel(HttpServletResponse response, String tel) {
		System.out.println("查询公司座机：" + tel);
		try {
			if (companyBiz.queryTel(tel)) {
				response.getWriter().print("座机已存在");
			} else {
				response.getWriter().print("可用");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static final String randomNumStr(int length) {
		// TODO Auto-generated method stub
		if (length < 1) {
			return null;
		}
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbers[numGen.nextInt(9)];
		}
		return new String(randBuffer);
	}

	private static String createBarCode(String savePath, String jbarCode, String imgFormat) {
		try {
			BufferedImage bi = null;
			int len = jbarCode.length();
			// 实例化JBarcode
			// 这里三个参数，必要填写
			JBarcode jbarcode13 = new JBarcode(EAN13Encoder.getInstance(), WidthCodedPainter.getInstance(),
					EAN13TextPainter.getInstance());
			// 获取到前12位
			String barCode = jbarCode.substring(0, len - 1);
			// 获取到校验位
			String code = jbarCode.substring(len - 1, len);
			String checkCode = jbarcode13.calcCheckSum(barCode);
			if (!code.equals(checkCode)) {
				return "EN-13 条形码最后一位校验码 不对，应该是： " + checkCode;
			}
			/*
			 * 最重要的是这里的设置，如果明白了这里的设置就没有问题 如果是默认设置， 那么设置就是生成一般的条形码 如果不是默认 设置，那么就可以根据自己需要设置
			 */
			// 尺寸，面积，大小
			jbarcode13.setXDimension(Double.valueOf(0.8).doubleValue());
			// 条形码高度
			jbarcode13.setBarHeight(Double.valueOf(30).doubleValue());
			// 宽度率
			jbarcode13.setWideRatio(Double.valueOf(20).doubleValue());
			// 是否校验最后一位，默认是false
			jbarcode13.setShowCheckDigit(true);
			// 生成二维码
			bi = jbarcode13.createBarcode(barCode);
			// 定义图片名称
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			String imgName = sdf.format(new Date()) + "_" + jbarCode;
			// 保存二维码图片
			FileOutputStream fileOutputStream = null;
			String imgPath = savePath + imgName + "." + imgFormat;
			try {
				try {
					savePath = URLDecoder.decode(savePath, "UTF-8");
				} catch (UnsupportedEncodingException uee) {
					uee.printStackTrace();
					savePath = "C://barcode//images//";
				}
				File dirFile = new File(savePath);

				if (!dirFile.exists()) {
					dirFile.mkdirs();
				}
				fileOutputStream = new FileOutputStream(imgPath);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			ImageUtil.encodeAndWrite(bi, imgFormat, fileOutputStream, 96, 96);
			fileOutputStream.close();
			// 返回路径
			return imgPath;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
