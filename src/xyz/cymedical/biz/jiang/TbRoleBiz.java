package xyz.cymedical.biz.jiang;

import java.util.List;

import xyz.cymedical.entity.jiang.Tb_role;

public interface TbRoleBiz {
	
	public List<Tb_role> selectRole();
	
	
	
	public int addRole(String name);//添加

}
