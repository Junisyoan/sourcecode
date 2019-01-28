package xyz.cymedical.biz.jun;

import java.util.List;

import xyz.cymedical.entity.ctx.LogCompany;
import xyz.cymedical.entity.jun.Company;

/**
* 2019年1月19日
* @author Junisyoan
* @version 1.0
*/

public interface CompanyBiz {

	
	/**
	 * 存钱
	 * @param deposit	金额
	 * @return	是否存入
	 */
//	public boolean insertDeposit(String deposit);
	
	/**
	 * 查询资金明细
	 * @return	资金明细列表
	 */
	public List<LogCompany> queryDepositList(String c_id);
	
	/**
	 * 删除文件
	 * @param file_id	文件id
	 * @return	是否删除成功
	 */
	public boolean delCompanyFile(String file_id);
	
	/**
	 * 登录
	 * @param account	用户
	 * @param pwd	密码
	 * @return	公司信息
	 */
	public Company companyLogin(String account,String pwd);
	
	/**
	 * 公司注册
	 * @param company	公司信息
	 * @return	返回已被注册、注册成功、注册失败
	 */
	public String regCompany(Company company);
	
	/**
	 * 查询公司名字
	 * @param name	公司名字
	 * @return	是否存在
	 */
	public boolean queryName(String name);
	
	/**
	 * 查询账户是否存在
	 * @param account	账户
	 * @return	是否存在
	 */
	public boolean queryAccount(String account);
	
	/**
	 * 查询公司座机号
	 * @param tel	座机号
	 * @return	是否存在
	 */
	public boolean queryTel(String tel);
}
