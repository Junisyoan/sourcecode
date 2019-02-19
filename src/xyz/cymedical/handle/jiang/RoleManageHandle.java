package xyz.cymedical.handle.jiang;

import java.io.IOException;
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
import xyz.cymedical.biz.jiang.TbRoleBiz;
import xyz.cymedical.biz.jiang.TbRoleDept;
import xyz.cymedical.biz.jiang.TbRolePower;
import xyz.cymedical.entity.jiang.Tb_dept;
import xyz.cymedical.entity.jiang.Tb_role;
import xyz.cymedical.entity.jiang.Tb_role_dept;
import xyz.cymedical.entity.jiang.Tb_role_power;
import xyz.cymedical.entity.jiang.Tb_user;

@Controller
@RequestMapping("/rolemanage")
public class RoleManageHandle {
	
	
	private  Tb_role role;
	private List<Tb_role_dept> roledeptlist;
	private List<Tb_role> roleall;
	@Resource
	private TbRoleBiz tbRoleBiz;
	
	@Resource
	private TbRoleDept tbRoleDept;
	@Resource
	private Tb_role_dept tb_role_dept;
	
	
	
	@Resource
	private TbRolePower tbRolePower;/*0biz*/
	
	@Resource
	private Tb_role_power tb_role_power;
	
	
	
	
	@RequestMapping(value = "/addrole.handle")
	public ModelAndView addRole(HttpServletRequest request, HttpServletResponse response, Tb_role tb_role) {

		ModelAndView mav = new ModelAndView();  
			String name=tb_role.getName();
			role=tbRoleBiz.selectName(name);
			if(role!=null) {
			System.out.println("账号已存在");
			try {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print("<script>alert('error')</script>");

				response.getWriter().print("<script type='text/javascript'>alert('账号已存在');window.history.back();</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			}else {
				
			
		 System.out.println("++++++="+name);
		int ret= tbRoleBiz.addRole(tb_role);
		
//		int dept_id=Integer.valueOf(dept_id);
//		tb_role_dept.setDept_id(dept_id);
		String state="在用";
		int dept_id=tb_role.getDept_id();
		int role_id=tb_role.getRole_id();
		/*
		 * 
		 * 用部门查出部门id
		 * 
		 * 
		 */
		
		tb_role_dept.setDept_id(dept_id);
		tb_role_dept.setRole_id(role_id);
		tb_role_dept.setState(state);
		
		System.out.println(tb_role_dept.toString());
		
		tbRoleDept.addroledept(tb_role_dept);
		 
		 System.out.println("ret="+ret);
		 if(ret==1) {
			 System.out.println("添加成功"); 
			 
		 }else {
			 System.out.println("添加失败");
		 }
			}
			
		 mav.setViewName("WEB-INF/view.jiang/rolemanage");
		  
		return mav;

	}
	@RequestMapping(value = "/select.handle")
	public ModelAndView selectRole(HttpServletRequest request, HttpServletResponse response, Tb_role addrole) {
		
		 
		ModelAndView mav = new ModelAndView();  
		roleall=tbRoleBiz.selectRole();
		
		request.setAttribute("roleall", roleall);
		
		mav.setViewName("WEB-INF/view.jiang/rolemanage");
		
		return mav;
		
	}

	
	// 删除 
		@RequestMapping(value = "/delectrole.handle", method = RequestMethod.POST)
		public ModelAndView delect(HttpServletRequest request, HttpServletResponse response, String updetename) {
			System.out.println("删除啊");
			String data = null;
			ModelAndView mav = new ModelAndView();  
			System.out.println("...=" + updetename);
			int role_id = Integer.valueOf(updetename);
			System.out.println("role_id="+role_id);
			/*删除角色之前要先查询 本id是否在角色权限表中存在 如存在 需要先删除角色权限表*/
			tb_role_power.setRole_id(role_id);
			String state="删除";
			tb_role_dept.setRole_id(role_id);
			tb_role_dept.setState(state);
			List<Tb_role_power> tbrolepower=tbRolePower.selectrprid(tb_role_power);
			System.out.println("tbrolepower="+tbrolepower);
			/*
			 * 
			 * 查询角色部门联合表是否存在
			 */
			
			int ret=0;
			
			 roledeptlist=tbRoleDept.selectroledeptroleid(role_id);
			
			
			if(tbrolepower.size()>0) {
				ret=tbRolePower.delectrprid(tb_role_power);
			}else {
				if(roledeptlist.size()==0) {
					
					ret=tbRoleBiz.delectrole(role_id);
				}else {
					 ret=tbRoleDept.deletetep(tb_role_dept);
				}
			}
			
			
			System.out.println("ret="+ret);
			
			try {
				response.getWriter().print("<script type='text/javascript'>alert('删除成功');window.history.back();</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(ret==1) {
				System.out.println("删除成功");
			}else {
				System.out.println("删除失败");
			}
			mav.setViewName("WEB-INF/view.jiang/rolemanage");
			 

			return mav;

		}
		
		//修改
				@RequestMapping(value = "/updectrole.handle", method = RequestMethod.POST)
				public ModelAndView updectrole(HttpServletRequest request, HttpServletResponse response, String nameed,String newname) {
					String data = null;
					ModelAndView mav = new ModelAndView();  
					System.out.println("...=" + nameed);
					System.out.println("...=" + newname);
					int role_id = Integer.valueOf(nameed);
					String name=newname;
					System.out.println("user_id"+role_id);
					int ret=tbRoleBiz.upRole(role_id, name);
					if(ret==1) {
						mav.setViewName("WEB-INF/view.jiang/rolemanage");
						
					}else {
						mav.setViewName("WEB-INF/view.jiang/err");
					}
					 return mav;

				}
				
				// 查
				@RequestMapping(value = "/selectCompany.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
				public @ResponseBody String selectCompany(Tb_role tb_role) { 
					Map<String, Object> map = new HashMap<String, Object>(); 
					map.put("tb_role", tb_role);
					 
					List<Map<String,Object>> companys = tbRoleBiz.selectCompany(map);
//					List<Tb_user> companys = companyBizsc.selectCompany(map);
					String str = JSONArray.fromObject(companys).toString();  
					return str;
				}
}
