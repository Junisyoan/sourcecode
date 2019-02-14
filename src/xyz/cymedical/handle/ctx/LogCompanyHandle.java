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

//	// 公司记账
//	@RequestMapping(value = "/findlogcompany.handle")
//	public ModelAndView findcompanylog(HttpServletRequest request, HttpServletResponse response, String name) {
//
//		System.out.println(request.getSession().getAttribute("userName"));
//
//		Companylist = companyBiz.queryByAccount((String) request.getSession().getAttribute("userName"));
//
//		logCompanylist = logCompanyBiz.queryByName(Companylist.get(0).getName());
//
//		System.out.println(logCompanylist.size());
//
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("WEB-INF/medical_workstation/logcompany");
//		if (logCompanylist.size() > 0) {
//			mav.addObject("logCompanylist", logCompanylist);
//		}
//		return mav;
//
//	}

	// 医院记账
	@RequestMapping(value = "/findalllogcompany.handle")
	public ModelAndView findallcompanylog() {

		logCompanylist2 = logCompanyBiz.queryAll();
		
		System.out.println(logCompanylist2.size()+"a11111");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/logcompany");
		if (logCompanylist2.size() > 0) {
			mav.addObject("logCompanylist2", logCompanylist2);
		}
		return mav;

	}
}
