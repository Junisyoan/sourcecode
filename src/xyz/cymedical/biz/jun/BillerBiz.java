package xyz.cymedical.biz.jun;

import xyz.cymedical.entity.jun.Biller;

/**
*	@author Junisyoan;
*	日期：2019年1月31日
*	时间：下午1:34:59
*	类说明：记账表相关操作
*/
public interface BillerBiz {
	
	/**
	 * 查询记账表
	 * @param gid	团检表id
	 * @param time	结账时间
	 * @return	记账表信息
	 */
	public Biller queryBiller(int gid, String time);
	
	/**
	 * 生成记账表
	 * @param gid	团检表id
	 * @param bstate	是否结算
	 * @param batch	批次
	 * @param btime	记账时间
	 * @return	是否成功
	 */
	public boolean insertBiller(int gid,String bstate, String batch, String btime);
}
