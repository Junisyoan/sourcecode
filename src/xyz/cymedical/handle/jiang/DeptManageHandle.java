package xyz.cymedical.handle.jiang;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	//**添加科室//*	
	@RequestMapping(value = "/adddept.handle")
	public ModelAndView addPower(HttpServletRequest request, HttpServletResponse response, Tb_dept tb_dept) {
		ModelAndView mav = new ModelAndView();  
		 
//		int ret=TbPowerBiz.addPower(tb_power);
		System.out.println(tb_dept.getDept_id());
		System.out.println(tb_dept.getName());
		int ret=tbDeptBiz.addDept(tb_dept);
		
		
		if(ret==1) {
			
			mav.setViewName("WEB-INF/view.jiang/deptmanage");
		}
		  
		return mav;

	}
	
	
	//修改第一步
	@RequestMapping(value = "/updete1.handle", method = RequestMethod.POST)
	public ModelAndView updete2(HttpServletRequest request, HttpServletResponse response, String updetename) {
		ModelAndView mav = new ModelAndView();

		System.out.println("修改人员信息=" + updetename);
		request.setAttribute("updetename", updetename);
		mav.setViewName("WEB-INF/view.jiang/updetedept");
		return mav;

	}
	
	//修改第二步
	 
			@RequestMapping(value = "/updetepower2.handle", method = RequestMethod.POST)
			public ModelAndView updeteuser(HttpServletRequest request, HttpServletResponse response, Tb_dept tb_dept) {
				ModelAndView mav = new ModelAndView();


				int  ret=tbDeptBiz.upDept(tb_dept);
				
				 	if(ret==1) {
				 		
				 		mav.setViewName("WEB-INF/view.jiang/deptmanage");
				 	}

				return mav;

			}
			
			//删除
			

			@RequestMapping(value = "/delect.handle",method = RequestMethod.POST)
			public @ResponseBody String deletePower(HttpServletRequest request, HttpServletResponse response, String delectname) {
 				
				System.out.println("delectname="+delectname);
				String data = null;
				int dept_id=Integer.valueOf(delectname);
				int ret=tbDeptBiz.delectDept(dept_id);
				
				if(ret==1) { 
					data = "00";
				}
				  
				return data;
	 	
			}
}
