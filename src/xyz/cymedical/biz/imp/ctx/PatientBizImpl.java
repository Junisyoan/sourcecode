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
	public boolean insertByBatch(List<Patient> listRecord) {
		int number = listRecord.size();
		int valid = patientMapper.insertByBatch(listRecord);
		if (number==valid) {
			isUpdate=true;
		} else {
			isUpdate=false;
		}
		return isUpdate;
	}

}
