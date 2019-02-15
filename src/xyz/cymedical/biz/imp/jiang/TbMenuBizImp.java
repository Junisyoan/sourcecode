package xyz.cymedical.biz.imp.jiang;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jiang.TbMenuBiz;
import xyz.cymedical.entity.jiang.Tb_menu;
import xyz.cymedical.mapper.jiang.TbMenuMapper;


@Service("tbMenuBiz")
public class TbMenuBizImp implements TbMenuBiz{

	
	@Resource
	TbMenuMapper tbMenuMapper;
	
	
	@Override
	public List<Tb_menu> selectMenu() {
		return tbMenuMapper.selectMenu();
	}


	@Override
	public int addMenuid(String name) {
		return tbMenuMapper.addMenuid(name);
	}


	@Override
	public int delete(int menu_id) {
		return tbMenuMapper.delete(menu_id);
	}


	@Override
	public int upMenu(Tb_menu tb_menu) {
		return tbMenuMapper.upMenu(tb_menu);
	}


	@Override
	public List<Map<String, Object>> selectCompany(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tbMenuMapper.selectCompany(map);
	}


	@Override
	public int addMenu(Tb_menu tb_menu) {
		// TODO Auto-generated method stub
		return tbMenuMapper.addMenu(tb_menu);
	}

}
