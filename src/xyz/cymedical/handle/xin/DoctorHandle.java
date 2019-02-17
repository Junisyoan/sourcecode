package xyz.cymedical.handle.xin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@RequestMapping(value = "/login.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String login(HttpServletRequest request,String account,String pwd) {

		System.out.println("username="+account);
		System.out.println("pwd="+pwd);

		Tb_user user = new Tb_user();
		user=doctorbiz.login(account,pwd);
		System.out.println("user="+user);
		
		
		String Status="";
		
		if(user!=null) {
			//保存到session
			request.getSession().setAttribute("user", user);
			
			//获取用户所属科室
			String depart = doctorbiz.getDepart(user.getParam_id());
			request.getSession().setAttribute("depart", depart);
			
			//身份判断,只有身份为医生或总检医生才能登陆
			String type=doctorbiz.getStatus(user.getRole_dept_id());
			if(type.equals("医生") || type.equals("总检医生")) {
				Status=type;
			}
		}
		return Status;
		

	}
	
	//去往index
	@RequestMapping(value = "/toindex.handle")
	public ModelAndView toindex(HttpServletRequest req) {
		
		ModelAndView mav = new ModelAndView();
		Tb_user user=(Tb_user) req.getSession().getAttribute("user");
		
		//用户对应菜单列表
		List<Tb_menu> mlist = doctorbiz.getMyMenu(user.getUser_id(),user.getRole_dept_id());
		System.out.println("mlist="+mlist);
		
		mav.addObject("mlist", mlist);
		mav.addObject("user", user);
		mav.setViewName("WEB-INF/doctor.xin/doctorindex");
		return mav;

	}
	
	
	
	
	
	
	// 查询一维码对应病人的导检单
	@RequestMapping(value = "/findProject.handle")
	public ModelAndView index(HttpServletRequest req,String onecode) {


		this.onecode=onecode;
		
		Tb_user user=(Tb_user) req.getSession().getAttribute("user");

		plist=doctorbiz.findMyProject(onecode);
		List<Map<String,Object>> pplist = new ArrayList<Map<String,Object>>();//

		if(plist!=null && plist.size()>0) {
			for (int i = 0; i < plist.size(); i++) {
				Map m=plist.get(i);
				if(user.getParam_id()==Integer.parseInt(m.get("param_id").toString())) {
					pplist.add(m);
				}
			}
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("prolist", pplist);
		
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

		Tb_user user=(Tb_user) req.getSession().getAttribute("user");
		
		boolean f=doctorbiz.receive(Integer.valueOf(patient_project_id),user.getUser_id());
		
		System.out.println("f="+f);
		plist=doctorbiz.findMyProject(onecode);

		ModelAndView mav = new ModelAndView();
		mav.addObject("prolist", plist);
		mav.setViewName("WEB-INF/doctor.xin/pro_receive");
		return mav;
	}

	//退出
	@RequestMapping(value = "/exit.handle")
	public void brief(HttpServletRequest request,HttpServletResponse resp) {
		String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath() + "/";
		//退出时销毁登录信息
		request.getSession().invalidate();
		try {
			resp.sendRedirect(path+"doctorlogin.jsp?login=3");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
