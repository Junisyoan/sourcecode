package xyz.cymedical.mapper.jun;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.xin.Combo;

/**
*	@author Junisyoan;
*	日期：2019年1月27日
*	时间：下午10:19:09
*	类说明：套餐类接口
*/

@Repository
public interface ComboCheckMapper {

	//query
	/**
	 * 查询套餐
	 * @param name	套餐名
	 * @return	套餐信息
	 */
	public Combo queryComboByName(String name);
}
