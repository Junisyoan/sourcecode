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

import xyz.cymedical.bean.jun.User;
import xyz.cymedical.biz.jun.UserBiz;

@Controller // ��ע�͵ĺ����ǽ��������ó�Ϊ������ύ����������
@RequestMapping("/user")
public class LoginAction {

	private User user;

	private List ulist = new ArrayList<User>();

//	private String checkCode;

//	private String result;

//	private UserBiz userBiz = new UserBizImpl();

//	String s = "applicationContext.xml";
//	ApplicationContext conf = new ClassPathXmlApplicationContext(s);
//	System.out.println(conf);//��ʼ������
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
//			System.out.println("��֤�������ȷ");
//
//			System.out.println("��ѯǰuser=" + user);
//
//			user = userBiz.login(user);
//
//			System.out.println("��ѯ��user=" + user);
//
//			if (null != user) {
//				//
//				if (user.getState().equals("����")) {
//					req.getSession().setAttribute("USER", user);
//					if (user.getRoleid() == 1) {
//						result = "����Ա";
//					} else {
//						result = "��ͨ�û�";
//					}
//				} else if (user.getState().equals("����")) {
//					result = "��¼ʧ�ܣ��û������ã�";
//				}
//			} else if (user == null) {
//				result = "�û����������";
//				System.out.println("�û����������");
//			}
//		} else {
//
//			result = "��֤�����";
//			System.out.println("��֤�����");
//		}
//
//		return result;
		result = "����Ա";
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
