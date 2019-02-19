package xyz.cymedical.mapper.jiang;

import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jiang.Tb_role_dept;
import xyz.cymedical.entity.jiang.Tb_role_power;
import xyz.cymedical.entity.jiang.Tb_user;

@Repository
public interface TbRoleDeptMapper {

	public List<Tb_role_dept>  findroledeptid(int role_dept_id);
	
	public List<Tb_role_dept>  selectroledeptid(int dept_id);
	
	public int deleteroledept(int dept_id);/*删除联表id*/
	
	public  int deletelogic(Tb_role_dept tb_role_dept);/*逻辑删除*/
	
	public int addroledept(Tb_role_dept tb_role_dept);/*添加角色部门联合表*/
	
	public int deletetep(Tb_role_dept tb_role_dept);/*逻辑删除*/
	
	public List<Tb_role_dept>  selectroledeptroleid(int role_id);/*删除前 先查一下角色部门id*/
 
}
