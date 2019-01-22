package xyz.cymedical.biz.imp.yjn;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.yjn.UserBiz;
import xyz.cymedical.entity.jiang.Tb_user;
import xyz.cymedical.mapper.yjn.UserMapper;

@Service("userBiz")
public class UserBizImpl implements UserBiz{
	@Resource
	private UserMapper usermapper;

	@Override
	public List<Tb_user> userLogin(Tb_user user) {
		// TODO Auto-generated method stub
		return usermapper.userLogin(user);
	}
	
		
	
	
}
