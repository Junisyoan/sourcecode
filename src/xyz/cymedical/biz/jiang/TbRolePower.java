package xyz.cymedical.biz.jiang;

import java.util.List;

import xyz.cymedical.entity.jiang.Tb_role_power;

public interface TbRolePower {
	public int  addmanage(Tb_role_power tb_role_power);
	
	public int delectrp(Tb_role_power tb_role_power);
	
	public List<Tb_role_power> selectrp(Tb_role_power tb_role_power);
	
	public List<Tb_role_power>  selectrprid(Tb_role_power tb_role_power);
	
	public int delectrprid(Tb_role_power tb_role_power);
	
	public Tb_role_power selecttowid(Tb_role_power tb_role_power);//**查找此表中是否存在两个id都有的字段
	
	public int addtowid(Tb_role_power tb_role_power);//不能存在 则添加
	
	

}
