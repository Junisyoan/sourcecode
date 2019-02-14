package xyz.cymedical.biz.zsc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.cymedical.aop.zsc.Log;
import xyz.cymedical.entity.yjn.Parameter;
import xyz.cymedical.entity.zsc.Project;
import xyz.cymedical.mapper.zsc.ProjectMapper;

@Transactional(rollbackFor=Exception.class)
@Service
public class ProjectBiz {

	@Resource
	ProjectMapper projectMapper;
	
	@Log(action = "添加项目")
	public String insertProject(Project project,int[] idArray) {

		Parameter param = project.getParam();
		int param_id = projectMapper.selectParamtId(param.getName());
		param.setParam_id(param_id);
		projectMapper.insertProject(project);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("project", project);
		map.put("idArray", idArray);
		
		int rt = projectMapper.insertDetPro(map);
		if (rt > 0) {
			return "ok";
		} else {
			return "Failure";
		}
	}

	@Log(action ="删除项目")
	public String deleteProject(int project_id) {
		int rt = projectMapper.deleteProject(project_id);
		System.out.println(rt);
		return "删除成功";
	};

	@Log(action ="修改项目")
	public String updateProject(int[] idArray, Project project) {
		Parameter param = project.getParam();
		int param_id = projectMapper.selectParamtId(param.getName());
		param.setParam_id(param_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("project", project);
		map.put("idArray", idArray);
		int rt = projectMapper.updateProject(map);
		
		if (rt > 0) {
			return "修改成功";
		} else {
			return "修改失败";
		}
	}

	public List<Project> findProjects(){
		return projectMapper.selectProject(null);
	}
	
	public List<Parameter> selectParamList(){
		return projectMapper.selectParamList();
	}
	
	public List<Project> selectProject(HashMap<String, Object> map){
		return projectMapper.selectProject(map);
	}
	
	public Project findProject(String project_id){
		return projectMapper.findProject(project_id);
	}
	
	public String checkName(Map<String, Object> map) {
		int rt = projectMapper.checkName(map);
		if (rt > 0) {
			return "该名称已存在";
		} else {
			return "该名称可使用";
		}
	};
}
