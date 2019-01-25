package xyz.cymedical.handle.jiang;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.jiang.TbRoleBiz;
import xyz.cymedical.entity.jiang.Tb_role;
import xyz.cymedical.entity.jiang.Tb_user;

@Controller
@RequestMapping("/rolemanage")
public class RoleManageHandle {
	
	
	private  Tb_role role;
	private List<Tb_role> roleall;
	@Resource
	private TbRoleBiz tbRoleBiz;
	
	
	
	
	@RequestMapping(value = "/addrole.handle")
	public ModelAndView addRole(HttpServletRequest request, HttpServletResponse response, String  name) {

		ModelAndView mav = new ModelAndView();  
		
			role=tbRoleBiz.selectName(name);
			if(role!=null) {
			System.out.println("账号已存在");
			try {
				response.getWriter().print("<script type='text/javascript'>alert('账号已存在');window.history.back();</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}else {
				
			
		 System.out.println("++++++="+name);
		int ret= tbRoleBiz.addRole(name);
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

}
