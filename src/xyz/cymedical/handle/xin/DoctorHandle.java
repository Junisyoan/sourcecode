package xyz.cymedical.handle.xin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.xin.DoctorBiz;
import xyz.cymedical.entity.xin.Patient_Project;
import xyz.cymedical.entity.zsc.Project;


@Controller
@RequestMapping("/doctor")
public class DoctorHandle {

	@Resource
	private DoctorBiz doctorbiz; 			//医生的业务逻辑
	
	List<Patient_Project> plist = new ArrayList<Patient_Project>();
	
	
	@RequestMapping(value = "/findProject.handle")
	public ModelAndView findProject(String onecode) {

		System.out.println("onecode="+onecode);

//		System.out.println(doctorbiz.findMyProject(onecode));
//		
//		plist.add(new Patient_Project(1,2,"未接收"));
//		plist.add(new Patient_Project(2,3,"未接收"));
//		plist.add(new Patient_Project(2,4,"未接收"));
//		plist.add(new Patient_Project(2,5,"未接收"));
		

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
	
	@RequestMapping(value = "/Detail.handle")
	public ModelAndView getDetail(String patientid,String projectid,String projectname) {

		System.out.println("getDetail....");
		
		System.out.println("patientid="+patientid);
		System.out.println("projectid="+projectid);
		System.out.println("projectname="+projectname);

		ModelAndView mav = new ModelAndView();
		mav.addObject("projectname", projectname);
		mav.setViewName("WEB-INF/doctor.xin/brief");
		return mav;
	}
	
}
