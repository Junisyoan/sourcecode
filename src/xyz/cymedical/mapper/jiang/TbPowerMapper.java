package xyz.cymedical.mapper.jiang;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jiang.Tb_power;

@Repository
public interface TbPowerMapper {

	public List<Tb_power> selectPower();
	
	public int deletePower(int power_id);
	
	public int  addPower(Tb_power tb_power); 
 
	public int upPower(Tb_power tbpower);
	
	public List<Map<String,Object>> selectCompany(Map<String, Object> map);  
	
	public Tb_power selectid(int menu_id);/*删除菜单时 查询的权限id*/
	
	public int delectMenuId(int power_id);
	
	public int deletepower_role(int power_id);/*删除权限前 先删除权限角色表*/
	
//	public List<Tb_power> selectrowerid(); //**查询权限id 和名字  在添加权限时使用
	
	public Tb_power selectpowerid(Tb_power tb_power);//囘查

	
}
