package xyz.cymedical.handle.yjn;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.yjn.LogBiz;
import xyz.cymedical.entity.jiang.Tb_user;
import xyz.cymedical.entity.yjn.Log;
import xyz.cymedical.tools.zsc.Encryption;

@Controller
@RequestMapping("/log")
public class LogHandle {
	@Resource
	public LogBiz logBiz;

	boolean flag = false;

	private List<Log> loglist = new ArrayList<Log>();

	// 查询所有方法
	@RequestMapping(value = "/findAllLog.handle")
	public ModelAndView findlog() {
		loglist = logBiz.findAllLog();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.jiang/selectLog");
		mav.addObject("loglist", loglist);

		return mav;

	}

	// 删除方法
	@RequestMapping(value = "/delLog.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String delLog(HttpServletRequest req, @RequestParam(value = "arrin") String[] arrin) {
		String result = "";

		System.out.println("arrin=" + arrin[0]);

		for (int i = 0; i < arrin.length; i++) {
			flag = logBiz.delLog(arrin[i]);
			if (i == arrin.length - 1) {
				if (flag == true) {
					result = "success";
				} else {
					result = "failure";
				}
			}
		}
		return result;
	}

	// 查询日志
	@RequestMapping(value = "/searchlog.handle")
	public ModelAndView searchlog(String name, String opera, String time) {

		loglist = logBiz.searchLog(name, opera, time);

		System.out.println(loglist);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.jiang/selectLog");
		mav.addObject("loglist", loglist);

		return mav;

	}

}
