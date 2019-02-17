package xyz.cymedical.mapper.jiang;

import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jiang.Tb_msg;


@Repository
public interface TbMsgMapper {
	
	public int addmsg(Tb_msg tb_msg);/*门户留言*/
	
	public List<Tb_msg> selectmsg();/*后台查看留言*/

	
	public int deleteall(int id);/*批量删除*/
}
