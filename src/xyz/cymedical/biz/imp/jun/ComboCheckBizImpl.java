package xyz.cymedical.biz.imp.jun;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.cymedical.biz.jun.ComboCheckBiz;
import xyz.cymedical.mapper.jun.ComboCheckMapper;

/**
*	@author Junisyoan;
*	日期：2019年1月27日
*	时间：下午10:18:12
*	类说明：
*/
@Transactional(rollbackFor=Exception.class)
@Service("comboCheckBiz")
public class ComboCheckBizImpl extends BaseImpl implements ComboCheckBiz {

	@Resource
	private ComboCheckMapper comboCheckMapper;
	
	@Override
	public boolean queryCombo(String comboName) {
		if (comboCheckMapper.queryComboByName(comboName)!=null) {
			isExsit=true;
		} else {
			isExsit=false;
		}
		return isExsit;
	}

}
