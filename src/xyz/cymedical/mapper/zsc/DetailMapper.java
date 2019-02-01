package xyz.cymedical.mapper.zsc;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.zsc.Detail;

@Repository
public interface DetailMapper {

	public int insertDetail(Detail detail);
	
	public int updateDetail(Detail detail);
	
	public int deleteDetail(int id);
	
	public List<Detail> findDetails();
	
	public Detail findDetail(String detail_id);
	
	public List<Detail> selectDetail(Detail detail);
	
	public int checkName(Map<String, Object> map);
}
