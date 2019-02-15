package xyz.cymedical.mapper.ctx;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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
	
	/**
	 * @author Junisyoan
	 * @param cid	公司id
	 * @param op	操作
	 * @param deposit	金额
	 * @param t	操作时间
	 * @return	是否插入成功
	 */
	public boolean insertLog(@Param("company_id")int cid,
			@Param("operate")String op,
			@Param("deposit")String deposit,
			@Param("time")String t);
	
	public List<LogCompany> queryByName(String name);
	
	public List<LogCompany> queryAll();

}
