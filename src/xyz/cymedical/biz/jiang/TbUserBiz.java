package xyz.cymedical.biz.jiang;

import java.util.List;

import xyz.cymedical.bean.jiang.Tb_user;
 
  
public interface TbUserBiz {
	
	public List<Tb_user>  findUser(Tb_user user);

}
