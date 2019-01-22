package xyz.cymedical.biz.jun;

import xyz.cymedical.entity.jun.CompanyFile;

/**
*	@author Junisyoan;
*	日期：2019年1月22日
*	时间：上午11:29:53
*	类说明：文件库
*/
public interface CompanyFileBiz {

	//insert
	
	/**
	 * 插入数据库
	 * @param file	文件
	 * @return	是否插入成功
	 */
	public boolean insertFile(CompanyFile file);
}
