package xyz.cymedical.biz.jiang;

import java.util.List;

import xyz.cymedical.entity.jiang.Tb_msg;

public interface TbMsgBiz {
	
	public int addmsg(Tb_msg tb_msg);/*门户端客户留言*/
	
	public List<Tb_msg> selectmsg();
	
	public int deleteall(int id);/*批量删除*/
	
	public int upstate(Tb_msg tb_msg);/*改变未读状态*/

}
