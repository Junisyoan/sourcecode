import javax.annotation.Resource;

import xyz.cymedical.biz.impl.jun.UserBizImpl;
import xyz.cymedical.biz.inter.jun.UserBiz;

/**
*	@author Junisyoan;
*	���ڣ�2019��1��17��
*	ʱ�䣺����11:08:20
*	��˵����
*/
public class Test {

	@Resource
	private UserBiz userBiz = new UserBizImpl();
	
	@org.junit.Test
	public void test() {
		System.out.println(userBiz.queryUserCount());
	}
}
