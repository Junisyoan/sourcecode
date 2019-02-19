package xyz.cymedical.biz.jiang;

import java.util.List;
import java.util.Map;

import xyz.cymedical.entity.jiang.Tb_menu;
import xyz.cymedical.entity.jiang.Tb_role;

public interface TbRoleBiz {
	
	public List<Tb_role> selectRole();
	
	public Tb_role selectName(String name);
	
//	public int addRole(String name);//添加
	public int addRole(Tb_role tb_role);//添加
	
	public int delectrole(int role_id);
	
	public int upRole(int role_id,String name);
	
	public List<Map<String,Object>> selectCompany(Map<String, Object> map);  
	
	public List<Tb_menu> findMenu(int role_idd);  
	
	public List<Tb_menu> findUnMenu(int role_idd);  
	
	

}
