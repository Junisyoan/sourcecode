package xyz.cymedical.mapper.zsc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.xin.Combo;

@Repository
public interface ComboMapper {

	public int selectPrice(Map<String, Object> map);
	
	public int insertCombo(Combo combo);
	
	public int insertProCom(Map<String, Object> map);
	
	public int deleteCombo(int combo_id);
	
	public List<Combo> selectCombo(HashMap<String, Object> map);
	
	public Combo findCombo(String combo_id);
	
	public int updateCombo(Map<String, Object> map);

	public int checkName(Map<String, Object> map);
	
	public List<Combo> queryCombo();
}
