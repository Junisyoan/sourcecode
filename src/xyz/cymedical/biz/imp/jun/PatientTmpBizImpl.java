package xyz.cymedical.biz.imp.jun;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jun.PatientTmpBiz;
import xyz.cymedical.entity.jun.Patient;
import xyz.cymedical.entity.jun.PatientTmp;
import xyz.cymedical.mapper.jun.PatientTmpMapper;

/**
*	@author Junisyoan;
*	日期：2019年2月21日
*	时间：下午3:54:48
*	类说明：
*/
@Service("patientTmpBiz")
public class PatientTmpBizImpl extends BaseImpl implements PatientTmpBiz {


	@Resource
	PatientTmpMapper patientTmpMapper;
	
	@Override
	public boolean insert(List<PatientTmp> patients) {
		System.out.println(patients);
		if (patientTmpMapper.insertPatientTmp(patients)>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<PatientTmp> queryByhcode(String hcode) {
		return patientTmpMapper.queryByhcode(hcode);
	}

	@Override
	public boolean del(String bid) {
		return patientTmpMapper.delByBillerId(bid);
	}

	@Override
	public List<PatientTmp> queryByBillerId(String bid) {
		return patientTmpMapper.queryByBillerId(bid);
	}

}
