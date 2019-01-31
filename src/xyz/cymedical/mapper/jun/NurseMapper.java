package xyz.cymedical.mapper.jun;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jun.CompanyFile;
import xyz.cymedical.entity.jun.Nurse;
import xyz.cymedical.entity.xin.Combo;

/**
*	@author Junisyoan;
*	日期：2019年1月29日
*	时间：下午1:27:34
*	类说明：体检工作站相关操作
*/

@Repository
public interface NurseMapper {

	//delete
	/**
	 * 扣除体检费用
	 * @param company_id	公司id
	 * @param price	总价格
	 * @return	是否扣除成功
	 */
	public boolean deductDeposit(@Param("company_id")String company_id,@Param("price")String price);
	
	
	
	//query
	/**
	 * 查询套餐
	 * @param comboName	套餐名
	 * @return	套餐信息
	 */
	public Combo queryComboByName(String comboName);
	
	/**
	 * 查询待审核文件列表
	 * @param pageNum 页码
	 * @return	文件列表
	 */
	public List<CompanyFile> queryCheckFile(int pageNum);
	
	/**
	 * 登录
	 * @param account	用户
	 * @param pwd	密码
	 * @return	用户信息
	 */
	public Nurse queryNurseByLogin(@Param("account")String account, @Param("pwd")String pwd);
}
