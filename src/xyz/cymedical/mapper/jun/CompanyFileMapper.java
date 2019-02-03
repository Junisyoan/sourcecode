package xyz.cymedical.mapper.jun;

import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jun.CompanyFile;

/**
*	@author Junisyoan;
*	日期：2019年1月22日
*	时间：上午11:33:14
*	类说明：
*/


@Repository
public interface CompanyFileMapper {
	
	/**
	 * 通过账单id找到文件id
	 * @param bid	账单id
	 * @return	文件信息
	 */
	public CompanyFile queryFileByBillerId(String bid);
	
	/**
	 * 查询通过审核的文件列表
	 * @return	文件列表
	 */
	public List<CompanyFile> queryPassFileList();

	/**
	 * 修改文件状态为已审核
	 * @param fid	文件id
	 * @return	是否修改成功
	 */
	public boolean updateFileState(int fid);
	
	/**
	 * 查询文件
	 * @param file_id	文件id
	 * @return	文件
	 */
	public CompanyFile queryFileById(String file_id);
	
	/**
	 * 删除文件
	 * @param file_id	文件id
	 * @return	是否删除成功
	 */
	public boolean delFile(String file_id);
	
	/**
	 * 查询文件列表
	 * @param pageNo	页码
	 * @return	文件列表
	 */
	public List<CompanyFile> queryFileList(int pageNo);
	
	/**
	 * 文件信息插入数据库
	 * @param file	文件信息
	 * @return	是否插入成功
	 */
	public boolean insertFile(CompanyFile file);
}
