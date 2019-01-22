package xyz.cymedical.handle.xin;

import java.util.List;
import java.util.Map;

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
	
	List<Map<String,Object>> plist;			//项目列表
	
	List<Map<String,Object>> dlist;			//细项列表
	

	// 查询一维码对应病人的导检单
	@RequestMapping(value = "/findProject.handle")
	public ModelAndView index(String onecode) {

		System.out.println("onecode=" + onecode);

		System.out.println(doctorbiz.findMyProject(onecode));
		
		plist=doctorbiz.findMyProject(onecode);

		ModelAndView mav = new ModelAndView();
		mav.addObject("prolist", plist);
		mav.setViewName("WEB-INF/doctor.xin/pro_receive");
		return mav;

	}

	//最初的页面
	@RequestMapping(value = "/first.handle")
	public ModelAndView first() {

		System.out.println("index....");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/doctor.xin/pro_receive");

		return mav;
	}

	// 根据选中项目跳转至对应小结
	@RequestMapping(value = "/Detail.handle")
	public ModelAndView getDetail(String patientid, String projectid, String projectname) {

		System.out.println("getDetail....");
		
		System.out.println("patientid=" + patientid);
		System.out.println("projectid=" + projectid);
		System.out.println("projectname=" + projectname);

		dlist=doctorbiz.findMyDetail(Integer.valueOf(projectid),Integer.valueOf(patientid));
		
		System.out.println("dlist="+dlist);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("projectname", projectname);
		mav.addObject("dlist", dlist);

		mav.setViewName("WEB-INF/doctor.xin/brief");
		return mav;
	}

//	@RequestMapping(value = "/receive.handle")
//	public ModelAndView getDetail(String patient_project_id,String code,String projectname) {
//
//		System.out.println("receive....");
//		System.out.println("patient_project_id=" + patient_project_id);
//
//		boolean f=doctorbiz.receive(Integer.valueOf(patient_project_id));
//		
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("WEB-INF/doctor.xin/pro_receive");
//		return mav;
//	}

	
	
	
	
}
