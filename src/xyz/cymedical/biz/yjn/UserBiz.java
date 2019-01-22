package xyz.cymedical.biz.yjn;

import java.util.List;

import xyz.cymedical.entity.jiang.Tb_user;

public interface UserBiz {
	public List<Tb_user> userLogin(Tb_user user);
}
