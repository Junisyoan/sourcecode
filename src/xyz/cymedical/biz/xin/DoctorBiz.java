package xyz.cymedical.biz.xin;

import java.util.List;
import java.util.Map;

import xyz.cymedical.entity.jun.Company;
import xyz.cymedical.entity.zsc.Detail;

/**
* 2019年1月20日
* @author xin
* @version 1.0
*/

public interface DoctorBiz {
	
	/**
	 * 项目接收
	 * @param code	条码号
	 * @return	返回条码对应的病人所有已选项目
	 */
	public List<Map<String,Object>> findMyProject(String code);
	
	public List<Map<String,Object>> findMyDetail(int projectid,int patientid);
	
	//项目接收
	public boolean receive(int patient_project_id);

}
