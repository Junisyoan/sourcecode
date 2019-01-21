package xyz.cymedical.handle.xin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.xin.DoctorBiz;


@Controller
@RequestMapping("/doctor")
public class DoctorHandle {

	@Resource
	private DoctorBiz doctorbiz; 			//医生的业务逻辑
	
	@RequestMapping(value = "/findAll.handle")
	public ModelAndView findAll() {

		System.out.println("2222");

		System.out.println(doctorbiz.findMyDetails(""));

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.jiang/index");
		return mav;

	}
}
