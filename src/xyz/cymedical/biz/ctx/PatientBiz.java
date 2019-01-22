package xyz.cymedical.biz.ctx;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.cymedical.entity.jun.Patient;

public interface PatientBiz {

	public List<Patient> query(@Param("name") String name, @Param("phone") String phone, @Param("time") String time,
			@Param("code") String code);

}
