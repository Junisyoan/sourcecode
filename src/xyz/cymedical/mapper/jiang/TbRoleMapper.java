package xyz.cymedical.mapper.jiang;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jiang.Tb_role;

@Repository 
public interface TbRoleMapper {

	public List<Tb_role> selectRole();
	
	public Tb_role selectName(String name);
	
	public int addRole(String name);
	
	public int delectrole(int role_id);
	
	public int upRole(int role_id,String name);
	
	public List<Map<String,Object>> selectCompany(Map<String, Object> map);  
}
