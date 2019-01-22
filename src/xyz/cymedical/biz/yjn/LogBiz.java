package xyz.cymedical.biz.yjn;

import java.util.List;

import xyz.cymedical.entity.yjn.Log;

public interface LogBiz {
	public List<Log> findAllLog();

	public boolean delLog(String log_id);
}
