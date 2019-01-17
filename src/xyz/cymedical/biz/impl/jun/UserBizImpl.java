package xyz.cymedical.biz.impl.jun;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import xyz.cymedical.biz.inter.jun.UserBiz;
import xyz.cymedical.entity.jun.User;
import xyz.cymedical.mapper.jun.UserMapper;

@Service("UserBiz")
public class UserBizImpl extends BaseImpl implements UserBiz{

	@Resource
	private UserMapper userMapper;
	
	public UserBizImpl() {
		logger=Logger.getLogger(UserBizImpl.class);
	}

	@Override
	public User queryByLogin(User user) {
		return userMapper.queryByLogin(user);
	}

	@Override
	public boolean queryAccount(String account) {
		if (userMapper.queryAccount(account)!=null) {
			isExist=true;
		} else {
			isExist=false;
		}
		return isExist;
	}

	@Override
	public boolean addUser(User user) {
		return userMapper.addUser(user);
	}

	@Override
	public List<User> queryUserList(int pageNum) {
		firstRecord = (pageNum-1)*10;
		lastRecord = pageNum*10+1;
		return userMapper.queryUserList(firstRecord,lastRecord);
	}

	@Override
	public int queryUserCount() {
		return userMapper.queryUserCount();
	}

	@Override
	public boolean updateUser(User user) {
		return userMapper.updateUser(user);
	}

	@Override
	public boolean delUser(int user_id) {
		return userMapper.delUser(user_id);
	}
	
	
}
