package xyz.cymedical.biz.zsc;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.entity.jun.Company;
import xyz.cymedical.mapper.zsc.CompanyMappers;
import xyz.cymedical.tools.zsc.encryption;

@Service
public class CompanyBizsc {

	@Resource
	CompanyMappers companyMappers;

	public List<Company> findCompanys() {
		return companyMappers.findCompanys();
	};

	public Company findCompany(String company_id) {
		return companyMappers.findCompany(company_id);
	}

	public List<Company> selectCompany(Map<String, Object> map) {
		return companyMappers.selectCompany(map);
	};

	public String deleteCompany(String id) {
		companyMappers.deleteCompany(id);
		return "删除成功";
	};

	public String insertCompany(Company company) {
		company.setPwd(encryption.getResult(company.getPwd()));
		
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

	public String checkName(Map<String, Object> map) {
		int rt = companyMappers.checkName(map);
		if (rt > 0) {
			return "该账号已存在";
		} else {
			return "该账号可使用";
		}
	}

	public String stateChange(Company company) {
		int rt = companyMappers.stateChange(company);
		if (rt > 0) {
			if (company.getState().equals("禁用")) {
				return "禁用成功";
			}else {
				return "启用成功";
			}
		} else {
			if (company.getState().equals("禁用")) {
				return "禁用失败";
			}else {
				return "启用失败";
			}
		}
	};

	public String resetPwd(String company_id) {
		int rt = companyMappers.resetPwd(company_id);
		if (rt > 0) {
			return "重置密码成功";
		} else {
			return "重置密码失败";
		}
	};

	//密码验证
	public String checkPwd(Company company) {
		int rt = companyMappers.checkPwd(company);
		if (rt > 0) {
			return "密码验证成功";
		} else {
			return "密码验证失败";
		}
	};

	//密码修改
	public String changePwd(Company company) {
		int rt = companyMappers.changePwd(company);
		if (rt > 0) {
			return "密码修改成功";
		} else {
			return "密码修改失败";
		}
	};
}
