package xyz.cymedical.handle.jiang;

import java.io.IOException;
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
import xyz.cymedical.biz.jiang.TbMenuBiz;
import xyz.cymedical.biz.jiang.TbPowerBiz;
import xyz.cymedical.biz.jiang.TbRoleBiz;
import xyz.cymedical.biz.jiang.TbRolePower;
import xyz.cymedical.biz.jiang.TbUserBiz;
import xyz.cymedical.entity.jiang.Tb_menu;
import xyz.cymedical.entity.jiang.Tb_power;
import xyz.cymedical.entity.jiang.Tb_role;
import xyz.cymedical.entity.jiang.Tb_role_power; 


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
		
		@Resource
		private Tb_role_power tb_role_power;
		
		private Tb_menu tb_menu;
		
		@Resource
		private TbMenuBiz tbMenuBiz;
		   
//		private List<Map<String,Object>> maplist;
		 
		int  rett;
		
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
 
			
			System.out.println("delectname="+delectname);
			String data = null;
			int power_id=Integer.valueOf(delectname);
			/*先权限角色表删除 还要先查询一下存在此id字段  */
			  
			tb_role_power.setPower_id(power_id);
			System.out.println("tb_role_power="+tb_role_power.getPower_id());
			List<Tb_role_power> tbrolepower= tbRolePower.selectrp(tb_role_power);
			if(tbrolepower.size()>0) {
				 
			tbRolePower.delectrp(tb_role_power);
			}
			int ret=TbPowerBiz.deletePower(power_id);
			
			if(ret==1) { 
				data = "00";
			}
			
			
			return data;
 	
		}
		 
		
		@RequestMapping(value = "/addPower.handle")
		public ModelAndView addPower(HttpServletRequest request, HttpServletResponse response, Tb_power tb_power,String roleid) {
			ModelAndView mav = new ModelAndView();  
			int role_id=Integer.valueOf(roleid); 
			int power_id=tb_power.getPower_id();
			
//			 
			int ret=TbPowerBiz.addPower(tb_power);
			
			if(ret==1) {
				tb_role_power.setRole_id(role_id);
				tb_role_power.setPower_id(power_id);
				
				tbRolePower.addmanage(tb_role_power); 
				
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
			int role_idd=Integer.valueOf(role_id); 
			
			System.out.println("点击权限名 弹出id="+role_idd);
			List<Tb_menu> menuList=tbRoleBiz.findMenu(role_idd);
 
			System.out.println("menuList="+menuList);
			
			List<Map<String, Object>> mapList = menuToMap(menuList); 
			
			JSONArray jb=JSONArray.fromObject(mapList) ; 
			
			return jb.toString();

		}
		
		/**
		 * 查找未分配权限
		 * 
		 * @return
		 */ 
		@RequestMapping(value= "/unallot.handle" ,method = RequestMethod.GET, produces = "application/json;charset=utf-8")
		public  @ResponseBody String  unallot(String role_id) {
 
			System.out.println("未分配权限1="+role_id);
			int role_idd=Integer.parseInt(role_id);
			System.out.println("未分配权限2");
			List<Tb_menu> menuList=tbRoleBiz.findUnMenu(role_idd);
			System.out.println("未分配权限3");
			List<Map<String, Object>> mapList = menuToMap(menuList);
			System.out.println("未分配权限4");
			JSONArray jb=JSONArray.fromObject(mapList) ;
			System.out.println("未分配权限5");
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
 
	
		/**
		 * 添加权限菜单
		 * 
		 * @return
		 */ 
		@RequestMapping(value="/addmenu.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8") 
		public @ResponseBody String addMenu( Tb_menu rm,HttpServletRequest request,HttpServletResponse resp) {
			System.out.println("请选择要添加的权");
			String ret="请选择要添加的权限！";
			System.out.println("-----"+rm.toString()+"---"+ret+"----");
			System.out.println("rm.getsuperior="+rm.getSuperior());
			boolean flag = false;
			
			if (rm.getMids()==null||rm.getMids()=="") {
				return ret;
			}
			int r_id = Integer.valueOf(rm.getRole_id());
			System.out.println("r_id="+r_id);
			System.out.println("222="+rm.getMids());
			String[] menuids = rm.getMids().split(","); 
			System.out.println(menuids[0]);
			System.out.println(menuids[1]);
			System.out.println("menuids="+menuids.toString());
//
//			// 插入数据
			for (int i = 0; i < menuids.length; i++) { 
				int m_id = Integer.valueOf(menuids[i]);
				
				// 如果有子节点就不插入
				rm.setMenu_id(m_id);
				rm.setRole_id(r_id); 
				int count = tbMenuBiz.getCount(rm);
				System.out.println("count="+count);
				if (count > 0) {
					continue;
				}
				//用菜單id查找权限id  权限id和角色id同时添加一张表 
				int menu_idddd=rm.getMenu_id(); 
				int role_id=rm.getRole_id();
				System.out.println("role_id="+role_id);
				System.out.println("menu_idddd="+menu_idddd);
				
				
				
				Tb_power plist=tbMenuBiz.selectId(menu_idddd);  
				int power_id=plist.getPower_id();
				System.out.println("quanxid="+power_id);
				System.out.println("role_id="+role_id);
			 
				tb_role_power.setRole_id(role_id);
				tb_role_power.setPower_id(power_id);
				rett=tbMenuBiz.insert(tb_role_power);
				
				
// 
				System.out.println("插入数据菜单--" + m_id + "角色：" + r_id);
				
			}
			if(rett>0) {
				ret="添加成功";
			}else {
				ret="添加失败wangxing";
			}
			 
			return ret;
		}
		
		
		/**
		 * 移除权限菜单
		 * 
		 * @return
		 */
		
		@RequestMapping(value="/removemenu.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8") 
		public   String removeMenu(  Tb_menu rm,HttpServletRequest request,HttpServletResponse resp) {
	 	 	 
			System.out.println("移除 移除");
			String ret="请选择要移除的权限！";
			System.out.println("-----"+rm.toString()+"---"+ret+"----");
			
			boolean flag = false; 
			System.out.println("rm.getsuperior="+rm.getSuperior());
			
			if (rm.getMids()==null||rm.getMids()=="") {
				return ret;
			}
			int r_id = Integer.valueOf(rm.getRole_id());
			System.out.println("r_id="+r_id);
			System.out.println("222="+rm.getMids());
			String[] menuids = rm.getMids().split(",");
			System.out.println(menuids[0]);
			System.out.println(menuids[1]);
			System.out.println("menuids="+menuids.toString());
			// 插入数据
			for (int i = menuids.length - 1; i >= 0; i--) {
				int m_id = Integer.valueOf(menuids[i]);
				
				// 如果有子节点就不插入
				rm.setMenu_id(m_id);
				rm.setRole_id(r_id);
				int count = tbMenuBiz.getCount(rm);
				if (count > 0) {
					continue;
				}
				int menu_idddd=rm.getMenu_id(); 
				int role_id=rm.getRole_id();
				Tb_power plist=tbMenuBiz.selectId(menu_idddd);  
				int power_id=plist.getPower_id();
				tb_role_power.setRole_id(role_id);
				tb_role_power.setPower_id(power_id);
				rett=tbMenuBiz.del(tb_role_power);
				//没有子节点执行删除操作
//				flag = roleMenuBiz.del(rm);s
				System.out.println("插入数据菜单--" + m_id + "角色：" + r_id+"--flag="+flag);
				
				if(rett>0) {
					ret="移除成功";
				}else {
					ret="移除失败";
				}
			}
			return null;
		}
	 
		
		
}
