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
	public ModelAndView findcompanylog() {

		// 没写完，数据未获取
		String name = "";

		logCompanylist = logCompanyBiz.queryByName(name);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/logcompany");
		mav.addObject("logCompanylist", logCompanylist);
		return mav;

	}
}
