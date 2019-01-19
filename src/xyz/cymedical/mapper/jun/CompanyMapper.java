package xyz.cymedical.mapper.jun;

import xyz.cymedical.entity.jun.Company;

/**
* 2019年1月19日
* @author Junisyoan
* @version 1.0
*/
public interface CompanyMapper {

	//query
	
	/**
	 * 查询公司是否存在
	 * @param company	公司信息
	 * @return	是否存在
	 */
	public Company queryCompanyByName(Company company);
	
	
	//insert
	/**
	 * 公司注册
	 * @param company	公司信息
	 * @return	是否注册成功
	 */
	public boolean insertCompany(Company company);
}
