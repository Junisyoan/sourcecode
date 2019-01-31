package xyz.cymedical.handle.xin;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.xin.BriefBiz;
import xyz.cymedical.biz.xin.DoctorBiz;

@Controller
@RequestMapping("/brief")
public class BriefHandle {

	@Resource
	private BriefBiz briefbiz; 			//小结的业务逻辑
	
	@Resource
	private DoctorBiz doctorbiz; 		//医生的业务逻辑
	
	List<Map<String,Object>> plist;			//项目列表
	
	List<Map<String,Object>> dlist;			//细项列表
	

	//普通小结
	@RequestMapping(value = "/normal.handle")
	public ModelAndView check(String result,String id) {
		
		boolean f=briefbiz.Normal(result,id);
		
		dlist=doctorbiz.findMyDetail(Integer.valueOf(DoctorHandle.projectid),Integer.valueOf(DoctorHandle.patientid));
		
		System.out.println("dlist="+dlist);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("projectname", DoctorHandle.projectname);
		mav.addObject("keshi", DoctorHandle.keshi);
		mav.addObject("dlist", dlist);

		mav.setViewName("WEB-INF/doctor.xin/brief");
		return mav;
		
	}

	//检验小结
	@RequestMapping(value = "/check.handle")
	public ModelAndView check(String result,String tips,String id) {
		
		boolean f=briefbiz.Check(result,tips,id);
		
		dlist=doctorbiz.findMyDetail(Integer.valueOf(DoctorHandle.projectid),Integer.valueOf(DoctorHandle.patientid));
		
		System.out.println("dlist="+dlist);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("projectname", DoctorHandle.projectname);
		mav.addObject("keshi", DoctorHandle.keshi);
		mav.addObject("dlist", dlist);

		mav.setViewName("WEB-INF/doctor.xin/brief");
		return mav;
		
	}
	
}
