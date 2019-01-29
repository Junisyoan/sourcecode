package xyz.cymedical.biz.imp.jun;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jun.NurseBiz;
import xyz.cymedical.entity.jun.CompanyFile;
import xyz.cymedical.entity.jun.Nurse;
import xyz.cymedical.entity.xin.Combo;
import xyz.cymedical.mapper.jun.CompanyMapper;
import xyz.cymedical.mapper.jun.NurseMapper;

/**
*	@author Junisyoan;
*	日期：2019年1月29日
*	时间：下午1:26:55
*	类说明：
*/

@Service("nurseBiz")
public class NurseBizImpl extends BaseImpl implements NurseBiz {

	@Resource
	private NurseMapper nurseMapper;
	@Resource
	private CompanyMapper companyMapper;
	
	@Override
	public Nurse queryNurseBylogin(String account, String pwd) {
		return nurseMapper.queryNurseByLogin(account, pwd);
	}

	@Override
	public List<CompanyFile> queryCheckFile(String pageNum) {
		int pn = Integer.parseInt(pageNum);
		return nurseMapper.queryCheckFile(pn-1);
	}

	@Override
	public Combo queryComboByName(String comboName) {
		return nurseMapper.queryComboByName(comboName);
	}

	@Override
	public String deductDeposit(int company_id,float price) {
		
		//先取出公司金额
		double deposit = companyMapper.queryCompanyById(company_id).getDeposit();
		
		if (deposit-price>0) {
			if (nurseMapper.deductDeposit(String.valueOf(company_id),String.valueOf(price))) {
				return "扣除成功";
			} else {
				return "扣除失败";
			}
		} else {
			return "余额不足";
		}
	}

}
