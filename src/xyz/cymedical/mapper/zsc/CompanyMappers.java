package xyz.cymedical.mapper.zsc;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jun.Company;

@Repository
public interface CompanyMappers {

	public int insertCompany(Company company);
	
	public int updateCompany(Company company);
	
	public int deleteCompany(String id);
	
	public List<Company> findCompanys();
	
	public Company findCompany(String company_id);
	
	public List<Company> selectCompany(Map<String, Object> map);

	public int checkName(Map<String, Object> map);

	public int stateChange(Company company);
	
	public int resetPwd(String company_id);
	
	public int checkPwd(Company company);
	
	public int changePwd(Company company);
}
