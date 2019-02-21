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

import xyz.cymedical.biz.yjn.ParamBiz;
import xyz.cymedical.entity.yjn.Parameter;

@Controller
@RequestMapping("/param")
public class ParamHandle {
	@Resource
	public ParamBiz paramBiz;

	private boolean flag;

	private List<Parameter> paramlist = new ArrayList<Parameter>();

	// 查询所有方法
	@RequestMapping(value = "/findAllParam.handle")
	public ModelAndView findparam() {
		paramlist = paramBiz.findAllParam();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.jiang/manageparam");
		mav.addObject("paramlist", paramlist);

		return mav;
	}

	// 删除方法
	@RequestMapping(value = "/delparam.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String delLog(String param_id) {
		String result = "";

		flag = paramBiz.delParam(param_id);

		if (flag == true) {
			result = "success";
		} else {
			result = "failure";
		}

		return result;

	}

	// 查找参数
	@RequestMapping(value = "/searchparam.handle")
	public ModelAndView searchparam(String param_id, String pid, String name) {

		paramlist = paramBiz.searchParam(param_id, pid, name);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.jiang/manageparam");
		mav.addObject("paramlist", paramlist);

		return mav;
	}

	// 新增页面显示
	@RequestMapping(value = "showaddparam.handle")
	public ModelAndView showaddparam() {
		
		paramlist = paramBiz.findAllParam();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.jiang/addparam");
		mav.addObject("paramlist", paramlist);

		return mav;
	}

	// 增加参数
	@RequestMapping(value = "/addparam.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String addparam(String pid, String name) {
		String result = "";

		flag = paramBiz.insertParam(pid, name);

		if (flag == true) {
			result = "success";
		} else {
			result = "failure";
		}

		return result;
	}

	// 修改界面显示
	@RequestMapping(value = "showmodifyparam.handle")
	public ModelAndView showmodifyparam(String param_id) {
		
		paramlist = paramBiz.searchParam(param_id, "", "");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.jiang/modifyparam");
		mav.addObject("paramlist", paramlist);

		return mav;
	}
	
	@RequestMapping(value = "/modifyparam.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String modifyparam(String param_id,String pid, String name) {
		String result = "";

		System.out.println(param_id+"+"+pid+"+"+name);
		
		flag = paramBiz.modifyParam(param_id, pid, name);

		if (flag == true) {
			result = "success";
		} else {
			result = "failure";
		}

		return result;
	}

}
