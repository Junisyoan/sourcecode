package xyz.cymedical.mapper.zsc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.yjn.Parameter;
import xyz.cymedical.entity.zsc.Project;

@Repository
public interface ProjectMapper {

	public int selectParamtId(String param_name);
	
	public int insertProject(Project project);
	
	public int insertDetPro(Map<String, Object> map);
	
	public int deleteProject(int project_id);
	
	public List<Project> selectProject(HashMap<String, Object> map);
	
	public List<Parameter> selectParamList();
	
	public Project findProject(String project_id);
	
	public int updateProject(Map<String, Object> map);

	public int checkName(Map<String, Object> map);
}
