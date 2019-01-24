package xyz.cymedical.handle.ctx;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.ctx.LogCompanyBiz;
import xyz.cymedical.entity.ctx.LogCompany;

@Controller
@RequestMapping("/logcompany")
public class LogCompanyHandle {

	@Resource
	public LogCompanyBiz logCompanyBiz;

	private List<LogCompany> logCompanylist = new ArrayList<LogCompany>();

	public LogCompanyHandle() {

	}

	// 公司记账
	@RequestMapping(value = "/findlogcompany.handle")
	public ModelAndView findcompanylog(String name) {

		logCompanylist = logCompanyBiz.queryByName("123456");

		System.out.println(logCompanylist.size());

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/logcompany");
		if (logCompanylist.size() > 0) {
			mav.addObject("logCompanylist", logCompanylist);
		}
		return mav;

	}
}
