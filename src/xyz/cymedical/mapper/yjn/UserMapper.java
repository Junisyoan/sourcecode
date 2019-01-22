package xyz.cymedical.mapper.yjn;

import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jiang.Tb_user;
import xyz.cymedical.entity.yjn.Log;
@Repository
public interface UserMapper {
	public List<Tb_user> userLogin(Tb_user user);
}
