package xyz.cymedical.mapper.xin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jun.Company;
import xyz.cymedical.entity.xin.Detail;

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
	public List<Detail> findMyDetails(String code);
}
