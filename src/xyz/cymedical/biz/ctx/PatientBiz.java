package xyz.cymedical.biz.ctx;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.cymedical.entity.jun.Patient;

public interface PatientBiz {

	/**
	 * 批量插入病人数据
	 * 
	 * @param listRecord 病人列表
	 * @return 是否成功
	 */
	public List<Patient> insertByBatch(List<Patient> listRecord);

	public List<Patient> query(@Param("name") String name, @Param("phone") String phone, @Param("time") String time,
			@Param("code") String code);

	public List<Patient> queryproject(@Param("name") String name, @Param("time") String time);
	
	public List<Patient> querybrief(@Param("name") String name, @Param("time") String time);

}
