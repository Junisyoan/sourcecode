package xyz.cymedical.mapper.jiang;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jiang.Tb_menu;
import xyz.cymedical.entity.jiang.Tb_role;

@Repository 
public interface TbRoleMapper {

	public List<Tb_role> selectRole();
	
	public Tb_role selectName(String name);
	
//	public int addRole(String name);
	public int addRole(Tb_role tb_role);//添加
	
	public int delectrole(int role_id);
	
	public int upRole(int role_id,String name);
	
	public List<Map<String,Object>> selectCompany(Map<String, Object> map);  
	
	public List<Tb_menu> findMenu(int role_idd);
	
	public List<Tb_menu> findUnMenu(@Param("rid")int rid);  
	
//	public  List<Tb_role> selectrole(String name);/*已知部门查角色*/
	public  List<Map<String,Object>> selectrole(String name);/*已知部门查角色*/
}
