package xyz.cymedical.handle.jun;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.jun.CompanyBiz;
import xyz.cymedical.entity.jun.Company;
import xyz.cymedical.tools.jun.ResponseTools;

/**
* 2019年1月19日
* @author Junisyoan
* @version 1.0
*/
@Controller
@RequestMapping("/company")
public class CompanyHandle {

	@Resource
	private CompanyBiz companyBiz; 			//公司的业务逻辑
	private ModelAndView modelAndView;		//视图和模型
	
	public CompanyHandle() {
	}
	
	/*
	 * 获取上传文档的路径
	 */
	public ModelAndView getUpFilePath() {
		System.out.println("获取上传文件地址");
		modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/medical_workstation/upfile-group.jsp");
		return modelAndView;
	}
	
	
	/*
	 * 上传团检文件
	 */
	@RequestMapping(value="/fileUpload.handle", method=RequestMethod.POST)
	public String fileUpload(HttpServletRequest request,MultipartFile companyFile) {
		
		System.out.println(companyFile.getSize());
		
		return null;
	}
	
	/*
	 * 公司用户登录
	 */
	@RequestMapping(value="/loginCompany.handle", method=RequestMethod.POST)
	public ModelAndView	companyLogin(HttpServletRequest request, HttpServletResponse response, String userName,String password) {
		System.out.println("用户登录"+userName);
		Company company = companyBiz.companyLogin(userName, password);
		ModelAndView modelAndView = new ModelAndView();
		if (company!=null) {
			String path = request.getScheme() + "://" 
					+ request.getServerName() + ":" 
					+ request.getServerPort()
					+ request.getContextPath() + "/";
			request.getSession().setAttribute("path", path);
			modelAndView.setViewName("WEB-INF/medical_workstation/index");
			return modelAndView;
		}else {
			try {
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
	@RequestMapping(value="/regCompany.handle", method=RequestMethod.POST)
	public String regCompany(HttpServletResponse response,HttpServletRequest request, Company company) {
		System.out.println(company);
		//执行注册
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
				System.out.println("公司注册成功，生成公司目录"+company.getName());
				File file = new File(request.getServletContext().getRealPath("/WEB-INF/uploadFile/"+company.getName()));
				System.out.println(file.getPath());
				if (file.mkdir()) {
					System.out.println("目录创建成功");
				}else {
					System.out.println("创建失败");
				}
				response.getWriter().println(ResponseTools.returnMsgAndRedirect(res, "login_company.html"));
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
	@RequestMapping(value="/queryName.handle", method=RequestMethod.POST)
	public String queryName(HttpServletResponse response , String name) {
		System.out.println("查询要注册的公司名："+name);
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
	@RequestMapping(value="/queryAccount.handle", method=RequestMethod.POST)
	public String queryAccount(HttpServletResponse response,String account) {
		System.out.println("查询要注册的用户名："+account);
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
	@RequestMapping(value="/queryTel.handle", method=RequestMethod.POST)
	public String queryTel(HttpServletResponse response, String tel) {
		System.out.println("查询公司座机："+tel);
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
