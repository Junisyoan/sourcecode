package xyz.cymedical.handle.jiang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import xyz.cymedical.biz.jiang.TbDeptBiz;
import xyz.cymedical.biz.jiang.TbRoleDept;
import xyz.cymedical.entity.jiang.Tb_dept;
import xyz.cymedical.entity.jiang.Tb_power;
import xyz.cymedical.entity.jiang.Tb_role_dept;
import xyz.cymedical.entity.jiang.Tb_user;

@Controller
@RequestMapping("/deptmanage")
public class DeptManageHandle {
 
	 
	@Resource
	private TbDeptBiz tbDeptBiz;
	
	@Resource
	private TbRoleDept tbRoleDept;
	
	private List<Tb_role_dept> roledeptlist;
	@Resource
	private Tb_role_dept tb_role_dept;
	
//	private List<Tb_dept> maplist;
	
	private List<Map<String, Object>> maplist;
	
	@RequestMapping(value = "/select.handle")
	public ModelAndView findAll(HttpServletRequest request, HttpServletResponse response, Tb_dept tbdept) {
		
		ModelAndView mav = new ModelAndView(); 
		System.out.println("部门管理");
//		maplist=tbDeptBiz.selectDept();
		String sta="在用";
		maplist=tbDeptBiz.select(sta);
		
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
		String sta="在用";
		/*联表添加*/
		
		/*
		 * 
		 * 科室添加成功  科室无人 不能显示  快去添加人员吧
		 * 
		 * 
		 * 
		 * 
		 */
		
		
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
				int ret=0;
				int dept_id=Integer.valueOf(delectname);
				/**
				 * 删除部门前 先查询是否存在角色部门表
				 *  如果存在 要先删除角色部门关联表
				 * 
				 * 主键 外键关联过多  使用状态 逻辑删除
				 */
				String state="删除";
				tb_role_dept.setState(state);
				tb_role_dept.setDept_id(dept_id);
				List<Tb_role_dept> tbroledeptlist= 	tbRoleDept.selectroledeptid(dept_id);
				
				if(tbroledeptlist.size()>0) {
					 ret=tbRoleDept.deletelogic(tb_role_dept); 
				}else { 
					  ret=tbDeptBiz.delectDept(dept_id);
				}
				if(ret==1) { 
					data = "00";
				} 
				return data; 
	 	
			}
			
			// 查
			@RequestMapping(value = "/selectCompany.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
			public @ResponseBody String selectCompany(Tb_dept tb_dept) { 
				Map<String, Object> map = new HashMap<String, Object>(); 
				map.put("tb_dept", tb_dept);
				 
				List<Map<String,Object>> companys = tbDeptBiz.selectCompany(map);
//				List<Tb_user> companys = companyBizsc.selectCompany(map);
				String str = JSONArray.fromObject(companys).toString();  
				return str;
			}

}
