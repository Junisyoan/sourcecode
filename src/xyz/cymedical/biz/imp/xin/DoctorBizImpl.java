package xyz.cymedical.biz.imp.xin;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import xyz.cymedical.biz.xin.DoctorBiz;
import xyz.cymedical.entity.jiang.Tb_menu;
import xyz.cymedical.entity.jiang.Tb_user;
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
	public boolean receive(int patient_project_id,int userid) {
		return doctorMapper.receive(patient_project_id,userid);
	}

	@Override
	public List<Map<String, Object>> findMyDetail(int projectid,int patientid) {
		return doctorMapper.findMyDetail(projectid,patientid);
	}

	@Override
	public List<Map<String, Object>> findAllDetail(String onecode) {
		// TODO Auto-generated method stub
		return doctorMapper.findAllDetail(onecode);
	}

	@Override
	public boolean addsummarize(String advice, String guide) {
		// TODO Auto-generated method stub
		return doctorMapper.addsummarize(advice,guide);
	}

	//找到插入总结的id
	@Override
	public String findsumid() {
		// TODO Auto-generated method stub
		return doctorMapper.findsumid();
	}

	@Override
	public Tb_user login(String account, String pwd) {
		// TODO Auto-generated method stub
		return doctorMapper.login(account,pwd);
	}

	@Override
	public List<Tb_menu> getMyMenu(int user_id, int role_dept_id) {
		// TODO Auto-generated method stub
		return doctorMapper.getMyMenu(user_id,role_dept_id);
	}

	//将项目结算状态改为已退费
	@Override
	public boolean BalanceChange(int patient_project_id) {
		// TODO Auto-generated method stub
		return doctorMapper.BalanceChange(patient_project_id);
	}


	

}
