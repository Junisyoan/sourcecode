package xyz.cymedical.biz.imp.jiang;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jiang.TbContactBiz;
import xyz.cymedical.entity.jiang.Tb_contact;
import xyz.cymedical.mapper.jiang.TbContactMapper;


@Service("tbContactBiz")
public class TbContactBizImp implements TbContactBiz{
	 
	@Resource TbContactMapper tbContactMapper;
	
	@Override
	public Tb_contact fornt() {
		// TODO Auto-generated method stub
		return tbContactMapper.fornt();
	}

	@Override
	public int upcontact(Tb_contact tb_contact) {
		// TODO Auto-generated method stub
		return tbContactMapper.upcontact(tb_contact);
	}

}
