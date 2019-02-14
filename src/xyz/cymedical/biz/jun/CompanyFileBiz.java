package xyz.cymedical.biz.jun;

import java.util.List;

import xyz.cymedical.entity.jun.CompanyFile;

/**
*	@author Junisyoan;
*	日期：2019年1月22日
*	时间：上午11:29:53
*	类说明：文件库
*/
public interface CompanyFileBiz {
	
	
	//delete
	/**
	 * 删除文件
	 * @param fid	文件id
	 * @return	是否删除成功
	 */
	public boolean delFile(String fid);

	//update
	/**
	 * 修改文件状态为已审核
	 * @param fid	文件id
	 * @return	是否修改成功
	 */
	public boolean updateFileState(int fid,String cstate);
	
	//query
	/**
	 * 通过账单id找到文件id
	 * @param bid	账单id
	 * @return	文件信息
	 */
	public CompanyFile queryFileByBillerId(String bid);
	
	/**
	 * 查询通过审核的文件
	 * @return	文件列表
	 */
	public List<CompanyFile> queryPassFileList();
	
	/**
	 * 查询文件列表
	 * @param pageNum	页码
	 * @return	文件列表
	 */
	public List<CompanyFile> queryFileList(String pageNum);
	
	/**
	 * 	查询文件
	 * @param file_id	文件id
	 * @return	文件信息
	 */
	public CompanyFile queryFile(String file_id);
	
	//insert
	
	/**
	 * 插入数据库
	 * @param file	文件
	 * @return	是否插入成功
	 */
	public boolean insertFile(CompanyFile file);
}
