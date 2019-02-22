package xyz.cymedical.biz.jiang;

import java.util.List;

import xyz.cymedical.entity.jiang.Tb_role_dept;
import xyz.cymedical.entity.jiang.Tb_role_power;
 

public interface TbRoleDept {
	
//	public boolean updateUser_id(String role_dept_id,String user_id);
	//************************************************
	public List<Tb_role_dept>  findroledeptid(int role_dept_id);
	
	public List<Tb_role_dept>  selectroledeptid(int dept_id);
	
	public int deleteroledept(int dept_id);/*物理删除 不够  改成逻辑删除*/
	
	public  int deletelogic(Tb_role_dept tb_role_dept);/*逻辑删除*/
	
	public int addroledept(Tb_role_dept tb_role_dept);/*添加角色部门联合表*/
	
	public int deletetep(Tb_role_dept tb_role_dept);/*逻辑删除*/
	
	public List<Tb_role_dept>  selectroledeptroleid(int role_id);/*删除前 先查一下角色部门id*/
	
 

}
