package xyz.cymedical.biz.zsc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.entity.yjn.Parameter;
import xyz.cymedical.entity.zsc.Project;
import xyz.cymedical.mapper.zsc.ProjectMapper;

@Service
public class ProjectBiz {

	@Resource
	ProjectMapper projectMapper;
	
	public int insertProject(Project project,int[] idArray) {

		Parameter param = project.getParam();
		int param_id = projectMapper.selectParamtId(param.getName());
		param.setParam_id(param_id);
		projectMapper.insertProject(project);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("project", project);
		map.put("idArray", idArray);
		
		int rt = projectMapper.insertDetPro(map);
		return rt;
	}
	
	public List<Project> findProjects(){
		return projectMapper.selectProject(null);
	}
	
	public int deleteProject(int project_id) {
		return projectMapper.deleteProject(project_id);
	};
	
	public List<Project> selectProject(HashMap<String, Object> map){
		return projectMapper.selectProject(map);
	}
	
	public Project findProject(String project_id){
		return projectMapper.findProject(project_id);
	}
	
	public int updateProject(int[] idArray, Project project) {
		Parameter param = project.getParam();
		int param_id = projectMapper.selectParamtId(param.getName());
		param.setParam_id(param_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("project", project);
		map.put("idArray", idArray);
		return projectMapper.updateProject(map);
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
