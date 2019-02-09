package xyz.cymedical.handle.yjn;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@RequestMapping(value = "/delparam.handle")
	public ModelAndView delparam(String param_id) {

		flag = paramBiz.delParam(param_id);
		if (flag == true) {
			System.out.println("成功");
		} else {
			System.out.println("失败");
		}

		paramlist = paramBiz.findAllParam();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.jiang/manageparam");
		mav.addObject("paramlist", paramlist);

		return mav;
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

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.jiang/addparam");

		return mav;
	}

	// 增加参数
	@RequestMapping(value = "addparam.handle")
	public ModelAndView addparam(String pid, String name) {

		flag = paramBiz.insertParam(pid, name);
		if (flag == true) {
			System.out.println("成功");
		} else {
			System.out.println("失败");
		}

		paramlist = paramBiz.findAllParam();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.jiang/manageparam");
		mav.addObject("paramlist", paramlist);

		return mav;
	}
}
