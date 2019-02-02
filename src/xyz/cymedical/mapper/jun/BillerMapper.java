package xyz.cymedical.mapper.jun;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jun.Biller;

/**
*	@author Junisyoan;
*	日期：2019年1月31日
*	时间：下午1:37:21
*	类说明：记账表映射操作
*/

@Repository
public interface BillerMapper {
	
	/**
	 * 查询记账表
	 * @param gid	团检表id
	 * @param time	结账时间
	 * @return	记账表信息
	 */
	public Biller queryBiller(
			@Param("gid")int gid, 
			@Param("time")String time);

	/**
	 * 生成记账表
	 * @param gid	团检表id
	 * @param bstate	是否结算
	 * @param batch	批次
	 * @param btime	记账时间
	 * @return	是否成功
	 */
	public boolean insertBiller(
			@Param("gid")int gid,
			@Param("bstate")String bstate, 
			@Param("batch")String batch, 
			@Param("btime")String btime);
}
