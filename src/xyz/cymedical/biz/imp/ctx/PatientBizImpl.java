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
		// 自增长的id
		for (int i = 0; i < listRecord.size(); i++) {
			patient = listRecord.get(i);
			if (patientMapper.insertPatient(patient)) {
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
		System.out.println("执行结果" + listRecord.size() + "," + number);

		if (number == listRecord.size()) {
			return listRecord;
		} else {
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

}
