package xyz.cymedical.mapper.jiang;

import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jiang.Tb_role;

@Repository 
public interface TbRoleMapper {

	public List<Tb_role> selectRole();
	
	public int addRole(String name);
}
