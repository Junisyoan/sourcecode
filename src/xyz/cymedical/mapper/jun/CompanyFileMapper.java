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
