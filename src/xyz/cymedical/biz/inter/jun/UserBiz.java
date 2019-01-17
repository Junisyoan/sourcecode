package xyz.cymedical.biz.inter.jun;


import java.util.List;

import xyz.cymedical.entity.jun.User;


public interface UserBiz {

	/** 
	* @Description: TODO(鐢ㄤ竴鍙ヨ瘽鎻忚堪璇ユ枃浠跺仛浠�涔�) 
	* @author Junisyoan  
	* @date 2019骞�1鏈�12鏃� 涓婂崍10:56:18 
	* @version V1.0   
	*/
	
	public User queryByLogin(User user);

	public boolean queryAccount(String account);

	public boolean addUser(User user);

	public List<User> queryUserList(int pageNum);
				
	public int queryUserCount();

	public boolean updateUser(User user);

	public boolean delUser(int user_id);
}
