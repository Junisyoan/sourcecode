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
	public  List<Map<String,Object>> selectCompany(Map<String, Object> map) {
		// TODO Auto-generated method stub 
			return tbUserMapper.selectCompany(map);
		 
	}
}
