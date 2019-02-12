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

	public String insertCompany(Company company) {
		int rt = companyMappers.insertCompany(company);

		if (rt > 0) {
			return "添加成功";
		} else {
			return "添加失败";
		}
	};

	public String updateCompany(Company company) {
		int rt = companyMappers.updateCompany(company);

		if (rt > 0) {
			return "修改成功";
		} else {
			return "修改失败";
		}
	};

	public String deleteCompany(String id) {
		companyMappers.deleteCompany(id);
		return "删除成功";
	};

	public List<Company> findCompanys() {
		return companyMappers.findCompanys();
	};

	public Company findCompany(String company_id) {
		return companyMappers.findCompany(company_id);
	}

	public List<Company> selectCompany(Map<String, Object> map) {
		return companyMappers.selectCompany(map);
	};

	public String checkName(Map<String, Object> map) {
		int rt = companyMappers.checkName(map);
		if (rt > 0) {
			return "该账号已存在";
		} else {
			return "该账号可使用";
		}
	}

	public void stateChange(Company company) {
		companyMappers.stateChange(company);
	};

	public String resetPwd(String company_id) {
		companyMappers.resetPwd(company_id);
		return "重置密码成功";
	};
}
