package xyz.cymedical.biz.jun;

import java.util.List;

import xyz.cymedical.entity.jun.CompanyFile;
import xyz.cymedical.entity.jun.Nurse;
import xyz.cymedical.entity.jun.Patient;
import xyz.cymedical.entity.xin.Combo;

/**
*	@author Junisyoan;
*	日期：2019年1月29日
*	时间：下午1:25:46
*	类说明：
*/
public interface NurseBiz {
	

	/**
	 * 打印导检单
	 * @param bid	记账表id
	 * @return	导检单列表
	 */
	public List<Patient> getCheckPage(String bid);
	
	/**
	 * 插入记账表和病人表之间的关系
	 * @param bid	记账表id
	 * @param pList	病人信息
	 * @return	是否插入成功
	 */
	public boolean insertRelation(int bid, List<Patient> pList);
	
	
	
	/**
	 * 查询套餐信息
	 * @param comboName	套餐名
	 * @return	套餐价格
	 */
	public Combo queryComboByName(String comboName);
	
	/**
	 * 查询待审核文件列表
	 * @param pageNum	页码
	 * @return	文件列表
	 */
	public List<CompanyFile> queryCheckFile(String pageNum);

	/**
	 * 登录查询
	 * @param account	账户
	 * @param pwd	密码
	 * @return	用户信息
	 */
	public Nurse queryNurseBylogin(String account, String pwd);
}
