package xyz.cymedical.mapper.ctx;

import java.util.List;

import org.springframework.stereotype.Repository;
import xyz.cymedical.entity.ctx.LogCompany;

/**
 * 2019-01-20
 * 
 * @author ctx
 * @version 1.0
 */

@Repository
public interface LogCompanyMapper {
	
	public List<LogCompany> queryByName(String name);

}
