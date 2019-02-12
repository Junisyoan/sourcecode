package xyz.cymedical.biz.imp.xin;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.xin.BriefBiz;
import xyz.cymedical.biz.xin.DoctorBiz;
import xyz.cymedical.mapper.xin.BriefMapper;
import xyz.cymedical.mapper.xin.DoctorMapper;

/**
* 2019年1月20日
* @author xin
* @version 1.0
*/

@Service("briefbiz")
public class BriefBizImpl  implements BriefBiz {

	@Resource
	private BriefMapper briefMapper;

	@Override
	public boolean Photo(String result,String path,String id) {
		return briefMapper.Photo(result,path,id);
	}

	@Override
	public boolean Check(String result, String tips, String id) {
		return briefMapper.Check(result, tips, id);
	}

	@Override
	public boolean Normal(String result, String id) {
		return briefMapper.Normal(result, id);
	}
}
