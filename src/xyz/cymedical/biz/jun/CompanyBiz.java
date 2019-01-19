package xyz.cymedical.biz.jun;

import xyz.cymedical.entity.jun.Company;

/**
* 2019年1月19日
* @author Junisyoan
* @version 1.0
*/

public interface CompanyBiz {

	/**
	 * 公司注册
	 * @param company	公司信息
	 * @return	返回已被注册、注册成功、注册失败
	 */
	public String regCompany(Company company);
}
