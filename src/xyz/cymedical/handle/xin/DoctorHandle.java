package xyz.cymedical.handle.xin;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.xin.DoctorBiz;
import xyz.cymedical.entity.jiang.Tb_menu;
import xyz.cymedical.entity.jiang.Tb_user;

//单检医生
@Controller
@RequestMapping("/doctor")
public class DoctorHandle {

	@Resource
	private DoctorBiz doctorbiz; 			//医生的业务逻辑
	
	List<Map<String,Object>> plist;			//项目列表
	
	List<Map<String,Object>> dlist;			//细项列表
	
	public static String patientid;			//病人id
	
	public static String projectid;			//项目id
	
	public static String projectname;		//项目名称
	
	public static String keshi;				//科室名称
	
	public static String onecode;			//条码号

	
	// 查询一维码对应病人的导检单
	@RequestMapping(value = "/login.handle")
	public ModelAndView login(HttpServletRequest request,String account,String pwd) {

		System.out.println("username="+account);
		System.out.println("pwd="+pwd);

		Tb_user user = new Tb_user();
		user=doctorbiz.login(account,pwd);
		System.out.println("user="+user);


		if(user!=null) {
			ModelAndView mav = new ModelAndView();
			request.getSession().setAttribute("USER", user);
			
			
			//用户对应菜单列表
			List<Tb_menu> mlist = doctorbiz.getMyMenu(user.getUser_id(),user.getRole_dept_id());
			System.out.println("mlist="+mlist);
			
			
			mav.addObject("mlist", mlist);
			mav.addObject("USER", user);
			mav.setViewName("WEB-INF/doctor.xin/doctorindex");
			return mav;
			
		}else {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("doctorlogin");
			return mav;
		}
		

	}
	
	
	// 查询一维码对应病人的导检单
	@RequestMapping(value = "/findProject.handle")
	public ModelAndView index(String onecode) {

		System.out.println("onecode=" + onecode);

		this.onecode=onecode;
		
		System.out.println(doctorbiz.findMyProject(onecode));
		
		plist=doctorbiz.findMyProject(onecode);

		ModelAndView mav = new ModelAndView();
		mav.addObject("prolist", plist);
		if(plist!=null && plist.size()>0) {
			mav.addObject("patient", plist.get(0));//已包含病人信息
		}
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
	public ModelAndView getDetail(String patientid, String projectid, String projectname,String keshi,String code) {

		System.out.println("getDetail....");
		
		System.out.println("patientid=" + patientid);
		System.out.println("projectid=" + projectid);
		System.out.println("projectname=" + projectname);
		
		this.patientid=patientid;
		this.projectid=projectid;
		this.projectname=projectname;
		this.keshi=keshi;

		dlist=doctorbiz.findMyDetail(Integer.valueOf(projectid),Integer.valueOf(patientid));
		
		System.out.println("dlist="+dlist);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("projectname", projectname);
		mav.addObject("projectid", projectid);
		mav.addObject("keshi", keshi);
		mav.addObject("dlist", dlist);
		mav.addObject("code", code);

		mav.setViewName("WEB-INF/doctor.xin/brief");
		return mav;
	}

	//项目接收
	@RequestMapping(value = "/receive.handle")
	public ModelAndView receive(HttpServletRequest req,String patient_project_id,String onecode) {

		System.out.println("receive....");
		System.out.println("patient_project_id=" + patient_project_id);
		System.out.println("onecode=" + onecode);

		Tb_user user=(Tb_user) req.getSession().getAttribute("USER");
		
		boolean f=doctorbiz.receive(Integer.valueOf(patient_project_id),user.getUser_id());
		
		System.out.println("f="+f);
		plist=doctorbiz.findMyProject(onecode);

		ModelAndView mav = new ModelAndView();
		mav.addObject("prolist", plist);
		mav.setViewName("WEB-INF/doctor.xin/pro_receive");
		return mav;
	}

//	//小结
//	@RequestMapping(value = "/brief.handle")
//	public ModelAndView brief(String data) {
//
//		System.out.println("data...."+data);
//		ModelAndView mav = new ModelAndView();
////		mav.setViewName("WEB-INF/doctor.xin/pro_receive");
//
//		return mav;
//	}

}
