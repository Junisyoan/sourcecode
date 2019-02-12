package xyz.cymedical.handle.xin;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.xin.BriefBiz;
import xyz.cymedical.biz.xin.DoctorBiz;

//总检医生
@Controller
@RequestMapping("/chiefdoctor")
public class ChiefDoctorHandle {

	@Resource
	private DoctorBiz doctorbiz; 			//医生的业务逻辑
	
	@Resource
	private BriefBiz briefbiz; 	 			//小结的业务逻辑
	
	List<Map<String,Object>> plist;			//项目列表
	
	List<Map<String,Object>> dlist;			//细项列表
	
	private static String mycode;			//保存条码
	
	// 查询一维码对应病人的导检单
	@RequestMapping(value = "/findProject.handle")
	public ModelAndView index(String onecode) {

		System.out.println("onecode=" + onecode);
		
		mycode=onecode;
		
		plist=doctorbiz.findMyProject(onecode);
		
		dlist=doctorbiz.findAllDetail(onecode);

		System.out.println("plist="+plist);
		
		System.out.println("dlist="+dlist);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("plist", plist);
		mav.addObject("dlist", dlist);
		mav.addObject("onecode", onecode);
		
		
		if(dlist!=null && dlist.size()>0) {
		mav.addObject("flag", "true");
		}

		mav.setViewName("WEB-INF/doctor.xin/summarize_receive");
		return mav;

	}

	//最初的页面
	@RequestMapping(value = "/first.handle")
	public ModelAndView first() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/doctor.xin/summarize_receive");

		return mav;
	}

//	// 根据选中项目跳转至对应小结
//	@RequestMapping(value = "/Detail.handle")
//	public ModelAndView getDetail(String patientid, String projectid, String projectname,String keshi,String code) {
//
//		System.out.println("getDetail....");
//
//		dlist=doctorbiz.findMyDetail(Integer.valueOf(projectid),Integer.valueOf(patientid));
//		
//		System.out.println("dlist="+dlist);
//		
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("projectname", projectname);
//		mav.addObject("keshi", keshi);
//		mav.addObject("dlist", dlist);
//		mav.addObject("code", code);
//
//		mav.setViewName("WEB-INF/doctor.xin/brief");
//		return mav;
//	}
	
	// 跳转至总结
	@RequestMapping(value = "/tosummarize.handle")
	public ModelAndView tosummarize(String patientid, String projectid, String projectname,String keshi,String code) {

		System.out.println("tosummarize....");
		
		dlist = doctorbiz.findAllDetail(mycode);
		
		System.out.println("跳转至总结dlist..."+dlist);

		String time=(String) dlist.get(0).get("time");
		
		System.out.println("time="+time);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("dlist", dlist);
		mav.addObject("time", time);
		mav.addObject("mycode", mycode);
		
		mav.setViewName("WEB-INF/doctor.xin/summarize");
		return mav;
	}
	
	// 总结
	@RequestMapping(value = "/dosummarize.handle")
	public void summary(String advice, String guide) {

		System.out.println("dosummarize");
		System.out.println("advice="+advice);
		System.out.println("guide="+guide);
		
		dlist = doctorbiz.findAllDetail(mycode);
		
		doctorbiz.addsummarize(advice,guide);
		
		String sumid=doctorbiz.findsumid();
		
		System.out.println("sumid="+sumid);
		
		for(int i=0;i<dlist.size();i++) {
			
			int briefid=(Integer) dlist.get(i).get("brief_id");
			
			briefbiz.addsummarize(briefid,sumid);
			
		}
		
		
	}
}
