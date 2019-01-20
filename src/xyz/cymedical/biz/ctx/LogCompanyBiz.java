package xyz.cymedical.biz.ctx;

import java.util.List;

import xyz.cymedical.entity.ctx.LogCompany;

/**
 * 2019年1月20日
 * 
 * @author ctx
 * @version 1.0
 */

public interface LogCompanyBiz {

	public List<LogCompany> queryByName(String name);

}
