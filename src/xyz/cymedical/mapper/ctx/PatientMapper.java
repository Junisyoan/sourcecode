package xyz.cymedical.mapper.ctx;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientMapper {

	public List<Patient> query(@Param("name") String name, @Param("phone") String phone, @Param("time") String time,
			@Param("check_num") String check_num);

}
