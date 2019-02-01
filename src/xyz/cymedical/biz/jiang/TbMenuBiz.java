package xyz.cymedical.biz.jiang;

import java.util.List;

import xyz.cymedical.entity.jiang.Tb_menu;

public interface TbMenuBiz {

	public List<Tb_menu> selectMenu();
	
	public int addMenuid(String name);
}
