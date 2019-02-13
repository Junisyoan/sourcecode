package xyz.cymedical.biz.jiang;

import java.util.List;
import java.util.Map;

import xyz.cymedical.entity.jiang.Tb_power;
import xyz.cymedical.entity.jiang.Tb_user;

public interface TbPowerBiz {
	
	public List<Tb_power> selectPower();
	
	public int deletePower(int power_id);
	
	public int  addPower(Tb_power tb_power); 
	
	public int upPower(Tb_power tbpower);
	
	public List<Map<String,Object>> selectCompany(Map<String, Object> map);  

}
