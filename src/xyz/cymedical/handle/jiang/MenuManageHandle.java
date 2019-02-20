package xyz.cymedical.handle.jiang;

import java.util.HashMap;
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

import net.sf.json.JSONArray;
import xyz.cymedical.biz.jiang.TbMenuBiz;
import xyz.cymedical.biz.jiang.TbPowerBiz;
import xyz.cymedical.biz.jiang.TbRoleDept;
import xyz.cymedical.entity.jiang.Tb_dept;
import xyz.cymedical.entity.jiang.Tb_menu;
import xyz.cymedical.entity.jiang.Tb_power;
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
	private TbPowerBiz tbPowerBiz;
	@Resource
	private TbRoleDept tbRoleDept;
	
	private Tb_power tb_power;
	 
	private List<Map<String,Object>> maplist;
	
	// 添加后台人员

// 

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
		tb_power=tbPowerBiz.selectid(menu_id);
		if(tb_power!=null) { 
		int power_id=tb_power.getPower_id();
		System.out.println("power_id="+power_id);
		
		/*删除权限id前 先删除权限角色表*/
		int rettt=tbPowerBiz.deletepower_role(power_id);
		if(rettt==1) {
			
		
		/*删除菜单前 先删除权限*/
		int rett=tbPowerBiz.delectMenuId(power_id);
		System.err.println("rett="+rett);
		 if(rett==1) {
			 int ret = tbMenuBiz.delete(menu_id); 
			 if (ret == 1) {
				 data = "00";
			 }
		 }else {
			 data = "11";
		 }
		}
		}
		 int ret = tbMenuBiz.delete(menu_id); 
		 if (ret == 1) {
			 data = "00";
		 
	 }else {
		 data = "11";
	 }
		return data;

	}
//
//	// 添加第一步菜单名查询
	@RequestMapping(value = "/addmenuid.handle", method = RequestMethod.POST) 
	public @ResponseBody String addMenuid(HttpServletRequest request, HttpServletResponse response, String name) {
		String addrole;
		System.out.println("lala...=" + name); 
		int ret=tbMenuBiz.addMenuid(name);
		System.out.println("ret="+ret);
		
		if (ret>1) {
			addrole = "02";
		} else {
			addrole = "01";
		}
		System.out.println("xxxxxxj" + addrole);
		return addrole;

	}
	//添加第二步 正式添加
	@RequestMapping(value = "/addmenu.handle", method = RequestMethod.POST) 
	public @ResponseBody String  addMenu(HttpServletRequest request, HttpServletResponse response, Tb_menu tb_menu) {
		ModelAndView mav = new ModelAndView();
		System.out.println("-1");
		int ret=tbMenuBiz.addMenu(tb_menu);
		String re = "";
		if(ret==1) {  
			re="1";
		}else {  
			re="0";
		} 

		return re;
	}
// 
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
			System.out.println("修改内容为="+tb_menu);
			int ret=tbMenuBiz.upMenu(tb_menu);
			  if(ret==1) {
			System.out.println("修改成功");
			mav.setViewName("WEB-INF/view.jiang/menumanage");
			  }else {
				  
				  mav.setViewName("WEB-INF/view.jiang/err");
			  }
			return mav;

		}
	
		// 查
		@RequestMapping(value = "/selectCompany.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
		public @ResponseBody String selectCompany(Tb_menu tb_menu) { 
			Map<String, Object> map = new HashMap<String, Object>(); 
			map.put("tb_menu", tb_menu);
			 
			List<Map<String,Object>> companys = tbMenuBiz.selectCompany(map);  
			String str = JSONArray.fromObject(companys).toString();  
			return str;
		}
	
	
}
