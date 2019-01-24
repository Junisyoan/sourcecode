package xyz.cymedical.biz.yjn;

import java.util.List;

import xyz.cymedical.entity.yjn.Param;

public interface ParamBiz {
	public List<Param> findAllParam();
	
	public boolean delParam(String param_id);
}
