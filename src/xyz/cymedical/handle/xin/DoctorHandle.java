package xyz.cymedical.handle.xin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.xin.DoctorBiz;
import xyz.cymedical.entity.zsc.Project;


@Controller
@RequestMapping("/doctor")
public class DoctorHandle {

	@Resource
	private DoctorBiz doctorbiz; 			//医生的业务逻辑
	
	@RequestMapping(value = "/findProject.handle")
	public ModelAndView findProject(String onecode) {

		System.out.println("onecode="+onecode);

		System.out.println(doctorbiz.findMyProject(onecode));
		
//		List<Project> plist = 
		
		

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/doctor.xin/pro_receive");
		return mav;

	}
	
	@RequestMapping(value = "/index.handle")
	public ModelAndView find() {

		System.out.println("index....");

		System.out.println(doctorbiz.findMyProject(""));

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/doctor.xin/pro_receive");
		return mav;

	}
	
}
