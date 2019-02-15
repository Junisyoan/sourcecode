package xyz.cymedical.mapper.jun;

import java.util.List;

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
	 * 医院查询账单
	 * @param bstate
	 * @return
	 */
	public List<Biller> queryBillerList(String bstate);
	
	/**
	 * 修改记账表为开单
	 * @param bid	记账表id
	 * @return	是否成功
	 */
	public boolean updateBillerCreate(String bid);
	
	/**
	 * 查询账单列表
	 * @param bcreat	是否开单
	 * @return	账单列表
	 */
	public List<Biller> queryBillerListByCreate(String bcreat);
	
	/**
	 * 查询账单
	 * @param bstate	结算状态
	 * @return	账单列表
	 */
	public List<Biller> queryCompanyBillerList(@Param("bstate")String bstate,@Param("cid")int cid);
	
	/**
	 * 结账
	 * @param bid	账单id
	 * @param bstate	结算状态
	 * @param btime	结账时间
	 * @return	是否成功
	 */
	public boolean payBiller(
			@Param("bid")String bid,
			@Param("bstate")String bstate, 
			@Param("btime")String btime);
	
	/**
	 * 删除未结算账单
	 * @param bid	账单id
	 * @return	是否删除成功
	 */
	public boolean delBiller(String bid);
	
	
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
	 * @param price 总金额
	 * @return	是否成功
	 */
	public boolean insertBiller(
			@Param("gid")int gid,
			@Param("bstate")String bstate, 
			@Param("batch")String batch,
			@Param("price")float price);
}
