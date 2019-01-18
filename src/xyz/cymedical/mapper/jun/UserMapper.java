package xyz.cymedical.mapper.jun;

import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jun.User;

@Repository
public interface UserMapper {
	// ��ѯ����
	public List<User> findAll();

}
