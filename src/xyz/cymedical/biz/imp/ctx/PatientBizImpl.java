package xyz.cymedical.biz.imp.ctx;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.ctx.PatientBiz;
import xyz.cymedical.entity.jun.Patient;
import xyz.cymedical.mapper.ctx.PatientMapper;

@Service("patientBiz")
public class PatientBizImpl implements PatientBiz {

	@Resource
	private PatientMapper patientMapper;

	@Override
	public List<Patient> query(String name, String phone, String time, String code) {
		// TODO Auto-generated method stub
		return patientMapper.query(name, phone, time, code);
	}

}
