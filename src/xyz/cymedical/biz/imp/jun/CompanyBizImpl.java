package xyz.cymedical.biz.imp.jun;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jun.CompanyBiz;
import xyz.cymedical.entity.jun.Company;
import xyz.cymedical.mapper.jun.CompanyMapper;

/**
* 2019年1月19日
* @author Junisyoan
* @version 1.0
*/

@Service("companyBiz")
public class CompanyBizImpl implements CompanyBiz {

	@Resource
	private CompanyMapper companyMapper;
	
	@Override
	public boolean regCompany(Company company) {
		System.out.println("准备注册"+company);
		return companyMapper.insertCompany(company);
		
	}

}
