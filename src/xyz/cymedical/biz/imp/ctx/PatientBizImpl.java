package xyz.cymedical.biz.imp.ctx;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.ctx.PatientBiz;
import xyz.cymedical.biz.imp.jun.BaseImpl;
import xyz.cymedical.entity.jun.Patient;
import xyz.cymedical.mapper.ctx.PatientMapper;

@Service("patientBiz")
public class PatientBizImpl extends BaseImpl implements PatientBiz {

	@Resource
	private PatientMapper patientMapper;

	@Override
	public List<Patient> query(String name, String phone, String time, String code) {
		return patientMapper.query(name, phone, time, code);
	}

	@Override
	public List<Patient> insertByBatch(List<Patient> listRecord) {
		// 成功人数
		int number = 0;
		// 体检人员信息
		Patient patient = null;
		
		for (int i = 0; i < listRecord.size(); i++) {
			patient = listRecord.get(i);
			System.out.println("准备插入："+patient);
			if (patientMapper.insertPatient(patient)) {
				System.out.println(patient.getPaitent_id());
				isUpdate = true;
				listRecord.get(i).setPaitent_id(patient.getPaitent_id());
			} else {
				isUpdate = false;
			}
			// 执行成功+1
			if (isUpdate) {
				number++;
			}
		}
		if (number == listRecord.size()) {
			System.out.println("插入成功");
			return listRecord;
		} else {
			System.out.println("插入失败");
			return null;
		}
	}

	@Override
	public List<Patient> queryproject(String name, String time) {
		return patientMapper.queryproject(name, time);
	}

	@Override
	public List<Patient> querybrief(String name, String time) {
		return patientMapper.querybrief(name, time);
	}

	@Override
	public List<Patient> queryadvise(String name, String time) {
		return patientMapper.queryadvise(name, time);
	}

	@Override
	public List<Patient> queryByAccount(String account, String name, String time) {
		return patientMapper.queryByAccount(account, name, time);
	}

	@Override
	public List<Patient> querypath(String name, String time) {
		return patientMapper.querypath(name, time);
	}

	@Override
	public boolean queryID(String ID) {
		if (patientMapper.queryID(ID)!=null) {
			isUpdate=true;
		} else {
			isUpdate=false;
		}
		return isUpdate;
	}

	@Override
	public boolean queryPhone(String phone) {
		if (patientMapper.queryPhone(phone)!=null) {
			isUpdate=true;
		} else {
			isUpdate=false;
		}
		return isUpdate;
	}

}
