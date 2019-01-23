package xyz.cymedical.mapper.xin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jun.Company;
import xyz.cymedical.entity.zsc.Detail;

/**
* 2019年1月19日
* @author Junisyoan
* @version 1.0
*/

@Repository
public interface DoctorMapper {

	//query
	
	/**
	 * 细项信息
	 * @param code	条码号
	 * @return	细项列表
	 */
	//项目接收
	public boolean receive(int patient_project_id);

	//获取项目列表
	public List<Map<String,Object>> findMyProject(String onecode);

	//项目细项
	public List<Map<String, Object>> findMyDetail(int projectid,int patientid);
}
