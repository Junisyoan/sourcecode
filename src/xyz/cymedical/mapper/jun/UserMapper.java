package xyz.cymedical.mapper.jun;

import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jun.User;

@Repository
public interface UserMapper {
	// ²éÑ¯ËùÓĞ
	public List<User> findAll();

}
