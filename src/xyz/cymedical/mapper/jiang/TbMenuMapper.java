package xyz.cymedical.mapper.jiang;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jiang.Tb_menu;

@Repository
public interface TbMenuMapper {

	public List<Tb_menu> selectMenu();
	
	public int addMenuid(String name);
	
	public int delete(int menu_id);
	
	public int upMenu(Tb_menu tb_menu);
	
	public List<Map<String,Object>> selectCompany(Map<String, Object> map); 
}
