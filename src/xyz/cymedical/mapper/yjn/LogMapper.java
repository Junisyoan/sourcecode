package xyz.cymedical.mapper.yjn;

import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.yjn.Log;

@Repository
public interface LogMapper {
	public List<Log> findAllLog();
}
