package xyz.cymedical.handle.jun;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.ClientAbortException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;

import xyz.cymedical.biz.ctx.LogCompanyBiz;
import xyz.cymedical.biz.ctx.PatientBiz;
import xyz.cymedical.biz.jun.BillerBiz;
import xyz.cymedical.biz.jun.ComboCheckBiz;
import xyz.cymedical.biz.jun.CompanyBiz;
import xyz.cymedical.biz.jun.CompanyFileBiz;
import xyz.cymedical.biz.jun.InvalideBiz;
import xyz.cymedical.biz.xin.DoctorBiz;
import xyz.cymedical.biz.zsc.ComboBiz;
import xyz.cymedical.entity.ctx.LogCompany;
import xyz.cymedical.entity.jun.Biller;
import xyz.cymedical.entity.jun.Company;
import xyz.cymedical.entity.jun.CompanyFile;
import xyz.cymedical.entity.jun.Invalide;
import xyz.cymedical.entity.jun.Patient;
import xyz.cymedical.entity.xin.Combo;
import xyz.cymedical.tools.jun.AlipayConfig;
import xyz.cymedical.tools.jun.ExcelTools;
import xyz.cymedical.tools.jun.ResponseTools;
import xyz.cymedical.tools.zsc.Encryption;

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
	@Resource
	private ComboBiz comboBiz;
	@Resource
	private DoctorBiz doctorbiz;//医生业务
	@Resource
	private InvalideBiz invalideBiz;
	
	private boolean isSuccess;//是否成功
	
	private ModelAndView modelAndView; // 视图和模型
	private Company company; // 公司信息
	private List<CompanyFile> listFile; // 文件列表
	
	private List<Map<String,Object>> plist; //项目列表
	
	private volatile int pState = 2;//1支付成功，0未支付，-1支付失败，2正在操作
	
	public CompanyHandle() {
	}

	
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
				isSuccess = file.delete();
				System.out.println("删除文件："+isSuccess);
			}
			isSuccess = invalideBiz.delete(Integer.parseInt(fid));
			if (isSuccess) {
				strRet="1";
			}else {
				strRet="0";
			}
		} else {
			strRet="-1";
		}
		return strRet;
	}
	
	/*
	 * 查询不合格文件
	 */
	@RequestMapping(value="/invalideFile.handle",method=RequestMethod.GET)
	public ModelAndView invalideFile(String fid) {
		System.out.println("查看不合格文件id："+fid);
		modelAndView = new ModelAndView("WEB-INF/user_admin/invalide-file");
		List<Invalide> invalideList = invalideBiz.queryInvalideByFileId(Integer.parseInt(fid));
		modelAndView.addObject("invalideList", invalideList);
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
	 * 获取充值链接地址
	 */
	@RequestMapping(value="/getUrl.handle",method=RequestMethod.GET)
	public ModelAndView getUrl() {
		System.out.println("获取充值链接");
		modelAndView=new ModelAndView("WEB-INF/user_admin/recharge");
		return modelAndView;
	}
	
	/*
	 * 充值数据返回
	 */
	@RequestMapping(value="/waitPay.handle",method=RequestMethod.POST)
	public @ResponseBody String payState(String WF) {
		pState=2;
		System.out.println("wf："+WF+"计时30分钟，pState="+pState);
		Timer timer = new Timer();
		int t = 1000*60*30;
		timer.schedule(new TimerTask() {
			int time = 0;
			@Override
			public void run() {
				time+=1;
				if (pState==1||pState==-1) {
					timer.cancel();
				}else if (time==t) {
					pState=0;
					timer.cancel();
				}
			}
		} , 0,1000);
		while (true) {
			if (pState==2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}
			break;
		}
		System.out.println(pState);
		return String.valueOf(pState);
	}
	
	/*
	 * 支付宝异步通知
	 */
	@RequestMapping(value="/notify.handle")
	public @ResponseBody String notify(HttpServletRequest request,HttpServletResponse response) {
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			try {
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			params.put(name, valueStr);
		}
		
		boolean signVerified=false;
		try {
			signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		} //调用SDK验证签名

		//——请在这里编写您的程序（以下代码仅作参考）——
		
		/* 实际验证过程建议商户务必添加以下校验：
		1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
		2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
		3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
		4、验证app_id是否为该商户本身。
		*/
		if(signVerified) {//验证成功
			//商户订单号
			//交易状态
			String trade_status="";
			try {
				String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

				//支付宝交易号
				String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

				trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			if(trade_status.equals("TRADE_FINISHED")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
					
				//注意：
				//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			}else if (trade_status.equals("TRADE_SUCCESS")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
				
				//注意：
				//付款完成后，支付宝系统发送该交易状态通知
			}
			
			System.out.println("success");
			
		}else {//验证失败
			System.out.println("fail");
		
			//调试用，写文本函数记录程序运行情况是否正常
			//String sWord = AlipaySignature.getSignCheckContentV1(params);
			//AlipayConfig.logResult(sWord);
		}
		return null;
	}
	
	/*
	 * 打印发票
	 */
	@RequestMapping(value="/getReceipt.handle",method=RequestMethod.GET)
	public ModelAndView getReceipt(String bid) {
		System.out.println("打印发票"+bid);
		CompanyFile companyFile = companyFileBiz.queryFileByBillerId(bid);
		List<Patient> patients = ExcelTools.getPatientList(companyFile);
		List<Combo> combos = comboBiz.findCombos();
		for(int j=0;j<patients.size();j++) {
			for(int i=0;i<combos.size();i++) {
				if (patients.get(j).getComboName().equals(combos.get(i).getName())) {
					patients.get(j).setA(combos.get(i).getPrice());
					break;
				}
			}
		}
		modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/user_admin/receipt");
		modelAndView.addObject("pList", patients);
		return modelAndView;
	}
	
	/*
	 * 获取已结算账单
	 */
	@RequestMapping(value="/getBillerHasPay.handle",method=RequestMethod.GET)
	public ModelAndView getBillerHasPay(HttpServletRequest request, HttpServletResponse response,String cid) {
		System.out.println("查询已结算账单");
		List<Biller> billerList = billerBiz.queryCompanyBillerList("已结算",Integer.parseInt(cid));
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
				System.out.println("扣除费用成功");
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
	public ModelAndView getBillerNoPay(HttpServletRequest request, HttpServletResponse response,String cid) {
		System.out.println("查询未结算账单，公司id:"+cid);
		List<Biller> billerList = billerBiz.queryCompanyBillerList("未结算",Integer.parseInt(cid));
		System.out.println(billerList);
		modelAndView = new ModelAndView("WEB-INF/user_admin/biller_list_nopay");
		modelAndView.addObject("billerList", billerList);
		return modelAndView;
		
	}
	
	/*
	 * 充值
	 */
	@RequestMapping(value="/pay.handle",method=RequestMethod.POST)
	public @ResponseBody String payForDeposit(HttpServletRequest request, String deposit) {
		System.out.println("存款："+deposit);
		pState=2;//正在操作
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
		String strRet="<script>window.close();</script>";
			if (isSuccess) {
				pState=1;
			} else {
				pState=-1;
			}
		return strRet;
	}
	
	/*
	 * 查询费用明细
	 */
	@RequestMapping(value="/getDepositDetail.handle",method=RequestMethod.GET)
	public ModelAndView getDepositDetail(HttpServletRequest request,String cid) {
		//更新数据
		company = companyBiz.queryCompanyById(Integer.parseInt(cid));
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
	 * 获取文件列表
	 */
	@RequestMapping(value = "/getFileList.handle", method = RequestMethod.GET)
	public ModelAndView getFileList(String cid) {
		System.out.println("查询文件列表" );
		listFile = companyFileBiz.queryFileList(Integer.parseInt(cid));
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
				response.setHeader("Content-Disposition","attachment;fileName="+URLEncoder.encode(file.getName(), "UTF-8"));
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
		}catch (ClientAbortException e) {
			System.out.println("终止下载");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/*
	 * 删除文件
	 */
	@RequestMapping(value = "/delFile.handle",method=RequestMethod.POST)
	public String delelteFile(String fid,String fname, HttpServletResponse response) {
		System.out.println("删除文件："+fname+"--文件id："+fid);
		response.setCharacterEncoding("utf-8");
		//获得文件信息
		CompanyFile cf = companyFileBiz.queryFile(fid);
		
		isSuccess=false;
		
		try {
			if (companyFileBiz.delFile(fid)) {
				//1成功，删除文件
				File file = new File(cf.getFpath());
				if (file.delete()) {
					response.getWriter().print("1");
					isSuccess = true;
				}
			}
			//0失败
			if (!isSuccess) {
				response.getWriter().print("0");
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
		String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath() + "/";
		File fileDir = new File(request.getServletContext().getRealPath("/WEB-INF/uploadFile/" + company.getName()));
		System.out.println(fileDir.getPath());
		// 目录是否存在
		try {
			if (fileDir.isDirectory()) {
				// 创建文件
				File file = new File(fileDir.getAbsolutePath() + "/" + companyFile.getOriginalFilename());
				if (file.exists()) {
					System.out.println("文件存在");
					response.getWriter().println(ResponseTools.returnMsgAndBack("文件存在"));
				} else {
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

							response.getWriter().println(ResponseTools.returnMsgAndRedirect("上传文件成功", path+"company/getFileList.handle?cid="+company.getCompany_id()));
						} else {
							response.getWriter().println(ResponseTools.returnMsgAndBack("上传文件失败"));
						}

				}
			} else {
					response.getWriter().println(ResponseTools.returnMsgAndBack("文件存在"));
				System.out.println("目录不存在");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
		Company company = companyBiz.companyLogin(userName, Encryption.getResult(password));
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
	@RequestMapping(value = "/regCompany.so", method = RequestMethod.POST)
	public String regCompany(HttpServletResponse response, HttpServletRequest request, Company company) {
		System.out.println(company);
		company.setPwd(Encryption.getResult(company.getPwd()));
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
	@RequestMapping(value = "/queryName.so", method = RequestMethod.POST)
	public String queryName(HttpServletResponse response, String name) {
		System.out.println("查询要注册的公司名：" + name);
		try {
			if (companyBiz.queryName(name)) {
				System.out.println("公司已存在");
				response.getWriter().print("0");
			} else {
				System.out.println("公司名可用");
				response.getWriter().print("1");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 查询账户是否存在
	 */
	@RequestMapping(value = "/queryAccount.so", method = RequestMethod.POST)
	public String queryAccount(HttpServletResponse response, String account) {
		System.out.println("查询要注册的用户名：" + account);
		try {
			if (companyBiz.queryAccount(account)) {
				System.out.println("用户名不可用");
				response.getWriter().print("0");
			} else {
				System.out.println("用户名可用");
				response.getWriter().print("1");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 查询公司座机号
	 */
	@RequestMapping(value = "/queryTel.so", method = RequestMethod.POST)
	public String queryTel(HttpServletResponse response, String tel) {
		System.out.println("查询公司座机：" + tel);
		try {
			if (companyBiz.queryTel(tel)) {
				System.out.println("座机不可用" );
				response.getWriter().print("0");
			} else {
				System.out.println("座机可用");
				response.getWriter().print("1");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//************************************************************************
	//************************************************************************
	
	
	/*
	 * toRefund xinyang
	 */
	@RequestMapping(value = "/toRefund.handle")
	public ModelAndView toRefund(HttpServletResponse response, String account) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("WEB-INF/doctor.xin/Refund_receive");
		return mav;
	}
	/*
	 * findProject xinyang
	 */
	// 查询一维码对应病人的导检单
		@RequestMapping(value = "/findProject.handle")
		public ModelAndView findProject(String onecode) {

			System.out.println("onecode=" + onecode);
			System.out.println(doctorbiz.findMyProject(onecode));
			
			String flag="true";//初始化flag，用于控制状态
			
			//根据条码获取项目列表
			plist=doctorbiz.findMyProject(onecode);

			
			
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("prolist", plist);
			
			if(plist!=null && plist.size()>0) {
				
				//若存在退费项目，返回false
				for (int i = 0; i < plist.size(); i++) {
					if(plist.get(i).get("balance").equals("已退费")) {
						flag="false";
						break;
					}
				}
				
				mav.addObject("flag", flag);
				mav.addObject("patient", plist.get(0));//该列表已包含病人信息
			}
			mav.setViewName("WEB-INF/doctor.xin/Refund_receive");
			return mav;

		}
		
		
		//退费操作
		@RequestMapping(value = "/Refund.handle")
		public ModelAndView Refund(HttpServletRequest req) {
			
			System.out.println("plist="+plist);
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
					System.out.println(m.get("price"));
					sum=sum+Double.parseDouble(m.get("price").toString());
				}
			}
			
			System.out.println("sum="+sum);
			
			//从公司余额中增加金额
			Company company=(Company) req.getSession().getAttribute("userCompany");
			
			//当前余额
			double deposit=company.getDeposit();
			deposit=deposit+sum;
			
			companyBiz.Refund(company.getCompany_id(),deposit);
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("prolist", plist);
			mav.addObject("flag", "false");
			mav.addObject("patient", plist.get(0));
			
			mav.setViewName("WEB-INF/doctor.xin/Refund_receive");
			return mav;

		}
		
		@RequestMapping(value = "/home.handle")
		public ModelAndView turnhome() {

			ModelAndView mav = new ModelAndView();
			mav.setViewName("WEB-INF/user_admin/index");
			return mav;

		}
		
		@RequestMapping(value = "/systemhome.handle")
		public ModelAndView turnsystemhome() {

			ModelAndView mav = new ModelAndView();
			mav.setViewName("WEB-INF/user_admin/welcome");
			return mav;

		}
		
		
		/*
		 * 公司信息查询
		 * */
	
}
