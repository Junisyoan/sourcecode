package xyz.cymedical.web.jun;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.jun.UserBiz;
import xyz.cymedical.entity.jun.User;

@Controller // 此注释的含义是将该类设置成为浏览器提交的上来的类
@RequestMapping("/user")
public class LoginAction {

	private User user;

	private List ulist = new ArrayList<User>();

//	private String checkCode;

//	private String result;

//	private UserBiz userBiz = new UserBizImpl();

//	String s = "applicationContext.xml";
//	ApplicationContext conf = new ClassPathXmlApplicationContext(s);
//	System.out.println(conf);//初始化容器
//	
//	UserBiz userBiz = conf.getBean("userimpl",UserBizImpl.class);

	@Resource
	private UserBiz userBiz;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List getUlist() {
		return ulist;
	}

	public void setUlist(List ulist) {
		this.ulist = ulist;
	}

//	public String getCheckCode()
//	{
//		return checkCode;
//	}
//
//	public void setCheckCode(String checkCode)
//	{
//		this.checkCode = checkCode;
//	}

//	public String getResult()
//	{
//		return result;
//	}
//
//	public void setResult(String result)
//	{
//		this.result = result;
//	}

	@RequestMapping(value = "/login.action", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String login(HttpServletRequest req, String checkCode, User user) {

		String result = "";

		String mapcode = (String) req.getSession().getAttribute("CODE");

		System.out.println("mapcode=" + mapcode);

		System.out.println("checkCode=" + checkCode);

//		if (checkCode.equals(mapcode)) {
//
//			System.out.println("验证码错误正确");
//
//			System.out.println("查询前user=" + user);
//
//			user = userBiz.login(user);
//
//			System.out.println("查询后user=" + user);
//
//			if (null != user) {
//				//
//				if (user.getState().equals("启用")) {
//					req.getSession().setAttribute("USER", user);
//					if (user.getRoleid() == 1) {
//						result = "管理员";
//					} else {
//						result = "普通用户";
//					}
//				} else if (user.getState().equals("禁用")) {
//					result = "登录失败！用户被禁用！";
//				}
//			} else if (user == null) {
//				result = "用户名密码错误！";
//				System.out.println("用户名密码错误！");
//			}
//		} else {
//
//			result = "验证码错误！";
//			System.out.println("验证码错误！");
//		}
//
//		return result;
		result = "管理员";
		return result;
	}

	@RequestMapping(value = "/findRoleOne.handle")
	public ModelAndView find() {

		System.out.println("2222");

		System.out.println(userBiz.findAll());

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/userinfo");
		return mav;

	}
}
