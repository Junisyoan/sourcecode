package xyz.cymedical.handle.yjn;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.yjn.ParamBiz;
import xyz.cymedical.entity.yjn.Param;

@Controller
@RequestMapping("/param")
public class ParamHandle {
	@Resource
	public ParamBiz paramBiz;

	private List<Param> paramlist = new ArrayList<Param>();

	// 查询所有方法
	@RequestMapping(value = "/findAllParam.handle")
	public ModelAndView findparam() {
		paramlist = paramBiz.findAllParam();

		System.out.println(paramlist);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/manageparam");
		mav.addObject("paramlist", paramlist);

		return mav;
	}
}
