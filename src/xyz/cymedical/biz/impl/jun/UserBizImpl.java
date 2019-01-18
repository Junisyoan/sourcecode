package xyz.cymedical.biz.impl.jun;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jun.UserBiz;
import xyz.cymedical.entity.jun.User;
import xyz.cymedical.mapper.jun.UserMapper;

@Service("userBiz")
public class UserBizImpl implements UserBiz
{
	
//	private SqlSession conn = MyBatisTool.getSession();
//	private UserMapper userMapper = conn.getMapper(UserMapper.class);
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public List<User> findAll()
	{
		// TODO Auto-generated method stub
		
		return userMapper.findAll();
	}


	
}
