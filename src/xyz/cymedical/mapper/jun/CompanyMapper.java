package xyz.cymedical.mapper.jun;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jun.Company;

/**
* 2019年1月19日
* @author Junisyoan
* @version 1.0
*/

@Repository
public interface CompanyMapper {

	//query
	
	/**
	 * 公司信息
	 * @param account	账户
	 * @param pwd	密码
	 * @return	公司信息
	 */
	public Company queryCompanyByLogin(@Param("account")String account, @Param("pwd")String pwd);
	
	/**
	 *	查询公司座机号 
	 * @param tel	座机号
	 * @return	公司信息
	 */
	public Company queryCompanyByTel(String tel);
	
	/**
	 * 查询公司是否存在
	 * @param name	公司名
	 * @return	是否存在
	 */
	public Company queryCompanyByName(String name);
	
	/**
	 * 按照账户查询公司
	 * @param account	账户
	 * @return	公司信息
	 */
	public Company queryCompanyByAccount(String account);
	
	
	
	//insert
	
	/**
	 * 公司注册
	 * @param company	公司信息
	 * @return	是否注册成功
	 */
	public boolean insertCompany(Company company);
}
