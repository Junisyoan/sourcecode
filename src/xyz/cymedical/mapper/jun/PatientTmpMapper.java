package xyz.cymedical.mapper.jun;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jun.Patient;
import xyz.cymedical.entity.jun.PatientTmp;

/**
*	@author Junisyoan;
*	日期：2019年2月21日
*	时间：下午3:56:42
*	类说明：
*/

@Repository
public interface PatientTmpMapper {

	public int insertPatientTmp(@Param("patientList")List<PatientTmp> patientList);
	public List<PatientTmp> queryByhcode(String hcode);
	public List<PatientTmp> queryByBillerId(String bid);
	public boolean delByBillerId(String bid);
}
