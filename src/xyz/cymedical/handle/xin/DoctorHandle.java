package xyz.cymedical.handle.xin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	
	 List<Map<String,Object>> plist;
	
	//查询一维码对应病人的导检单
	@RequestMapping(value = "/findProject.handle")
	public ModelAndView findProject(String onecode) {

		System.out.println("onecode="+onecode);

		System.out.println(doctorbiz.findMyProject(onecode));
		
		plist=doctorbiz.findMyProject(onecode);

		ModelAndView mav = new ModelAndView();
		mav.addObject("prolist", plist);
		mav.setViewName("WEB-INF/doctor.xin/pro_receive");
		return mav;

	}
	
	//测试
	@RequestMapping(value = "/index.handle")
	public ModelAndView find() {

		System.out.println("index....");
		System.out.println(doctorbiz.findMyProject(""));

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/doctor.xin/pro_receive");
		
		return mav;
	}
	
	//根据选中项目跳转至对应小结
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
