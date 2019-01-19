package xyz.cymedical.biz.imp.jiang;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jiang.TbUserBiz;
import xyz.cymedical.entity.jiang.Tb_user;
import xyz.cymedical.mapper.jiang.TbUserMapper;

@Service("userBiz")
public class TbUserBizImp implements TbUserBiz{

	@Resource
	TbUserMapper tbUserMapper;
	
	@Override
	public List<Tb_user> findUser(Tb_user user) {
		return (List<Tb_user>) tbUserMapper.findUser(user);
	}
	@Override
	public List<Tb_user> findAll() {
		// TODO Auto-generated method stub
		return tbUserMapper.findAll();
	}

}
