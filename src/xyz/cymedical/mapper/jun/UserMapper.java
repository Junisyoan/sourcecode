package xyz.cymedical.mapper.jun;

import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.cymedical.bean.jun.User;

@Repository
public interface UserMapper {
	// ��ѯ����
	public List<User> findAll();

}
