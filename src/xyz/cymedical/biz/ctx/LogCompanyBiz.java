package xyz.cymedical.biz.ctx;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.cymedical.entity.ctx.LogCompany;

/**
 * 2019年1月20日
 * 
 * @author ctx
 * @version 1.0
 */

public interface LogCompanyBiz {

	/**
	 * @author Junisyoan
	 * @param cid	公司id
	 * @param op	操作
	 * @param deposit	金额
	 * @param t	操作时间
	 * @return	是否插入成功
	 */
	public boolean insertLog(int cid,String op,String deposit,String t);
	
	public List<LogCompany> queryByName(String name);
	
	public List<LogCompany> queryAll();
	
	public List<LogCompany> searchLog(@Param("name") String name, @Param("operate") String operate,
			@Param("money") String money, @Param("time") String time);

}
