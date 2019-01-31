package xyz.cymedical.biz.zsc;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.entity.jun.Company;
import xyz.cymedical.mapper.zsc.CompanyMappers;

@Service
public class CompanyBizsc {

	@Resource
	CompanyMappers companyMappers;
	
	public int insertCompany(Company company) {
		return companyMappers.insertCompany(company);
	};
	
	public int updateCompany(Company company) {
		return companyMappers.updateCompany(company);
	};
	
	public int deleteCompany(String id) {
		return companyMappers.deleteCompany(id);
	};
	
	public List<Company> findCompanys(){
		return companyMappers.findCompanys();
	};
	
	public Company findCompany(String company_id) {
		return companyMappers.findCompany(company_id);
	}
	
	public List<Company> selectCompany(Map<String, Object> map){
		return companyMappers.selectCompany(map);
	};

	public String checkName(Map<String, Object> map) {
		int rt = companyMappers.checkName(map);
		if (rt > 0) {
			return "该账号已存在";
		} else {
			return "该账号可使用";
		}
	};
}
