package xyz.cymedical.mapper.jun;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jun.Group;

/**
*	@author Junisyoan;
*	日期：2019年1月29日
*	时间：下午11:47:21
*	类说明：映射类
*/

@Repository
public interface GroupMapper {
	
	/**
	 * 修改体检时间
	 * @param time	体检时间
	 * @return	是否插入
	 */
	public boolean updateGroupCheckTime(@Param("time")String time,@Param("bid")String bid);
	
	/**
	 * 创建关联表
	 * @param fid	文件id
	 * @param gid	团检表id
	 * @return	是否成功
	 */
	public boolean insertFileGroup(@Param("fid")int fid,@Param("gid")int gid);
	
	/**
	 * 更新软件表信息
	 * @param fid	文件表id
	 * @param pnum	人数
	 * @param price	价格
	 * @return	是否修改成功
	 */
	public int updateGroupInfo(
			@Param("fid")int fid,
			@Param("pnum")int pnum, 
			@Param("price")float price);
	
	/**
	 * 查询团检表
	 * @param fid	文件id
	 * @return	团检表
	 */
	public Group queryGroupByFileId(int fid);
	
	/**
	 * 生成团检表，并返回自增id
	 * @param group	团检表
	 * @return	是否成功
	 */
	public boolean insert(Group group);
}
