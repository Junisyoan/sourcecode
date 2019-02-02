package xyz.cymedical.biz.ctx;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.cymedical.entity.jun.Patient;

public interface PatientBiz {

	
	/**
	 * 批量插入病人数据
	 * @param listRecord	病人列表
	 * @return	是否插入成功
	 */
	public boolean insertByBatch(List<Patient> listRecord);
	
	public List<Patient> query(
			@Param("name") String name, 
			@Param("phone") String phone, 
			@Param("time") String time,
			@Param("code") String code);

}
