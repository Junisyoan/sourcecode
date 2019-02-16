package xyz.cymedical.biz.yjn;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.cymedical.entity.yjn.Log;

public interface LogBiz {
	public List<Log> findAllLog();

	public boolean delLog(String log_id);
	
	public List<Log> searchLog(@Param("name") String name, @Param("opera") String opera, @Param("time") String time);
}
