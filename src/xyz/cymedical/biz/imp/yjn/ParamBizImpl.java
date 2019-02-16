package xyz.cymedical.biz.imp.yjn;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.yjn.ParamBiz;
import xyz.cymedical.entity.yjn.Parameter;
import xyz.cymedical.mapper.yjn.ParamMapper;

@Service("paramBiz")
public class ParamBizImpl implements ParamBiz {

	@Resource
	private ParamMapper parammapper;

	@Override
	public List<Parameter> findAllParam() {
		return parammapper.findAllParam();
	}

	@Override
	public boolean delParam(String param_id) {
		return parammapper.delParam(param_id);
	}

	@Override
	public List<Parameter> searchParam(String param_id, String pid, String name) {
		// TODO Auto-generated method stub
		return parammapper.searchParam(param_id, pid, name);
	}

	@Override
	public boolean insertParam(String pid, String name) {
		// TODO Auto-generated method stub
		return parammapper.insertParam(pid, name);
	}

	@Override
	public boolean modifyParam(String param_id, String pid, String name) {
		// TODO Auto-generated method stub
		return parammapper.modifyParam(param_id, pid, name);
	}

}
