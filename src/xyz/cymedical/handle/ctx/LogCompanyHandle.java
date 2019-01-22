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
	@RequestMapping(value = "/findlogcompany.handle")
	public ModelAndView findcompanylog(String name) {

		System.out.println("2323232");

		logCompanylist = logCompanyBiz.queryByName("蓝们科技");

		System.out.println(logCompanylist.size());

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/logcompany");
		mav.addObject("logCompanylist", logCompanylist);
		return mav;

	}
}
