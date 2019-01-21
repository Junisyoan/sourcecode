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

import xyz.cymedical.biz.ctx.LogCompanyBiz;
import xyz.cymedical.biz.jiang.TbUserBiz;
import xyz.cymedical.biz.xin.DoctorBiz;
import xyz.cymedical.entity.ctx.LogCompany;
import xyz.cymedical.entity.jiang.Tb_user;

@Controller // 此注释的含义是将该类设置成为浏览器提交的上来的类
@RequestMapping("/user")
public class LoginHandle {

	@Resource
	private TbUserBiz userBiz;

	@Resource
	private DoctorBiz doctorbiz; // 医生的业务逻辑

	private List<LogCompany> logCompanylist = new ArrayList<LogCompany>();

	@Resource
	public LogCompanyBiz logCompanyBiz;

	@RequestMapping(value = "/login.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String login(HttpServletRequest req, String checkCode, Tb_user user) {

		String result = "";

		String mapcode = (String) req.getSession().getAttribute("CODE");

		System.out.println("mapcode=" + mapcode);

		System.out.println("checkCode=" + checkCode);

		if (user.getAccount().equals("admin") && user.getPwd().equals("123")) {
			result = "管理员";
		} else {
			result = "账号密码错误";
		}
		return result;

	}

	@RequestMapping(value = "/index.handle")
	public ModelAndView find() {

		System.out.println("2222");

		System.out.println(doctorbiz.findMyDetails(""));

		System.out.println(userBiz.findAll());

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.jiang/index");
		return mav;

	}

	// 公司记账
	@RequestMapping(value = "/findcompanylog.handle")
	public ModelAndView findcompanylog() {

		// 没写完，数据未获取
		String name = "蓝色科技";

		logCompanylist = logCompanyBiz.queryByName(name);

		System.out.println(logCompanylist.size());

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/companylog");
		mav.addObject("logCompanylist", logCompanylist);
		return mav;

	}
}
