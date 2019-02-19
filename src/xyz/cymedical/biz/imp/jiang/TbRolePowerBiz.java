package xyz.cymedical.biz.imp.jiang;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jiang.TbRolePower;
import xyz.cymedical.entity.jiang.Tb_role_power;
import xyz.cymedical.mapper.jiang.TbRolePowerMapper;

@Service("tbRolePower")
public class TbRolePowerBiz implements TbRolePower{

	@Resource
	TbRolePowerMapper tbRolePowerMapper;

	@Override
	public int addmanage(Tb_role_power tb_role_power) {
		// TODO Auto-generated method stub
		return tbRolePowerMapper.addmanage(tb_role_power);
	}

	@Override
	public int delectrp(Tb_role_power tb_role_power) { 
		return tbRolePowerMapper.delectrp(tb_role_power);
	}

	@Override
	public List<Tb_role_power> selectrp(Tb_role_power tb_role_power) {
		// TODO Auto-generated method stub
		return tbRolePowerMapper.selectrp(tb_role_power);
	}

	@Override
	public List<Tb_role_power> selectrprid(Tb_role_power tb_role_power) {
		// TODO Auto-generated method stub
		return tbRolePowerMapper.selectrprid(tb_role_power);
	}

	@Override
	public int delectrprid(Tb_role_power tb_role_power) {
		// TODO Auto-generated method stub
		return tbRolePowerMapper.delectrprid(tb_role_power);
	}

 
	 
	
	 

 

}
