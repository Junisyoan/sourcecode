package xyz.cymedical.biz.jun;

import xyz.cymedical.entity.jun.Group;

/**
*	@author Junisyoan;
*	日期：2019年1月29日
*	时间：下午11:44:32
*	类说明：导检单操作
*/
public interface GroupBiz {
	
	
	/**
	 * 更新软件表信息
	 * @param fid	文件表id
	 * @param pnum	人数
	 * @param price	价格
	 * @return	是否修改成功
	 */
	public boolean updateGroupInfo(int fid,int pnum, float price);
	
	/**
	 * 查询团检表
	 * @param fid	文件Id
	 * @return	团检表
	 */
	public Group queryGroupByFileId(int fid);

	/**
	 * 创建团检表以及关联表
	 * @param cid	公司id
	 * @param fid	文件id
	 * @return	是否创建成功
	 */
	public boolean createGroup(int cid, int fid);
}
