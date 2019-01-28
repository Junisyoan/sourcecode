package xyz.cymedical.handle.jun;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import xyz.cymedical.biz.jun.CompanyBiz;
import xyz.cymedical.biz.jun.CompanyFileBiz;
import xyz.cymedical.entity.ctx.LogCompany;
import xyz.cymedical.entity.jun.Company;
import xyz.cymedical.entity.jun.CompanyFile;
import xyz.cymedical.tools.jun.ResponseTools;

/**
*	@author Junisyoan;
*	日期：2019年1月28日
*	时间：下午2:17:14
*	类说明：公司用户业务类
*/

@Controller
@RequestMapping("/customer")
public class UserHandle {

	@Resource
	private CompanyBiz companyBiz;
	
	@Resource
	private LogCompanyBiz logCompanyBiz;
	
	@Resource
	private CompanyFileBiz companyFileBiz;
//	@Resource
//	private UserBiz userBiz;
	
	
	
	private ModelAndView modelAndView;
	private Company company;
	/*
	 * 充值
	 */
/*	@RequestMapping(value="/pay.handle",method=RequestMethod.POST)
	public String payForDeposit(HttpServletResponse response,String deposit) {
		System.out.println("存款："+deposit);
		boolean isSuccess = companyBiz.insertDeposit(deposit);
		response.setCharacterEncoding("utf-8");
		try {
			if (isSuccess) {
				response.getWriter().print(ResponseTools.returnMsgAndBack("充值成功！"));
			} else {
				response.getWriter().print(ResponseTools.returnMsgAndBack("充值失败！请联系管理员"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	*/
	
	/*
	 * 查询费用明细
	 */
/*	@RequestMapping(value="/getDepositDetail.handle",method=RequestMethod.GET)
	public ModelAndView getLogCompanyList(HttpServletRequest request) {
		System.out.println("查询费用明细列表");
		Company company = (Company)request.getSession().getAttribute("user");
		List<LogCompany> logList = logCompanyBiz.queryByName(company.getName());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("logList", logList);
		modelAndView.setViewName("WEB-INF/user_admin/deposit-log");
		return modelAndView;
	}
*/	
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
	 * 	公司用户登录
	 */
	@RequestMapping(value = "/loginUser.handle", method = RequestMethod.POST)
	public ModelAndView companyLogin(HttpServletRequest request, 
			HttpServletResponse response, 
			String account,
			String pwd) {
		System.out.println("用户登录" + account);
		Company company = companyBiz.companyLogin(account, pwd);
		modelAndView = new ModelAndView();
		if (company != null) {
			System.out.println("登录成功"+company);
			//网站路径
			String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/";
			
			//设置属性
			request.getSession().setAttribute("path", path);
			request.getSession().setAttribute("user", company);
			
			//设置地址和模型
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
	
}
