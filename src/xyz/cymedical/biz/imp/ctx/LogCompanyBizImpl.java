package xyz.cymedical.biz.imp.ctx;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.ctx.LogCompanyBiz;
import xyz.cymedical.entity.ctx.LogCompany;
import xyz.cymedical.mapper.ctx.LogCompanyMapper;

/**
 * 2019年1月20日
 * 
 * @author ctx
 * @version 1.0
 */

@Service("logCompanyBiz")
public class LogCompanyBizImpl implements LogCompanyBiz {

	@Resource
	private LogCompanyMapper logCompanyMapper;

	@Override
	public List<LogCompany> queryByName(String name) {
		return logCompanyMapper.queryByName(name);
	}

	@Override
	public boolean insertLog(int cid, String op, String deposit, String t) {
		return logCompanyMapper.insertLog(cid, op, deposit, t);
	}

}
