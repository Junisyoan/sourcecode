package xyz.cymedical.handle.yjn;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.yjn.LogBiz;
import xyz.cymedical.entity.yjn.Log;

@Controller
@RequestMapping("/log")
public class LogHandle {
	@Resource
	public LogBiz logBiz;
	
	private List<Log> loglist = new ArrayList<Log>();
	
	//方法
	@RequestMapping(value = "/findAllLog.handle")
	public ModelAndView findlog() {
		loglist = logBiz.findAllLog();
		
		System.out.println(loglist);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/selectLog");
		mav.addObject("loglist", loglist);
		
		return mav;
		
	}
}
