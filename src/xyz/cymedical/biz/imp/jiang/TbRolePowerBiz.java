package xyz.cymedical.biz.imp.jiang;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jiang.TbRolePower;
import xyz.cymedical.mapper.jiang.TbRolePowerMapper;

@Service("tbRolePower")
public class TbRolePowerBiz implements TbRolePower{

	@Resource
	TbRolePowerMapper tbRolePowerMapper;

	@Override
	public int addmanage(int role_id,int power_id) {
		// TODO Auto-generated method stub
		return tbRolePowerMapper.addmanage(role_id, power_id);
	}
	
	 

 

}
