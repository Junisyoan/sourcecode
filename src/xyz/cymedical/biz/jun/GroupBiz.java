package xyz.cymedical.biz.jun;


/**
*	@author Junisyoan;
*	日期：2019年1月29日
*	时间：下午11:44:32
*	类说明：导检单操作
*/
public interface GroupBiz {

	/**
	 * 生成团检表
	 * @param cid	公司id
	 * @param pnum	人数
	 * @param time	生成时间
	 * @return	是否成功
	 */
	public boolean insert(int cid,int pnum,String time);
}
