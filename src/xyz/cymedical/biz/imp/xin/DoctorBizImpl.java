package xyz.cymedical.biz.imp.xin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jun.CompanyBiz;
import xyz.cymedical.biz.xin.DoctorBiz;
import xyz.cymedical.entity.jun.Company;
import xyz.cymedical.entity.xin.Detail;
import xyz.cymedical.mapper.jun.CompanyMapper;
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
	public List<Detail> findMyDetails(String code) {
		// TODO Auto-generated method stub
		return doctorMapper.findMyDetails(code);
	}
	

}
