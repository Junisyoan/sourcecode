package xyz.cymedical.biz.imp.xin;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import xyz.cymedical.biz.xin.DoctorBiz;
import xyz.cymedical.mapper.xin.DoctorMapper;

/**
* 2019年1月20日
* @author xin
* @version 1.0
*/

@Service("doctorbiz")
public class DoctorBizImpl  implements DoctorBiz {

	@Resource
	private DoctorMapper doctorMapper;

	@Override
	public List<Map<String,Object>> findMyProject(String code) {
		return doctorMapper.findMyProject(code);
	}

	@Override
	public boolean receive(int patient_project_id) {
		return doctorMapper.receive(patient_project_id);
	}

	@Override
	public List<Map<String, Object>> findMyDetail(int projectid,int patientid) {
		return doctorMapper.findMyDetail(projectid,patientid);
	}


	

}
