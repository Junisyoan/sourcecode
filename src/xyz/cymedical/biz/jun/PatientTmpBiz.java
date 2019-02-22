package xyz.cymedical.biz.jun;

import java.util.List;

import xyz.cymedical.entity.jun.PatientTmp;

/**
*	@author Junisyoan;
*	日期：2019年2月21日
*	时间：下午3:53:25
*	类说明：
*/
public interface PatientTmpBiz {

	public boolean insert(List<PatientTmp> patients);
	public List<PatientTmp> queryByhcode(String hcode);
	public List<PatientTmp> queryByBillerId(String bid);
	public boolean del(String bid);
}
