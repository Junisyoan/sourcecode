package xyz.cymedical.handle.zsc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import xyz.cymedical.biz.zsc.ComboBiz;
import xyz.cymedical.biz.zsc.ProjectBiz;
import xyz.cymedical.entity.xin.Combo;
import xyz.cymedical.entity.zsc.Project;

@Controller
@RequestMapping("/combo")
public class ComboHandle {

	@Resource
	ComboBiz comboBiz;
	@Resource
	ProjectBiz projectBiz;

	// 重名验证
	@RequestMapping(value = "/checkName.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String checkName(String name, String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("id", id);
		return comboBiz.checkName(map);
	}

	// 增
	@RequestMapping(value = "/addCombo.handle")
	public @ResponseBody String addProject(int[] idArray, Combo combo) {
		comboBiz.insertCombo(combo, idArray);
		return "ok";
	}

	// 删
	@RequestMapping(value = "/deleteCombo.handle")
	public ModelAndView deleteProject(HttpServletRequest req, int combo_id) {
		comboBiz.deleteCombo(combo_id);
		return findCombos(req);
	}

	// 改
	@RequestMapping(value = "/updateCombo.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String updateProject(int[] idArray, Combo combo) {
		return comboBiz.updateCombo(idArray, combo);

	}

	// 查
	@RequestMapping(value = "selectCombo", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String selectProject(String name, String min, String max) {
		System.out.println(name);
		System.out.println(min);
		System.out.println(max);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("min", min);
		map.put("max", max);
		List<Combo> combos = comboBiz.selectCombo(map);
		
		System.out.println(combos);
		String str = JSONArray.fromObject(combos).toString();
		return str;
	}

	// 显示
	@RequestMapping(value = "/combosVeiw.handle")
	public ModelAndView projectsVeiw(HttpServletRequest req) {
		return findCombos(req);
	}

	// 列表
	private ModelAndView findCombos(HttpServletRequest req) {
		List<Combo> combos = comboBiz.findCombos();
		req.setAttribute("combos", combos);
		List<Project> projects = projectBiz.findProjects();
		req.setAttribute("projects", projects);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.zsc/combosVeiw");
		return mav;
	}
}
