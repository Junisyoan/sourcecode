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
	public String regCompany(Company company) {
		//先查询这个公司名字有没有被注册过了
		if(companyMapper.queryCompanyByName(company)!=null) {
			return "已被注册";
		}else {
			//注册公司
			if(companyMapper.insertCompany(company)) {
				return "注册成功";
			}else {
				return "注册失败";
			}
		}
	}

}
