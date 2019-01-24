package xyz.cymedical.mapper.yjn;

import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.yjn.Param;
@Repository
public interface ParamMapper {
	public List<Param> findAllParam();
	
	public boolean delParam(String param_id);
}
