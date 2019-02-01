package xyz.cymedical.handle.zsc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import xyz.cymedical.biz.zsc.DetailBiz;
import xyz.cymedical.biz.zsc.ProjectBiz;
import xyz.cymedical.entity.zsc.Detail;
import xyz.cymedical.entity.zsc.Project;

@Controller
@RequestMapping("/project")
public class ProjectHandle {

	@Resource
	ProjectBiz projectBiz;
	@Resource
	DetailBiz detailBiz;

	//获取新增界面
	@RequestMapping("/addProjectPage.handle")
	public ModelAndView addProjectPage(HttpServletRequest req) {
		List<Detail> details = detailBiz.findDetails();
		req.setAttribute("details", details);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.zsc/addProject");
		return mav;
	}

	@RequestMapping(value="/checkName.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String checkName(String name,String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("id", id);
		return projectBiz.checkName(map);
	}
	
	//新增项目
	@RequestMapping(value = "/addProject.handle")
	public @ResponseBody String addProject(int[] idArray, Project project) {
		projectBiz.insertProject(project, idArray);
		return "ok";
	}

	//获取主页面
	@RequestMapping(value = "/projectsVeiw.handle")
	public ModelAndView projectsVeiw(HttpServletRequest req) {
		return findProjects(req);
	}

	//删除项目
	@RequestMapping(value="/deleteProject.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String deleteProject(HttpServletRequest req,int project_id) {
		projectBiz.deleteProject(project_id);
		List<Project> projects = projectBiz.findProjects();
		String str = JSONArray.fromObject(projects).toString();
		return str;
	}
	
	//条件查询
	@RequestMapping(value="selectProject", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String selectProject(String name,String min,String max,String deptname) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("name", name);
		map.put("min", min);
		map.put("max", max);
		map.put("deptname", deptname);
		List<Project> projects = projectBiz.selectProject(map);
		String str = JSONArray.fromObject(projects).toString();
		return str;
	}
	
	//获取更新界面
	@RequestMapping(value="/updatePage.handle")
	public ModelAndView updatePage(HttpServletRequest req,String project_id) {
		List<Detail> details = detailBiz.findDetails();
		req.setAttribute("details", details);
		Project project = projectBiz.findProject(project_id);
		req.setAttribute("project", project);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.zsc/updateProject");
		return mav;
	}
	
	//更新数据
	@RequestMapping(value="/updateProject.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String updateProject(int[] idArray, Project project){
		int rt = projectBiz.updateProject(idArray,project);
		if (rt > 0) {
			return "修改成功";
		} else {
			return "修改失败";
		}
	}
	
	// 查询细项列表并添加到session中
	private ModelAndView findProjects(HttpServletRequest req) {
		List<Project> projects = projectBiz.findProjects();
		req.setAttribute("projects", projects);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.zsc/projectsVeiw");
		return mav;
	}
}
