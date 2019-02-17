package xyz.cymedical.biz.imp.jiang;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jiang.TbMsgBiz;
import xyz.cymedical.entity.jiang.Tb_msg;
import xyz.cymedical.mapper.jiang.TbMsgMapper;


@Service("tbMsgBiz")
public class TbMsgBizImp implements TbMsgBiz{

	@Resource
	TbMsgMapper tbMsgMapper;
	
	@Override
	public int addmsg(Tb_msg tb_msg) {
		// TODO Auto-generated method stub
		return tbMsgMapper.addmsg(tb_msg);
	}

	@Override
	public List<Tb_msg> selectmsg() {
		// TODO Auto-generated method stub
		return tbMsgMapper.selectmsg();
	}

	@Override
	public int deleteall(int id) {
		// TODO Auto-generated method stub
		return tbMsgMapper.deleteall(id);
	}

	@Override
	public int upstate(Tb_msg tb_msg) {
		// TODO Auto-generated method stub
		return tbMsgMapper.upstate(tb_msg);
	}

}
