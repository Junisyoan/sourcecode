package xyz.cymedical.biz.imp.jiang;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jiang.TbRoleBiz;
import xyz.cymedical.entity.jiang.Tb_role;
import xyz.cymedical.mapper.jiang.TbRoleMapper;

@Service("tbRoleBiz")
public class TbRoleBizImp implements TbRoleBiz{
	
	 

		@Resource
		TbRoleMapper tbRoleMapper;
		
		
	@Override
	public List<Tb_role> selectRole() {
		return tbRoleMapper.selectRole();
	}


	@Override
	public int addRole(String name) {
		return tbRoleMapper.addRole(name);
	}


	 

}
