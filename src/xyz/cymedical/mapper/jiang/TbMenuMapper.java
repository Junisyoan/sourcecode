package xyz.cymedical.mapper.jiang;

import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jiang.Tb_menu;

@Repository
public interface TbMenuMapper {

	public List<Tb_menu> selectMenu();
	
	public int addMenuid(String name);
}
