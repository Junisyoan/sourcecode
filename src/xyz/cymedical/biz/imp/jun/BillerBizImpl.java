package xyz.cymedical.biz.imp.jun;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jun.BillerBiz;
import xyz.cymedical.entity.jun.Biller;
import xyz.cymedical.mapper.jun.BillerMapper;

/**
*	@author Junisyoan;
*	日期：2019年1月31日
*	时间：下午1:36:56
*	类说明：
*/

@Service("billerBiz")
public class BillerBizImpl extends BaseImpl implements BillerBiz {

	@Resource
	private BillerMapper billerMapper;
	
	@Override
	public boolean insertBiller(int gid, String bstate, String batch, String btime) {
		return billerMapper.insertBiller(gid, bstate, batch, btime);
	}

	@Override
	public Biller queryBiller(int gid, String time) {
		return billerMapper.queryBiller(gid, time);
	}

}
