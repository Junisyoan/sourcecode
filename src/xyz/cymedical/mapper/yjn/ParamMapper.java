package xyz.cymedical.mapper.yjn;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import xyz.cymedical.entity.yjn.Parameter;

@Repository
public interface ParamMapper {

	public List<Parameter> findAllParam();

	public boolean delParam(String param_id);

	public List<Parameter> searchParam(@Param("param_id") String param_id, @Param("pid") String pid,
			@Param("name") String name);

	public boolean insertParam(@Param("pid") String pid, @Param("name") String name);
}
