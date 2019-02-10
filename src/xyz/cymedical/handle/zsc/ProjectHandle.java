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
import xyz.cymedical.entity.yjn.Parameter;
import xyz.cymedical.entity.zsc.Detail;
import xyz.cymedical.entity.zsc.Project;

@Controller
@RequestMapping("/project")
public class ProjectHandle {

	@Resource
	ProjectBiz projectBiz;
	@Resource
	DetailBiz detailBiz;

	//重名验证
	@RequestMapping(value = "/checkName.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String checkName(String name, String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("id", id);
		return projectBiz.checkName(map);
	}

	// 增
	@RequestMapping(value = "/addProject.handle")
	public @ResponseBody String addProject(int[] idArray, Project project) {
		return projectBiz.insertProject(project, idArray);
	}

	// 删
	@RequestMapping(value = "/deleteProject.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String deleteProject(HttpServletRequest req, int project_id) {
		return projectBiz.deleteProject(project_id);
	}

	// 改
	@RequestMapping(value = "/updateProject.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String updateProject(int[] idArray, Project project) {
		return projectBiz.updateProject(idArray, project);
	}

	// 查
	@RequestMapping(value = "selectProject", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String selectProject(String name, String min, String max, String deptname) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("min", min);
		map.put("max", max);
		map.put("deptname", deptname);
		
		List<Project> projects = projectBiz.selectProject(map);
		String str = JSONArray.fromObject(projects).toString();
		return str;
	}

	// 显示
	@RequestMapping(value = "/projectsVeiw.handle")
	public ModelAndView projectsVeiw(HttpServletRequest req) {
		return findProjects(req);
	}

	// 列表
	private ModelAndView findProjects(HttpServletRequest req) {
		List<Project> projects = projectBiz.findProjects();
		List<Parameter> params = projectBiz.selectParamList();
		List<Detail> details = detailBiz.findDetails();
		req.setAttribute("details", details);
		req.setAttribute("projects", projects);
		req.setAttribute("params", params);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.zsc/projectsVeiw");
		return mav;
	}
}
