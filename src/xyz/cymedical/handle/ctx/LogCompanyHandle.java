package xyz.cymedical.handle.ctx;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

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
	@RequestMapping(value = "/findcompanylog.handle")
	public ModelAndView findcompanylog(String account) {

		logCompanylist = logCompanyBiz.queryByName(account);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/logcompany");
		mav.addObject("logCompanylist", logCompanylist);
		return mav;

	}
}
