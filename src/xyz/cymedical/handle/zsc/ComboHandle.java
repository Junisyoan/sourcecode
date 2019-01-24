package xyz.cymedical.handle.zsc;

import java.util.HashMap;
import java.util.List;

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

	//获取新增界面
	@RequestMapping("/addComboPage.handle")
	public ModelAndView addProjectPage(HttpServletRequest req) {
		List<Project> projects = projectBiz.findProjects();
		req.setAttribute("projects", projects);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.zsc/addCombo");
		return mav;
	}

	//新增项目
	@RequestMapping(value = "/addCombo.handle")
	public @ResponseBody String addProject(int[] idArray,Combo combo) {
		comboBiz.insertCombo(combo, idArray);
		return "ok";
	}

	//获取主页面
	@RequestMapping(value = "/combosVeiw.handle")
	public ModelAndView projectsVeiw(HttpServletRequest req) {
		return findCombos(req);
	}

	//删除项目
	@RequestMapping(value="/deleteCombo.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String deleteProject(HttpServletRequest req,int combo_id) {
		comboBiz.deleteCombo(combo_id);
		List<Combo> combos = comboBiz.findCombos();
		String str = JSONArray.fromObject(combos).toString();
		return str;
	}
	
	//条件查询
	@RequestMapping(value="selectCombo", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String selectProject(String name,String min,String max) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("name", name);
		map.put("min", min);
		map.put("max", max);
		List<Combo> combos = comboBiz.selectCombo(map);
		String str = JSONArray.fromObject(combos).toString();
		return str;
	}
	
	//获取更新界面
	@RequestMapping(value="/updatePage.handle")
	public ModelAndView updatePage(HttpServletRequest req,String combo_id) {
		List<Project> projects = projectBiz.findProjects();
		req.setAttribute("projects", projects);
		Combo combo = comboBiz.findCombo(combo_id);
		req.setAttribute("combo", combo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.zsc/updateCombo");
		return mav;
	}
	
	//更新数据
	@RequestMapping(value="/updateCombo.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String updateProject(int[] idArray,Combo combo){
		int rt = comboBiz.updateCombo(idArray, combo);
		if (rt > 0) {
			return "修改成功";
		} else {
			return "修改失败";
		}
	}
	
	// 查询细项列表并添加到session中
	private ModelAndView findCombos(HttpServletRequest req) {
		List<Combo> combos = comboBiz.findCombos();
		req.setAttribute("combos", combos);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.zsc/combosVeiw");
		return mav;
	}
}
