package xyz.cymedical.biz.zsc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.entity.xin.Combo;
import xyz.cymedical.mapper.zsc.ComboMapper;

@Service
public class ComboBiz {

	@Resource
	ComboMapper comboMapper;
	
	public int insertCombo(Combo combo,int[] idArray) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idArray", idArray);
		
		if (combo.getPrice() == 0) {
			int price = comboMapper.selectPrice(map);
			combo.setPrice(price);
		}
		
		comboMapper.insertCombo(combo);
		map.put("combo", combo);
		
		int rt = comboMapper.insertProCom(map);
		return rt;
	}
	
	public List<Combo> findCombos(){
		return comboMapper.selectCombo(null);
	}
	
	public int deleteCombo(int combo_id) {
		return comboMapper.deleteCombo(combo_id);
	};
	
	public List<Combo> selectCombo(HashMap<String, Object> map){
		return comboMapper.selectCombo(map);
	}
	
	public Combo findCombo(String combo_id){
		return comboMapper.findCombo(combo_id);
	}
	
	public String updateCombo(int[] idArray, Combo combo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idArray", idArray);
		map.put("combo", combo);
		
		int rt = comboMapper.updateCombo(map);
		if (rt > 0) {
			return "修改成功";
		} else {
			return "修改失败";
		}
	}
	

	public String checkName(Map<String, Object> map) {
		int rt = comboMapper.checkName(map);
		if (rt > 0) {
			return "该名称已存在";
		} else {
			return "该名称可使用";
		}
	};
}
