package xyz.cymedical.biz.imp.jun;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jun.CompanyBiz;
import xyz.cymedical.entity.ctx.LogCompany;
import xyz.cymedical.entity.jun.Company;
import xyz.cymedical.mapper.jun.CompanyFileMapper;
import xyz.cymedical.mapper.jun.CompanyMapper;

/**
* 2019年1月19日
* @author Junisyoan
* @version 1.0
*/

@Service("companyBiz")
public class CompanyBizImpl extends BaseImpl implements CompanyBiz {

	@Resource
	private CompanyMapper companyMapper;
	@Resource
	private CompanyFileMapper companyFileMapper;
	
	@Override
	public String regCompany(Company company) {
		System.out.println("准备注册"+company);
		//先查询这个公司名字有没有被注册过了
		if(companyMapper.queryCompanyByName(company.getName())!=null) {
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

	@Override
	public boolean queryName(String name) {
		if (companyMapper.queryCompanyByName(name)!=null) {
			isExsit=true;
		} else {
			isExsit=false;
		}
		return isExsit;
	}

	@Override
	public boolean queryAccount(String account) {
		if (companyMapper.queryCompanyByAccount(account)!=null) {
			isExsit=true;
		} else {
			isExsit=false;
		}
		return isExsit;
	}

	@Override
	public boolean queryTel(String tel) {
		if (companyMapper.queryCompanyByTel(tel)!=null) {
			isExsit=true;
		} else {
			isExsit=false;
		}
		return isExsit;
	}

	@Override
	public Company companyLogin(String account, String pwd) {
		return companyMapper.queryCompanyByLogin(account, pwd);
	}

	@Override
	public boolean delCompanyFile(String file_id) {
		System.out.println("删除文件Id："+file_id);
		isUpdate=false;
		if (companyMapper.delFile(file_id)) {
			System.out.println("删除关系表成功");
		}else {
			System.out.println("关系表不存在");
		}
		//文件路径
		String path = companyFileMapper.queryFileById(file_id).getFpath();
		//得到文件
		File file = new File(path);
		System.out.println("准备删除"+file.getName());
		if (file.exists()) {
			if (file.delete()&&companyFileMapper.delFile(file_id)) {
				System.out.println("文件删除成功");
				isUpdate=true;
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

}
