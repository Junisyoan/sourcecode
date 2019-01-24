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

	
	
	//query
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
