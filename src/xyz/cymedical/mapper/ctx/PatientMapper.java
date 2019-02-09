package xyz.cymedical.mapper.ctx;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jun.Patient;

@Repository
public interface PatientMapper {

	/**
	 * 插入体检人员
	 * 
	 * @param patient 体检人员信息
	 * @return 是否插入成功
	 */
	public boolean insertPatient(Patient patient);

	/**
	 * 更新体检人员信息
	 * 
	 * @param patient 体检人员信息
	 * @return 是否更改成功
	 */
//	public boolean updataPatient(Patient patient);

	/**
	 * 查询体检人员
	 * 
	 * @param IDcard 身份证
	 * @return 是否存在
	 */
	public Patient queryPatient(String IDcard);

	/**
	 * 批量插入数据
	 * 
	 * @param listRecord 列表记录
	 * @return 插入了几条
	 */
	public int insertByBatch(@Param("listRecord") List<Patient> listRecord);

	public List<Patient> query(@Param("name") String name, @Param("phone") String phone, @Param("time") String time,
			@Param("code") String code);

	public List<Patient> queryproject(@Param("name") String name, @Param("time") String time);
	
	public List<Patient> querybrief(@Param("name") String name, @Param("time") String time);

}
