package xyz.cymedical.handle.ctx;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.ctx.LogCompanyBiz;
import xyz.cymedical.biz.jun.CompanyBiz;
import xyz.cymedical.entity.ctx.LogCompany;
import xyz.cymedical.entity.jun.Company;

@Controller
@RequestMapping("/logcompany")
public class LogCompanyHandle {

	@Resource
	public LogCompanyBiz logCompanyBiz;

	@Resource
	public CompanyBiz companyBiz;

	private List<LogCompany> logCompanylist = new ArrayList<LogCompany>();
	private List<LogCompany> logCompanylist2 = new ArrayList<LogCompany>();

	private List<Company> Companylist = new ArrayList<Company>();

	public LogCompanyHandle() {

	}

	// 医院记账
	@RequestMapping(value = "/findalllogcompany.handle")
	public ModelAndView findallcompanylog() {

		logCompanylist2 = logCompanyBiz.queryAll();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/logcompany");
		if (logCompanylist2.size() > 0) {
			mav.addObject("logCompanylist2", logCompanylist2);
		}
		return mav;

	}

	// 医院记账
	@RequestMapping(value = "/searchlog.handle")
	public ModelAndView searchlog(String name, String operate, String money, String time) {

		logCompanylist2 = logCompanyBiz.searchLog(name, operate, money, time);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/logcompany");
		if (logCompanylist2.size() > 0) {
			mav.addObject("logCompanylist2", logCompanylist2);
		}
		return mav;

	}
}
