package xyz.cymedical.biz.imp.jun;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jun.NurseBiz;
import xyz.cymedical.entity.jun.CompanyFile;
import xyz.cymedical.entity.jun.Nurse;
import xyz.cymedical.entity.jun.Patient;
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
	public boolean insertRelation(int bid, List<Patient> pList) {
		
		int num = nurseMapper.insertBatchRelation(bid, pList);
		if (pList.size()==num) {
			System.out.println("体检人员和账单关系表建立成功");
			isUpdate=true;
		} else {
			System.out.println("体检人员和账单关系表建立失败");
			isUpdate=false;
		}
		return isUpdate;
	}

	@Override
	public List<Patient> getCheckPage(String bid) {
		return nurseMapper.getCheckPage(bid);
	}

	@Override
	public boolean insertPaitentCombo(List<Patient> patients,String bid) {
		System.out.println("体检人数量："+patients.size());
		if (nurseMapper.insertPaitentCombo(Integer.parseInt(bid),patients)==patients.size()) {
			isUpdate=true;
		}else {
			isUpdate=false;
		}
		return isUpdate;
	}
}
