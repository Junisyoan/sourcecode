package xyz.cymedical.biz.imp.jiang;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jiang.TbUserBiz;
import xyz.cymedical.entity.jiang.Tb_user;
import xyz.cymedical.mapper.jiang.TbUserMapper;

@Service("tbUserBiz")
public class TbUserBizImp implements TbUserBiz{

	@Resource
	TbUserMapper tbUserMapper;
	
	@Override
	public List<Tb_user> findUser(Tb_user user) {
		return (List<Tb_user>) tbUserMapper.findUser(user);
	}
	@Override//无条件查询所有
	public List<Tb_user> findAll() {
		return tbUserMapper.findAll();
	}
//	@Override//无条件查询所有
	public List<Map<String,Object>> findAll2() {
		return tbUserMapper.findAll2();
	}
 
	@Override//添加
	public int addUser(Tb_user user) {
		return  tbUserMapper.addUser(user); 
	}
	@Override//删除
	public int deleteUser(int user_id) {
		return tbUserMapper.deleteUser(user_id);
	}
	@Override
	public int upState(int user_id,String state) {
		return tbUserMapper.upState(user_id, state);
	}
	@Override//修改人员信息
	public int upUser(Tb_user user) {
		return tbUserMapper.upUser(user);
	}
	@Override//模糊查询
	public List<Map<String,Object>> selUser(String depts, String users,  String phones ) {
		return tbUserMapper.selUser(depts, users, phones);
	}
	@Override
	public List<Tb_user> findUserRole(Tb_user user) {
		return tbUserMapper.findUserRole(user);
	}
	public  List<Map<String,Object>> selectCompany(Map<String, Object> map) {
			return tbUserMapper.selectCompany(map);
		 
	}
	@Override
	public String checkPwd(Map<String, Object> map) {
		int rt = tbUserMapper.checkPwd(map);
		if (rt > 0) {
			return "ok";
		} else {
			return "error";
		}
	}
	@Override
	public String changePwd(Map<String, Object> map) {
		int rt = tbUserMapper.changePwd(map);
		if (rt > 0) {
			return "密码修改成功";
		} else {
			return "密码修改失败";
		}
	}
	@Override 
	public Tb_user findthree(Tb_user user) {
		// TODO Auto-generated method stub
		return tbUserMapper.findthree(user);
	}
	@Override 	
	public Tb_user queryUser(String id, String pwd) {
		return tbUserMapper.queryUser(id, pwd); 
	}
}
