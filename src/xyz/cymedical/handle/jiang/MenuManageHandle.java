package xyz.cymedical.handle.jiang;

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

import xyz.cymedical.biz.jiang.TbMenuBiz;
import xyz.cymedical.biz.jiang.TbRoleDept;
import xyz.cymedical.entity.jiang.Tb_menu;
import xyz.cymedical.entity.jiang.Tb_role_dept;
import xyz.cymedical.entity.jiang.Tb_user;

@Controller
@RequestMapping("/menumanage")
public class MenuManageHandle {

	 
	private Tb_menu tbmenu;
 
	private List<Tb_menu> tbmenuall;
  
	@Resource
	private TbMenuBiz tbMenuBiz;
	@Resource
	private TbRoleDept tbRoleDept;
	 
	private List<Map<String,Object>> maplist;
	
	// 添加后台人员

//	@RequestMapping(value = "/adduser.handle")
//	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, Tb_user adduser) {
//
//		ModelAndView mav = new ModelAndView();
////		adduser.setRole_dept_id(1);
////		System.out.println("doctor="+adduser.getDoctor());
//		System.out.println(adduser.getRole_dept_id());
//		System.out.println("douctor=" + adduser.getDoctor());
//		if (adduser.getDoctor().equals("内科医生")) {
//			adduser.setRole_dept_id(1);
//		} else if (adduser.getDoctor().equals("外科医生")) {
//			adduser.setRole_dept_id(2);
//		} else if (adduser.getDoctor().equals("管理员")) {
//			adduser.setRole_dept_id(3);
//		}
//
//		System.out.println("qqqqqqqqqqqq+Role_dept_id=" + adduser.getRole_dept_id());
//		int ret = tbUserBiz.addUser(adduser);
//
//		if (ret == 1) {
//			System.out.println("添加成功...");
//			mav.setViewName("WEB-INF/view.jiang/usermanage");
//		}
//
////		mav.setViewName("WEB-INF/view.jiang/index");
//		mav.setViewName("WEB-INF/view.jiang/usermanage");
//
//		return mav;
//
//	}

//	// 显示
	@RequestMapping(value = "/select.handle")
	public ModelAndView findAll(HttpServletRequest request, HttpServletResponse response, Tb_menu tbmenu) {

		System.out.println("12345678");
		ModelAndView mav = new ModelAndView();
		tbmenuall=tbMenuBiz.selectMenu();
		request.setAttribute("tbmenuall", tbmenuall);
	 

		mav.setViewName("WEB-INF/view.jiang/menumanage");
		return mav;

	}
//
//	// 删除  
	@RequestMapping(value = "/delect.handle", method = RequestMethod.POST)
	public @ResponseBody String delect(HttpServletRequest request, HttpServletResponse response, String delectname) {
		String data = null;
		System.out.println("...=" + delectname);
		int menu_id = Integer.valueOf(delectname);
		
		int ret = tbMenuBiz.delete(menu_id);
		if (ret == 1) {
			data = "00";
		}

		return data;

	}
//
//	// 菜单序号查询
	@RequestMapping(value = "/addmenuid.handle", method = RequestMethod.POST) 
	public @ResponseBody String addMenuid(HttpServletRequest request, HttpServletResponse response, String name) {
		String addrole;
		System.out.println("...=" + name); 
		int ret=tbMenuBiz.addMenuid(name);
		
		
		if (ret==1) {
			addrole = "01";
		} else {
			addrole = "02";
		}
		System.out.println("xxxxxxj" + addrole);
		return addrole;

	}
//
//	// 部門查询第二补
//	@RequestMapping(value = "/adddeptto.handle")
//	public ModelAndView adddeptto(HttpServletRequest request, HttpServletResponse response, String datato) {
//		String addrole;
//		System.out.println("...=" + datato);
//		ModelAndView mav = new ModelAndView();
//		int datadept = Integer.valueOf(datato);
//		if (datadept == 01) {
//			addrole = "内科";
//		} else {
//			if (datadept == 02) {
//				addrole = "外科";
//			} else {
//				addrole = "管理员";
//			}
//		}
//		request.setAttribute("addrole", addrole);
//
//		mav.setViewName("WEB-INF/view.jiang/usermanage");
//		return mav;
//
//	}
//
//	// 禁用启用
//	@RequestMapping(value = "/updetestate.handle", method = RequestMethod.POST)
//	public @ResponseBody String updetestate(HttpServletRequest request, HttpServletResponse response, String userid,
//			String statet) {
//		String successs = null;
//		String state = null;
//		int user_id = Integer.valueOf(userid);
//		if (statet.equals("禁用")) {
//			state = "启用";
//		} else {
//			state = "禁用";
//		}
//		System.out.println("更改后的状态=" + state);
//
//		int ret = tbUserBiz.upState(user_id, state);
//		if (ret == 1) {
//			successs = "1";
//			System.out.println("修改成功");
//		} else {
//			successs = "0";
//			System.out.println("修改失败");
//		}
//
//		return successs;
//
//	}
//
//	// 修改人员信息一步
//	@RequestMapping(value = "/updete2.handle", method = RequestMethod.POST)
//	public ModelAndView updete2(HttpServletRequest request, HttpServletResponse response, String updetename) {
//		ModelAndView mav = new ModelAndView();
//
//		System.out.println("修改人员信息=" + updetename);
//		request.setAttribute("updetename", updetename);
//		mav.setViewName("WEB-INF/view.jiang/updeteuser");
//		return mav;
//
//	}
//
//	// 修改人员信息二部
//	@RequestMapping(value = "/updeteuser.handle", method = RequestMethod.POST)
//	public ModelAndView updeteuser(HttpServletRequest request, HttpServletResponse response, Tb_user upuser) {
//		ModelAndView mav = new ModelAndView();
// 
//		tbUserBiz.upUser(upuser);
//
//		mav.setViewName("WEB-INF/view.jiang/usermanage");
//		return mav;
//
//	}
//	
//	@RequestMapping(value = "/selectlittle.handle", method = RequestMethod.POST)
//	public ModelAndView selectlittle(HttpServletRequest request, HttpServletResponse response, String depts, String users,  String phones) {
//		ModelAndView mav = new ModelAndView();
//		System.out.println("11-="+depts);
//		System.out.println("11-="+users);
//		System.out.println("11-="+phones);
////		String account= "'%"+users+"%'";
////		System.out.println(account);
////		String sql="select * from tb_user where account like '%"+users+"%'";
////		System.out.println(sql);
//		maplist=tbUserBiz.selUser(depts, users, phones);
//		if (null != maplist && maplist.size() > 0) {
//			
//			request.setAttribute("maplist", maplist);
//		} else {
//			System.out.println("沒有數據");
//		}
//
//		mav.setViewName("WEB-INF/view.jiang/usermanage");
//		return mav;
//
//	}
	//修改第一步
	 
	
	@RequestMapping(value = "/updete1.handle", method = RequestMethod.POST)
	public ModelAndView updete2(HttpServletRequest request, HttpServletResponse response, String updetename) {
		ModelAndView mav = new ModelAndView();

		System.out.println("修改人员信息=" + updetename);
		request.setAttribute("updetename", updetename);
		mav.setViewName("WEB-INF/view.jiang/updetemenu");
		return mav;

	}

	// 修改人员信息二部
		@RequestMapping(value = "/updetemenu2.handle", method = RequestMethod.POST)
		public ModelAndView updeteuser(HttpServletRequest request, HttpServletResponse response, Tb_menu tb_menu) {
			System.out.println("修改");
			ModelAndView mav = new ModelAndView();
	 
			tbMenuBiz.upMenu(tb_menu);
			  
			System.out.println("修改成功");
			mav.setViewName("WEB-INF/view.jiang/menumanage");
			return mav;

		}
	
	
	
	
}
