package xyz.cymedical.biz.imp.jun;

import javax.annotation.Resource;

import org.springframework.web.multipart.MultipartFile;

import xyz.cymedical.biz.jun.CompanyFileBiz;
import xyz.cymedical.mapper.jun.CompanyFileMapper;

/**
*	@author Junisyoan;
*	日期：2019年1月22日
*	时间：上午11:32:16
*	类说明：
*/
public class CompanyFileBizImpl implements CompanyFileBiz {

	@Resource
	private CompanyFileMapper companyFileMapper;
	
	@Override
	public boolean insertFile(MultipartFile file) {
		return false;
	}

}
