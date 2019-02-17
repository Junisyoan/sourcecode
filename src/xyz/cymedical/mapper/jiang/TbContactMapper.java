package xyz.cymedical.mapper.jiang;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jiang.Tb_contact;

@Repository
public interface TbContactMapper {
	
	public Tb_contact fornt();
	
	public int upcontact(Tb_contact tb_contact);

}
