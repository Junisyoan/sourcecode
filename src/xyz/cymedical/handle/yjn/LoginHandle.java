package xyz.cymedical.handle.yjn;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.jiang.TbUserBiz;
import xyz.cymedical.biz.xin.DoctorBiz;
import xyz.cymedical.entity.jiang.Tb_menu;
import xyz.cymedical.entity.jiang.Tb_user;

@Controller // 此注释的含义是将该类设置成为浏览器提交的上来的类
@RequestMapping("/user")
public class LoginHandle {

	@Resource
	public TbUserBiz tbUserBiz;

	@Resource
	private DoctorBiz doctorbiz;

	private Tb_user userr;

	private List<Tb_user> userlist = new ArrayList<>();
	private List<Tb_user> userlist2 = new ArrayList<>();

	@RequestMapping(value = "/login.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String login(HttpServletRequest req, String checkCode, Tb_user user) {
		HttpSession session = req.getSession();

		String result = "";

		userlist = tbUserBiz.findUser(user);
		userlist2 = tbUserBiz.findUserRole(user);

		System.out.println("User" + userlist.size());
		System.out.println("UserRole" + userlist2.size());

		if (userlist.size() > 0 && userlist2.size() > 0) {
			result = "管理员";
		} else {
			result = "账号密码错误";
		}

		session.setAttribute("user", userlist.get(0));

		return result;

	}

	@RequestMapping(value = "/index.handle")
	public ModelAndView find(HttpServletRequest req) {

		ModelAndView mav = new ModelAndView();
		userr = (Tb_user) req.getSession().getAttribute("user");

		if (userr != null) {
			// 用户对应菜单列表
			List<Tb_menu> mlist = doctorbiz.getMyMenu(userr.getUser_id(), userr.getRole_dept_id());
			mav.addObject("mlist", mlist);
			mav.addObject("USER", userr);
		}

		mav.setViewName("WEB-INF/view.jiang/index");
		return mav;

	}

	@RequestMapping(value = "/modify.handle")
	public ModelAndView modify(String oldpwd, String newpwd, HttpServletRequest req) {
		
		userr = (Tb_user) req.getSession().getAttribute("user");

		System.out.println(userr.getAccount());
		System.out.println(oldpwd);
		System.out.println(newpwd);

		return null;

	}

}
