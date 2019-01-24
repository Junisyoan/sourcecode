package xyz.cymedical.biz.imp.yjn;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.yjn.ParamBiz;
import xyz.cymedical.entity.yjn.Param;
import xyz.cymedical.mapper.yjn.ParamMapper;

@Service("paramBiz")
public class ParamBizImpl implements ParamBiz{

	@Resource
	private ParamMapper parammapper;
	
	@Override
	public List<Param> findAllParam() {
		// TODO Auto-generated method stub
		return parammapper.findAllParam();
	}

	@Override
	public boolean delParam(String param_id) {
		// TODO Auto-generated method stub
		return parammapper.delParam(param_id);
	}

}
