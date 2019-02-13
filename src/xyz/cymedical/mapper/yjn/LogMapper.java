package xyz.cymedical.mapper.yjn;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.yjn.Log;

@Repository
public interface LogMapper {
	public List<Log> findAllLog();

	public boolean delLog(String log_id);
	
	public int insertLog(Map<String, Object> map);
}
