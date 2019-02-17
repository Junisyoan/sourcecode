package xyz.cymedical.handle.ctx;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.entity.xin.Combo;
import xyz.cymedical.mapper.zsc.ComboMapper;

@Controller
@RequestMapping("/home")
public class HomeHandle {

	@Resource
	private ComboMapper comboMapper;

	private List<Combo> combolist = new ArrayList<Combo>();

	public HomeHandle() {

	}

	// 热门套餐查询
	@RequestMapping(value = "/findcombo.so", method = RequestMethod.GET)
	public ModelAndView findcombo() {

		combolist = comboMapper.queryCombo();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("hotcombos");
		if (combolist.size() > 0) {
			mav.addObject("combolist", combolist);
		}
		return mav;

	}

	// 主页
	@RequestMapping(value = "/findindex.so", method = RequestMethod.GET)
	public ModelAndView findindex() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;

	}

	// 关于
	@RequestMapping(value = "/findabout.so", method = RequestMethod.GET)
	public ModelAndView findabout() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("about");
		return mav;

	}

	// 项目介绍
	@RequestMapping(value = "/findencyclopedia.so", method = RequestMethod.GET)
	public ModelAndView findprojects() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("encyclopedia");
		return mav;

	}

	// 关于
	@RequestMapping(value = "/findcontact.so", method = RequestMethod.GET)
	public ModelAndView findcontact() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("contact");
		return mav;

	}

}
