package xyz.cymedical.mapper.jiang;

import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.cymedical.bean.jiang.Tb_user;

@Repository
public interface TbUserMapper {

	public List<Tb_user>  findUser(Tb_user user);
}
