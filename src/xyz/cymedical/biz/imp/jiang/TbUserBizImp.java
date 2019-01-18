package xyz.cymedical.biz.imp.jiang;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.bean.jiang.Tb_user;
import xyz.cymedical.biz.jiang.TbUserBiz;
import xyz.cymedical.mapper.jiang.TbUserMapper;
@Service("tbUserBiz")
public class TbUserBizImp implements TbUserBiz{

	
	@Resource
	TbUserMapper tbUserMapper;
	@Override
	public List<Tb_user> findUser(Tb_user user) {
		return (List<Tb_user>) tbUserMapper.findUser(user);
	}

}
