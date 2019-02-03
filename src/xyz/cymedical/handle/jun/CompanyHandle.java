package xyz.cymedical.handle.jun;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.ctx.LogCompanyBiz;
import xyz.cymedical.biz.ctx.PatientBiz;
import xyz.cymedical.biz.jun.BillerBiz;
import xyz.cymedical.biz.jun.ComboCheckBiz;
import xyz.cymedical.biz.jun.CompanyBiz;
import xyz.cymedical.biz.jun.CompanyFileBiz;
import xyz.cymedical.entity.ctx.LogCompany;
import xyz.cymedical.entity.jun.Biller;
import xyz.cymedical.entity.jun.Company;
import xyz.cymedical.entity.jun.CompanyFile;
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
	@Resource
	private ComboCheckBiz comboCheckBiz;//套餐业务
	@Resource
	private LogCompanyBiz logCompanyBiz;//日志业务
	@Resource
	private BillerBiz billerBiz;//账单业务
	
	private ModelAndView modelAndView; // 视图和模型
	private Company company; // 公司信息
	private List<CompanyFile> listFile; // 文件列表

	public CompanyHandle() {
	}

	
	/*
	 * 获取已结算账单
	 */
	@RequestMapping(value="/getBillerHasPay.handle",method=RequestMethod.GET)
	public ModelAndView getBillerHasPay(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("查询已结算账单");
		List<Biller> billerList = billerBiz.queryBillerList("已结算");
		System.out.println(billerList);
		modelAndView = new ModelAndView("WEB-INF/user_admin/biller_list_haspay");
		modelAndView.addObject("billerList", billerList);
		return modelAndView;
	}
	
	
	/*
	 * 结算
	 */
	@RequestMapping(value="/payBiller.handle",method=RequestMethod.POST)
	public String payBiller(
			HttpServletRequest request, 
			HttpServletResponse response, 
			String bid,
			String totalmoney) {
		System.out.println("结算账单："+bid+"费用："+totalmoney);
		String btime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
		company =(Company) request.getSession().getAttribute("userCompany");
		//扣除费用
		try {
			switch (companyBiz.deductDeposit(company.getCompany_id(), Float.parseFloat(totalmoney))) {
			case "扣除成功":
				//先插入日志
				logCompanyBiz.insertLog(
						company.getCompany_id(), 
						"体检结算", 
						String.valueOf(totalmoney), 
						btime);
				if (billerBiz.payBiller(bid, "已结算", btime)) {
					System.out.println("结算成功");
					response.getWriter().print("1");
				} else {
					System.out.println("结算失败");
					response.getWriter().print("0");
				}
				break;
			case "扣除失败":
				response.getWriter().print("-1");
				break;
			case "余额不足":
				response.getWriter().print("-2");
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
	 * 获取未结算的账单
	 */
	@RequestMapping(value="/getBillerNoPay.handle",method=RequestMethod.GET)
	public ModelAndView getBillerNoPay(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("查询未结算账单");
		List<Biller> billerList = billerBiz.queryBillerList("未结算");
		System.out.println(billerList);
		modelAndView = new ModelAndView("WEB-INF/user_admin/biller_list_nopay");
		modelAndView.addObject("billerList", billerList);
		return modelAndView;
		
	}
	
	
	/*
	 * 充值
	 */
	@RequestMapping(value="/pay.handle",method=RequestMethod.POST)
	public ModelAndView payForDeposit(HttpServletResponse response,HttpServletRequest request, String deposit) {
		System.out.println("存款："+deposit);
		//得到操作用户
		company = (Company)request.getSession().getAttribute("userCompany");
		//插入日志
		logCompanyBiz.insertLog(company.getCompany_id(), 
				"充值", 
				deposit, 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
		//先查询余额
		float balance = companyBiz.queryDepositCompanyId(company.getCompany_id());
		boolean isSuccess = companyBiz.updateDeposit(Float.parseFloat(deposit)+balance,company.getCompany_id());
		response.setCharacterEncoding("utf-8");
		try {
			if (isSuccess) {
				
				response.getWriter().print("<script type='text/javascript'>alert('充值成功!');location.href='<%=path %>company/getDepositDetail.handle';</script>");
			} else {
				response.getWriter().print(ResponseTools.returnMsgAndBack("充值失败！请联系管理员"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/*
	 * 查询费用明细
	 */
	@RequestMapping(value="/getDepositDetail.handle",method=RequestMethod.GET)
	public ModelAndView getDepositDetail(HttpServletRequest request) {
		//得到操作用户
		company = (Company)request.getSession().getAttribute("userCompany");
		System.out.println(company);
		//更新数据
		company = companyBiz.queryCompanyById(company.getCompany_id());
		request.getSession().setAttribute("userCompany", company);
		//查询日志
		List<LogCompany> logList = companyBiz.queryDepositList(String.valueOf(company.getCompany_id()));
		System.out.println(logList);
		//转发
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("logList", logList);
		modelAndView.setViewName("WEB-INF/user_admin/deposit-log");
		return modelAndView;
	}
	
	/*
	 * 删除文件
	 */
	@RequestMapping(value="/delFile.handle",method=RequestMethod.GET)
	public String delFile(HttpServletResponse response, String file_id) {
		response.setCharacterEncoding("utf-8");
		try {
			if(companyBiz.delCompanyFile(file_id)) {
				response.getWriter().print(ResponseTools.returnMsgAndBack("删除成功，请刷新页面"));
			}else {
				response.getWriter().print(ResponseTools.returnMsgAndBack("文件删除失败"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 获取文件列表
	 */
	@RequestMapping(value = "/getFileList.handle", method = RequestMethod.GET)
	public ModelAndView getFileList(String pageNum) {
		System.out.println("查询文件列表，页码" + pageNum);
		listFile = companyFileBiz.queryFileList(pageNum);
		modelAndView = new ModelAndView("WEB-INF/user_admin/file-list");
		modelAndView.addObject("listFile", listFile);
		return modelAndView;
	}
	
	
	/*
	 * 下载文件
	 */
	@RequestMapping(value="/downloadFile.handle",method=RequestMethod.GET)
	public String downloadFile(String file_id,HttpServletResponse response) {
		CompanyFile companyFile = companyFileBiz.queryFile(file_id);
		System.out.println("文件路径+文件名："+companyFile.getFpath());
		File file = new File(companyFile.getFpath());
		response.setCharacterEncoding("utf-8");
		try {
			if (file.exists()) {
				response.reset();//重置文件头
				response.setCharacterEncoding("UTF-8");
				response.setContentType("multipart/form-data");	//设置内容类型为多媒体文件
				//设置文件头
				response.setHeader("Content-Disposition","attachment;fileName="+URLEncoder.encode(file.getName(), "utf-8"));
				//设置文件流
				InputStream is = new FileInputStream(file);
				OutputStream os = response.getOutputStream();
				//缓冲区2k
				byte [] conBuffer = new byte[2048];
				//开始发文件
				int len = -1;
				while ((len=is.read(conBuffer))!=-1) {
					os.write(conBuffer,0,len);
				}
				os.flush();
				os.close();
				is.close();
			}else {
				response.getWriter().println(ResponseTools.returnMsgAndBack("文件不存在，请联系管理员"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/*
	 * 上传团检文件
	 */
	@RequestMapping(value = "/fileUpload.handle", method = RequestMethod.POST)
	public String fileUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile companyFile) {
		company = (Company) request.getSession().getAttribute("userCompany");
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
							new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis()),"未审核");
					if (companyFileBiz.insertFile(insertFile)) {
						System.out.println("写入成功"+file.getName());

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
	 * 获取上传文档的路径
	 */
	@RequestMapping(value = "/getUpFilePath.handle", method = RequestMethod.GET)
	public ModelAndView getUpFilePath() {
		System.out.println("获取上传文件地址");
		modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/user_admin/upfile-group");
		return modelAndView;
	}


	/*
	 * 公司用户登录
	 */
	@RequestMapping(value = "/loginCompany.handle", method = RequestMethod.POST)
	public ModelAndView companyLogin(HttpServletRequest request, HttpServletResponse response, String userName,
			String password) {
		System.out.println("用户登录" + userName);
		Company company = companyBiz.companyLogin(userName, password);
		System.out.println(company);
		ModelAndView modelAndView = new ModelAndView();
		if (company != null) {
			String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/";
			request.getSession().setAttribute("path", path);
			request.getSession().setAttribute("userName", userName);
			request.getSession().setAttribute("userCompany", company);
			modelAndView.setViewName("WEB-INF/user_admin/index");
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
}
