package xyz.cymedical.mapper.jun;

import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jun.User;

@Repository
public interface UserMapper
{
	//添加
	public boolean addUser(User user);
	//登录
	public User findUserByName(User user);
	
	public List<User> findUser(User user,String pageno);
	//查询所有
	public List<User> findAll();
	//条件
	public List<User> findUsers(User user);
	//删除
	public boolean delUser(int userid);
	//启用、禁用
	public boolean EnOrDisableUser(User user);
	//修改
	public boolean updateUser(User user);
	//重名
	public User checkRepeat(String uname);
	
}
