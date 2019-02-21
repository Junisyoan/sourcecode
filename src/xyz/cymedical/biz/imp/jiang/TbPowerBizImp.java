package xyz.cymedical.biz.imp.jiang;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jiang.TbPowerBiz;
import xyz.cymedical.entity.jiang.Tb_power;
import xyz.cymedical.mapper.jiang.TbPowerMapper;

@Service("tbPowerBiz")
public class TbPowerBizImp implements TbPowerBiz{
	
	@Resource
	TbPowerMapper tbPowerMapper;
	
	@Override
	public List<Tb_power> selectPower() {
		return tbPowerMapper.selectPower();
	}

	@Override
	public int deletePower(int power_id) {
		// TODO Auto-generated method stub
		return tbPowerMapper.deletePower(power_id);
	}

	@Override
	public int addPower(Tb_power tb_power) {
		// TODO Auto-generated method stub
		return tbPowerMapper.addPower(tb_power);
	}

	@Override
	public int upPower(Tb_power tbpower) {
		// TODO Auto-generated method stub
		return tbPowerMapper.upPower(tbpower);
	}

	@Override
	public List<Map<String, Object>> selectCompany(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tbPowerMapper.selectCompany(map);
	}

	@Override
	public Tb_power selectid(int menu_id) {
		// TODO Auto-generated method stub
		return tbPowerMapper.selectid(menu_id);
	}

	@Override
	public int delectMenuId(int power_id) {
		// TODO Auto-generated method stub
		return tbPowerMapper.delectMenuId(power_id);
	}

	@Override
	public int deletepower_role(int power_id) {
		// TODO Auto-generated method stub
		return tbPowerMapper.deletepower_role(power_id);
	}

	@Override
	public Tb_power selectpowerid(Tb_power tb_power) {
		// TODO Auto-generated method stub
		return tbPowerMapper.selectpowerid(tb_power);
	}

	 

}
