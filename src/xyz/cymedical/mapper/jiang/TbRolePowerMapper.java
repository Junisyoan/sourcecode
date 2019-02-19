package xyz.cymedical.mapper.jiang;
 

import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jiang.Tb_role_power;
 

@Repository
public interface TbRolePowerMapper {

	public int  addmanage(Tb_role_power tb_role_power);
	
	public int delectrp(Tb_role_power tb_role_power);/*删除权限前 先删除权限角色表关联*/
	
	public List<Tb_role_power> selectrp(Tb_role_power tb_role_power);/*删除前先查询是否存在*/
	
	public List<Tb_role_power>  selectrprid(Tb_role_power tb_role_power);/*删除角色前 先查询联表中是否存在*/
	
	public int delectrprid(Tb_role_power tb_role_power);
	
	
}
