package xyz.cymedical.biz.jiang;

import java.util.List;
 
import xyz.cymedical.entity.jiang.Tb_power;
import xyz.cymedical.entity.jiang.Tb_user;

public interface TbPowerBiz {
	
	public List<Tb_power> selectPower();
	
	public int deletePower(int power_id);
	
	public int  addPower(Tb_power tb_power); 

}
