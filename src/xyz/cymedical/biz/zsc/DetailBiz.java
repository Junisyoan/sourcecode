package xyz.cymedical.biz.zsc;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.entity.zsc.Detail;
import xyz.cymedical.mapper.zsc.DetailMapper;

@Service
public class DetailBiz {

	@Resource
	DetailMapper detailMapper;
	
	public int insertDetail(Detail detail) {
		return detailMapper.insertDetail(detail);
	};
	
	public int updateDetail(Detail detail) {
		return detailMapper.updateDetail(detail);
	};
	
	public int deleteDetail(int id) {
		return detailMapper.deleteDetail(id);
	};
	
	public List<Detail> findDetails(){
		return detailMapper.findDetails();
	};
	
	public Detail findDetail(String detail_id) {
		return detailMapper.findDetail(detail_id);
	}
	
	public List<Detail> selectDetail(Detail detail){
		return detailMapper.selectDetail(detail);
	};
}
