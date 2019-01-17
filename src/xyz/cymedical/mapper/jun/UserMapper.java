package xyz.cymedical.mapper.jun;

import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jun.User;

@Repository
public interface UserMapper
{
	//���
	public boolean addUser(User user);
	//��¼
	public User findUserByName(User user);
	
	public List<User> findUser(User user,String pageno);
	//��ѯ����
	public List<User> findAll();
	//����
	public List<User> findUsers(User user);
	//ɾ��
	public boolean delUser(int userid);
	//���á�����
	public boolean EnOrDisableUser(User user);
	//�޸�
	public boolean updateUser(User user);
	//����
	public User checkRepeat(String uname);
	
}
