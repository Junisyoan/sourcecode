package xyz.cymedical.mapper.jun;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.ctx.LogCompany;
import xyz.cymedical.entity.jun.Company;

/**
* 2019年1月19日
* @author Junisyoan
* @version 1.0
*/

@Repository
public interface CompanyMapper {

	//delete
	/**
	 * 删除文件，团检关系表数据
	 * @param file_id	文件id
	 * @return	是否删除成功
	 */
	public boolean delFile(String file_id);
	
	/**
	 * 扣除体检费用
	 * @param company_id 公司id
	 * @param price      总价格
	 * @return 是否扣除成功
	 */
	public boolean deductDeposit(
			@Param("company_id")String company_id,
			@Param("price")String price);
	
	//query
	/**
	 * 查询余额
	 * @param id	公司id
	 * @return	余额
	 */
	public float queryDepositByCompanyId(int id);
	
	/**
	 * 查询公司信息
	 * @param id	公司id
	 * @return	公司信息
	 */
	public Company queryCompanyById(int id);
	
	/**
	 * 查询资金明细列表
	 * @return	资金明细列表
	 */
	public List<LogCompany> queryDepositList(String company_id);
	
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
	
	//update
	
	/**
	 * 充值
	 * @param deposit	金额
	 * @return	是否充值成功
	 */
	public boolean updateDeposit(
			@Param("deposit")float deposit,
			@Param("company_id")int company_id);
	
	//insert
	
	/**
	 * 公司注册
	 * @param company	公司信息
	 * @return	是否注册成功
	 */
	public boolean insertCompany(Company company);
	
	/**
	 * 按照账户查询公司
	 * @param account	账户
	 * @return	公司信息
	 */
	public List<Company> queryByAccount(String account);
}
