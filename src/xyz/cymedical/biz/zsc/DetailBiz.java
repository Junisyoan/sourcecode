package xyz.cymedical.biz.zsc;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import xyz.cymedical.aop.zsc.Log;
import xyz.cymedical.entity.zsc.Detail;
import xyz.cymedical.mapper.zsc.DetailMapper;

@Transactional(rollbackFor=Exception.class)
@Service
public class DetailBiz {

	@Resource
	DetailMapper detailMapper;
	
	@Log(action = "添加细项")
	public String insertDetail(Detail detail) {
		int rt = detailMapper.insertDetail(detail);
		if (rt > 0) {
			return "添加成功";
		} else {
			return "添加失败";
		}
	};
	
	@Log(action ="修改细项")
	public String updateDetail(Detail detail) {
		int rt = detailMapper.updateDetail(detail);
		if (rt > 0) {
			return "修改成功";
		} else {
			return "修改失败";
		}
	};
	
	@Log(action ="删除细项")
	public String deleteDetail(int id) {
		int rt = detailMapper.deleteDetail(id);
		return "删除成功";
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
	
	public String checkName(Map<String, Object> map) {
		int rt = detailMapper.checkName(map);
		if (rt > 0) {
			return "该名称已存在";
		} else {
			return "该名称可使用";
		}
	};
}
