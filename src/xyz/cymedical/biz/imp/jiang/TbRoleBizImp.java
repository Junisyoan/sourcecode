package xyz.cymedical.biz.imp.jiang;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jiang.TbRoleBiz;
import xyz.cymedical.entity.jiang.Tb_menu;
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


//	@Override
//	public int addRole(String name) {
//		return tbRoleMapper.addRole(name);
//	}


	@Override
	public Tb_role selectName(String name) {
		return tbRoleMapper.selectName(name);
//		return null;
	}


	@Override
	public int delectrole(int role_id) {
		return tbRoleMapper.delectrole(role_id);
	}


	@Override
	public int upRole(int role_id, String name) {
		// TODO Auto-generated method stub
		return tbRoleMapper.upRole(role_id, name);
	}


	@Override
	public List<Map<String, Object>> selectCompany(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tbRoleMapper.selectCompany(map);
	}


	@Override
	public List<Tb_menu>  findMenu(int role_idd) {
		// TODO Auto-generated method stub
		return tbRoleMapper.findMenu(role_idd);
	}


	@Override
	public List<Tb_menu> findUnMenu(int role_idd) {
		// TODO Auto-generated method stub
		return tbRoleMapper.findUnMenu(role_idd);
	}


	@Override
	public int addRole(Tb_role tb_role) {
		// TODO Auto-generated method stub
		return tbRoleMapper.addRole(tb_role);
	}


	@Override
	public List<Map<String, Object>> selectrole(String name) {
		// TODO Auto-generated method stub
		return tbRoleMapper.selectrole(name);
	}


	@Override
	public List<Map<String, Object>>  selectroleall() {
		// TODO Auto-generated method stub
		return tbRoleMapper.selectroleall();
	}


 

	 


	 

}
