package xyz.cymedical.biz.jiang;

import java.util.List;

import xyz.cymedical.entity.jiang.Tb_role_dept;
 

public interface TbRoleDept {
	
	public List<Tb_role_dept>  findroledeptid(int role_dept_id);
	
	public List<Tb_role_dept>  selectroledeptid(int dept_id);
	
	public int deleteroledept(int dept_id);/*物理删除 不够  改成逻辑删除*/
	
	public  int deletelogic(Tb_role_dept tb_role_dept);/*逻辑删除*/
	
	public int addroledept(Tb_role_dept tb_role_dept);/*添加角色部门联合表*/
	
	

}
