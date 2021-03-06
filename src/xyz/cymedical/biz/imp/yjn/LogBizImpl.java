package xyz.cymedical.biz.imp.yjn;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.yjn.LogBiz;
import xyz.cymedical.entity.yjn.Log;
import xyz.cymedical.mapper.yjn.LogMapper;

@Service("logBiz")
public class LogBizImpl implements LogBiz {

	@Resource
	private LogMapper logmapper;

	@Override
	public List<Log> findAllLog() {
		return logmapper.findAllLog();
	}

	@Override
	public boolean delLog(String log_id) {
		return logmapper.delLog(log_id);
	}

	@Override
	public List<Log> searchLog(String name, String opera, String time) {
		// TODO Auto-generated method stub
		return logmapper.searchLog(name, opera, time);
	}

}
