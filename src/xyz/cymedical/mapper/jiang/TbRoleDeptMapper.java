package xyz.cymedical.mapper.jiang;

import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jiang.Tb_role_dept;
import xyz.cymedical.entity.jiang.Tb_user;

@Repository
public interface TbRoleDeptMapper {

	public List<Tb_role_dept>  findroledeptid(int role_dept_id);
	
 
}