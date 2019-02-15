package xyz.cymedical.mapper.jiang;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jiang.Tb_menu;
import xyz.cymedical.entity.jiang.Tb_power;

@Repository
public interface TbMenuMapper {

	public List<Tb_menu> selectMenu();
	
	public int addMenuid(String name);
	
	public int addMenu(Tb_menu tb_menu);
	
	public int delete(int menu_id);
	
	public int upMenu(Tb_menu tb_menu);
	
	public List<Map<String,Object>> selectCompany(Map<String, Object> map); 
	
	public int getCount(Tb_menu rm);
	
	public List<Tb_power> selectId(int menu_idddd);
	
	public int insert(Tb_menu tb_menu);
}
