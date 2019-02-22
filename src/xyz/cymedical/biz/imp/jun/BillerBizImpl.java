package xyz.cymedical.biz.imp.jun;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.cymedical.biz.jun.BillerBiz;
import xyz.cymedical.entity.jun.Biller;
import xyz.cymedical.mapper.jun.BillerMapper;

/**
*	@author Junisyoan;
*	日期：2019年1月31日
*	时间：下午1:36:56
*	类说明：
*/
@Transactional(rollbackFor=Exception.class)
@Service("billerBiz")
public class BillerBizImpl extends BaseImpl implements BillerBiz {

	@Resource
	private BillerMapper billerMapper;
	
	@Override
	public Biller insertBiller(Biller biller) {
		int i = billerMapper.insertBiller(biller);
		System.out.println(biller.getBiller_id());
		return biller;
	}

	@Override
	public Biller queryBiller(int gid, String batch) {
		return billerMapper.queryBiller(gid, batch);
	}

	@Override
	public boolean delBiller(String bid) {
		return billerMapper.delBiller(bid);
	}

	@Override
	public boolean payBiller(String bid,String bstate, String btime) {
		return billerMapper.payBiller(bid, bstate, btime);
	}

	@Override
	public List<Biller> queryCompanyBillerList(String bstate,int cid) {
		return billerMapper.queryCompanyBillerList(bstate,cid);
	}

	@Override
	public List<Biller> queryBillerListByCreate(String bcreat) {
		return billerMapper.queryBillerListByCreate(bcreat);
	}

	@Override
	public boolean updateBillerCreate(String bid) {
		System.out.println("修改账单状态");
		if (billerMapper.updateBillerCreate(bid)) {
			isUpdate=true;
			System.out.println("账单状态修改成功");
		} else {
			isUpdate=false;
			System.out.println("账单状态修改失败");
		}
		return isUpdate;
	}

	@Override
	public List<Biller> queryBillerList(String bstate) {
		return billerMapper.queryBillerList(bstate);
	}

	@Override
	public List<Biller> getReceipt(int bid) {
		System.out.println("打印发票没写");
		return null;
	}

	@Override
	public Biller query(int bid) {
		return billerMapper.query(bid);
	}

}
