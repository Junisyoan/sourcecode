package xyz.cymedical.biz.jun;

import org.springframework.web.multipart.MultipartFile;

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
	public boolean insertFile(MultipartFile file);
}
