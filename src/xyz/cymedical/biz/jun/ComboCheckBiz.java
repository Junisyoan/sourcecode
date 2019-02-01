package xyz.cymedical.biz.jun;


/**
*	@author Junisyoan;
*	日期：2019年1月27日
*	时间：下午10:14:46
*	类说明：
*/
public interface ComboCheckBiz {

	//query
	/**
	 * 查询套餐名称
	 * @param comboName	套餐名称
	 * @return	是否存在这个套餐
	 */
	public boolean queryCombo(String comboName);
}
