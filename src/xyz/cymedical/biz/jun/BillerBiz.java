package xyz.cymedical.biz.jun;

import java.util.List;

import xyz.cymedical.entity.jun.Biller;

/**
*	@author Junisyoan;
*	日期：2019年1月31日
*	时间：下午1:34:59
*	类说明：记账表相关操作
*/
public interface BillerBiz {
	
	
	public Biller query(int bid);
	
	/**
	 * 打印发票
	 * @param bid
	 * @return
	 */
	public List<Biller> getReceipt(int bid);
	
	/**
	 * 体检工作站查询账单列表
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
	 * @param bcreat	未开单
	 * @return	列表
	 */
	public List<Biller> queryBillerListByCreate(String bcreat);
	
	/**
	 * 查询已结算账单
	 * @param bstate	是否结算
	 * @return	账单列表
	 */
	public List<Biller> queryCompanyBillerList(String bstate,int cid);
	
	/**
	 * 结算账单
	 * @param bid	账单id
	 * @param bstate 结账状态
	 * @param btime	结账时间
	 * @return	是否结算成功
	 */
	public boolean payBiller(String bid,String bstate, String btime);
	
	/**
	 * 删除未结算账单
	 * @param bid	账单id
	 * @return	是否删除成功
	 */
	public boolean delBiller(String bid);
	
	/**
	 * 查询记账表
	 * @param gid	团检表id
	 * @param batch	批次
	 * @return	记账表信息
	 */
	public Biller queryBiller(int gid, String batch);
	
	/**
	 * 生成记账表
	 * @param gid	团检表id
	 * @param bstate	是否结算
	 * @param batch	批次
	 * @param price 总金额
	 * @return	是否成功
	 */
	public Biller insertBiller(Biller biller);
}
