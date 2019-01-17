package xyz.cymedical.mapper.jun;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jun.User;

@Repository
public interface UserMapper{
	
	/**
	 * 鐧诲綍鏌ヨ
	 * @param user	鐢ㄦ埛
	 * @param return 鐢ㄦ埛
	 */
	public User queryByLogin(User user);
	
	/**
	 * 	鏌ヨ璐︽埛
	 * @param account	璐︽埛
	 * @return	鏄惁瀛樺湪
	 */
	public User queryAccount(String account);
	
	/**
	 * 	娣诲姞鐢ㄦ埛
	 * @param user 鐢ㄦ埛
	 * @return	鏄惁澧炲姞鎴愬姛
	 */
	public boolean addUser(User user);
	
	/**
	 * 	鏌ヨ鐢ㄦ埛鍒楄〃
	 * @param pageNum	椤电爜
	 * @return	鐢ㄦ埛鍒楄〃
	 */
	public List<User> queryUserList(@Param("firstRecord")int firstRecord, @Param("lastRecord")int lastRec);
	
	/**
	 * 	鏌ヨ鐢ㄦ埛鏁伴噺
	 * @return	鐢ㄦ埛鏁伴噺
	 */
	public int queryUserCount();
	
	/**
	 * 	鏇存敼鐢ㄦ埛鏂�
	 * @param user	鐢ㄦ埛
	 * @return	鏄惁鏇存敼鎴愬姛
	 */
	public boolean updateUser(User user);
	
	/**
	 * 	鍒犻櫎鐢ㄦ埛
	 * @param user_id	鐢ㄦ埛id
	 * @return	鏄惁鍒犻櫎鎴愬姛
	 */
	public boolean delUser(int user_id);
	
}
