package xyz.cymedical.handle.jiang;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.jiang.TbDeptBiz;
import xyz.cymedical.entity.jiang.Tb_dept;
import xyz.cymedical.entity.jiang.Tb_power;

@Controller
@RequestMapping("/deptmanage")
public class DeptManageHandle {
 
	 
	@Resource
	private TbDeptBiz tbDeptBiz;
	
	private List<Tb_dept> maplist;
	
	@RequestMapping(value = "/select.handle")
	public ModelAndView findAll(HttpServletRequest request, HttpServletResponse response, Tb_dept tbdept) {
		
		ModelAndView mav = new ModelAndView(); 
		System.out.println("部门管理");
		maplist=tbDeptBiz.selectDept();
		request.setAttribute("maplist", maplist);
		
		mav.setViewName("WEB-INF/view.jiang/deptmanage");
		return mav;
 
		 
	}
}
