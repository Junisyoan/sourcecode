package xyz.cymedical.handle.jiang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import xyz.cymedical.biz.jiang.TbPowerBiz;
import xyz.cymedical.biz.jiang.TbRoleBiz;
import xyz.cymedical.biz.jiang.TbRolePower;
import xyz.cymedical.biz.jiang.TbUserBiz;
import xyz.cymedical.entity.jiang.Tb_menu;
import xyz.cymedical.entity.jiang.Tb_power;
import xyz.cymedical.entity.jiang.Tb_role; 


@Controller
@RequestMapping("/powermanage")
public class PowerManageHandle {
	    
		@Resource
		private TbRolePower tbRolePower;
		@Resource
		private TbPowerBiz TbPowerBiz;  
		
		private List<Tb_role> roleall;
		@Resource
		private TbRoleBiz tbRoleBiz;
		
		private Tb_power tbpower;
		   
//		private List<Map<String,Object>> maplist;
		 
		
		private List<Tb_power> maplist;
		
		// 后台进入 显示

		@RequestMapping(value = "/selectpower.handle")
		public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, Tb_power tbpower) {
			ModelAndView mav = new ModelAndView();
			System.out.println("qweewq");
			
			 maplist = TbPowerBiz.selectPower();
			 
			request.setAttribute("maplist", maplist);
			
			mav.setViewName("WEB-INF/view.jiang/powermanage");
			return mav;


			
			
		}
		
		@RequestMapping(value = "/delect.handle",method = RequestMethod.POST)
		public @ResponseBody String deletePower(HttpServletRequest request, HttpServletResponse response, String delectname) {
//			ModelAndView mav = new ModelAndView();
			
			System.out.println("delectname="+delectname);
			String data = null;
			int power_id=Integer.valueOf(delectname);
			int ret=TbPowerBiz.deletePower(power_id);
			
			if(ret==1) {
//				mav.setViewName("WEB-INF/view.jiang/powermanage");
				data = "00";
			}
			  
			return data;
 	
		}
		 
		
		@RequestMapping(value = "/addPower.handle")
		public ModelAndView addPower(HttpServletRequest request, HttpServletResponse response, Tb_power tb_power,String roleid) {
			ModelAndView mav = new ModelAndView();  
//			int role_id=Integer.valueOf(roleid); 
//			int power_id=tb_power.getPower_id();
//			tbRolePower.addmanage(role_id, power_id);////////c此处存在错误
			 
			int ret=TbPowerBiz.addPower(tb_power);
			
			if(ret==1) {
				
				mav.setViewName("WEB-INF/view.jiang/powermanage");
			}
			  
			return mav;
 
		}
		//修改第一步
		@RequestMapping(value = "/updete1.handle", method = RequestMethod.POST)
		public ModelAndView updete2(HttpServletRequest request, HttpServletResponse response, String updetename) {
			ModelAndView mav = new ModelAndView();

			System.out.println("修改人员信息=" + updetename);
			request.setAttribute("updetename", updetename);
			mav.setViewName("WEB-INF/view.jiang/updetepower");
			return mav;

		}
		//修改第二步
	 
		@RequestMapping(value = "/updetepower2.handle", method = RequestMethod.POST)
		public ModelAndView updeteuser(HttpServletRequest request, HttpServletResponse response, Tb_power tbpower) {
			ModelAndView mav = new ModelAndView();
	 
				System.out.println(tbpower.getPower_id());
			 	System.out.println(tbpower.getMenu_id());
			 	System.out.println(tbpower.getName());
			 	int ret=TbPowerBiz.upPower(tbpower);
			 	if(ret==1) {
			 		
			 		mav.setViewName("WEB-INF/view.jiang/powermanage");
			 	}

			return mav;

		}
		
		// 查
		@RequestMapping(value = "/selectCompany.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
		public @ResponseBody String selectCompany(Tb_power tb_power) { 
			System.out.println("权限模糊查询进...");
			Map<String, Object> map = new HashMap<String, Object>(); 
			map.put("tb_power", tb_power);
			 
			List<Map<String,Object>> companys = TbPowerBiz.selectCompany(map);
			String str = JSONArray.fromObject(companys).toString();  
			
			System.out.println("权限查询="+companys.size());
			return str;
		}
		//新权限显示用户
		@RequestMapping(value = "/newpower.handle",method = RequestMethod.GET, produces = "application/json;charset=utf-8")
		public ModelAndView newPower(HttpServletRequest request) {
			ModelAndView mav = new ModelAndView();
			System.out.println("youmei有進入新权限");
			roleall=tbRoleBiz.selectRole();
			
			request.setAttribute("roleall", roleall);
			System.out.println("juese="+roleall.get(0).getName());
			
			mav.setViewName("WEB-INF/view.jiang/menu_grant");
			return mav;
  
		}
		/**
		 * 查找已分配权限
		 * 
		 *  
		 */
		 
		@RequestMapping(value= "/allot.handle",method = RequestMethod.GET, produces = "application/json;charset=utf-8")
		public @ResponseBody String allot( String role_id) {

			System.out.println(1);
//			List<Menu> menuList = menuBiz.findMenu(role.getRole_id());
//			System.out.println(role_id);
			int role_idd=Integer.valueOf(role_id);
//		 	int role_idd=role.getRole_id();
			
			System.out.println("点击权限名 弹出id="+role_idd);
			List<Tb_menu> menuList=tbRoleBiz.findMenu(role_idd);
 
			System.out.println("menuList="+menuList);
			
			List<Map<String, Object>> mapList = menuToMap(menuList); 
			
			JSONArray jb=JSONArray.fromObject(mapList) ;
			//System.out.println("json="+jb); 
//			System.out.println("bbb="+);
			//return jb;
		//String dddd="132"; 
			return jb.toString();

		}
		
		/**
		 * 查找未分配权限
		 * 
		 * @return
		 */ 
		@RequestMapping(value= "/unallot.handle" ,method = RequestMethod.GET, produces = "application/json;charset=utf-8")
		public  @ResponseBody String  unallot( String role_id) {
 
			System.out.println("未分配权限");
			int role_idd=Integer.valueOf(role_id);
			List<Tb_menu> menuList=tbRoleBiz.findUnMenu(role_idd);

			List<Map<String, Object>> mapList = menuToMap(menuList);

			JSONArray jb=JSONArray.fromObject(mapList) ;
			return jb.toString();
		}
		
		/**
		 * 将查询到到menuList转为map
		 * 
		 * @param menuList
		 * @return
		 */
		private List<Map<String, Object>> menuToMap(List<Tb_menu> menuList) {

			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

			for (Tb_menu menu : menuList) {
				Map<String, Object> node = new HashMap<String, Object>();
 
				node.put("id", menu.getMenu_id());
				node.put("name", menu.getName());
				node.put("pId", menu.getSuperior());
				System.out.println("555555555555="+menu.getMenu_id()+"111"+menu.getSuperior());

				if (menu.getSuperior()!= 0) {
					mapList.add(node);
				} else {
					node.put("open", true);// 节点展开

					for (Tb_menu m : menuList) {
						if (m.getSuperior() == menu.getMenu_id()) {

							// 如果有子节点则添加
							mapList.add(node);
							break;
						}
					}
				}
			}
			System.out.println("mapList========"+mapList);
			return mapList;
		}
 
	
 
	 
		
		
}
