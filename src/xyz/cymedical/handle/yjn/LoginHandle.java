package xyz.cymedical.handle.yjn;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.jiang.TbUserBiz;
import xyz.cymedical.entity.jiang.Tb_user;

@Controller // 此注释的含义是将该类设置成为浏览器提交的上来的类
@RequestMapping("/user")
public class LoginHandle {

	@Resource
	public TbUserBiz tbUserBiz;

	private List<Tb_user> userlist = new ArrayList<>();
	private List<Tb_user> userlist2 = new ArrayList<>();

	@RequestMapping(value = "/login.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String login(HttpServletRequest req, String checkCode, Tb_user user) {

		String result = "";

		String mapcode = (String) req.getSession().getAttribute("CODE");

		System.out.println("mapcode=" + mapcode);

		System.out.println("checkCode=" + checkCode);

		userlist = tbUserBiz.findUser(user);
		userlist2 = tbUserBiz.findUserRole(user);

		if (userlist.size() > 0 && userlist2.size() > 0) {
			result = "管理员";
		} else {
			result = "账号密码错误";
		}
		return result;

	}

	@RequestMapping(value = "/index.handle")
	public ModelAndView find() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.jiang/index");
		return mav;

	}

}
