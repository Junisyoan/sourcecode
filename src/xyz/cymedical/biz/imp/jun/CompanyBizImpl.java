package xyz.cymedical.biz.imp.jun;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.cymedical.biz.jun.CompanyBiz;
import xyz.cymedical.entity.ctx.LogCompany;
import xyz.cymedical.entity.jun.Company;
import xyz.cymedical.entity.jun.Patient;
import xyz.cymedical.mapper.jun.CompanyFileMapper;
import xyz.cymedical.mapper.jun.CompanyMapper;

/**
 * 2019年1月19日
 * 
 * @author Junisyoan
 * @version 1.0
 */

@Transactional(rollbackFor=Exception.class)
@Service("companyBiz")
public class CompanyBizImpl extends BaseImpl implements CompanyBiz {

	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private CompanyFileMapper companyFileMapper;

	@Override
	public String regCompany(Company company) {
		System.out.println("准备注册" + company);
		// 先查询这个公司名字有没有被注册过了
		if (companyMapper.queryCompanyByName(company.getName()) != null) {
			return "已被注册";
		} else {
			// 注册公司
			if (companyMapper.insertCompany(company)) {
				return "注册成功";
			} else {
				return "注册失败";
			}
		}
	}

	@Override
	public boolean queryName(String name) {
		if (companyMapper.queryCompanyByName(name) != null) {
			isExsit = true;
		} else {
			isExsit = false;
		}
		return isExsit;
	}

	@Override
	public boolean queryAccount(String account) {
		if (companyMapper.queryCompanyByAccount(account) != null) {
			isExsit = true;
		} else {
			isExsit = false;
		}
		return isExsit;
	}

	@Override
	public boolean queryTel(String tel) {
		if (companyMapper.queryCompanyByTel(tel) != null) {
			isExsit = true;
		} else {
			isExsit = false;
		}
		return isExsit;
	}

	@Override
	public Company companyLogin(String account, String pwd) {
		return companyMapper.queryCompanyByLogin(account, pwd);
	}

	@Override
	public boolean delCompanyFile(String file_id) {
		System.out.println("删除文件Id：" + file_id);
		isUpdate = false;
		if (companyMapper.delFile(file_id)) {
			System.out.println("删除关系表成功");
		} else {
			System.out.println("关系表不存在");
		}
		// 文件路径
		String path = companyFileMapper.queryFileById(file_id).getFpath();
		// 得到文件
		File file = new File(path);
		System.out.println("准备删除" + file.getName());
		if (file.exists()) {
			if (file.delete() && companyFileMapper.delFile(Integer.parseInt(file_id))) {
				System.out.println("文件删除成功");
				isUpdate = true;
			}
		}

		return isUpdate;
	}

	@Override
	public List<LogCompany> queryDepositList(String c_id) {
		return companyMapper.queryDepositList(c_id);
	}

	@Override
	public float queryDepositCompanyId(int company_id) {
		return companyMapper.queryDepositByCompanyId(company_id);

	}

	@Override
	public boolean updateDeposit(float deposit, int company_id) {
		return companyMapper.updateDeposit(deposit, company_id);
	}

	@Override
	public Company queryCompanyById(int id) {
		return companyMapper.queryCompanyById(id);
	}

	@Override
	public List<Company> queryByAccount(String account) {
		return companyMapper.queryByAccount(account);
	}

	@Override
	public String deductDeposit(int company_id, float price) {
		//先取出公司金额
		double deposit = companyMapper.queryCompanyById(company_id).getDeposit();
		//扣除费用
		if (deposit-price>0) {
			if (companyMapper.deductDeposit(String.valueOf(company_id),String.valueOf(deposit-price))) {
				return "扣除成功";
			} else {
				return "扣除失败";
			}
		} else {
			return "余额不足";
		}
	}

	@Override
	public boolean Refund(int companyid, double deposit) {
		// TODO Auto-generated method stub
		return companyMapper.Refund(companyid,deposit);
	}

	@Override
	public Company findCompany(int company_id) {
		// TODO Auto-generated method stub
		return companyMapper.findCompany(company_id);
	}


}
