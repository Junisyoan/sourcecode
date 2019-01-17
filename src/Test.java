import javax.annotation.Resource;

import xyz.cymedical.biz.inter.jun.UserBiz;

/**
*	@author Junisyoan;
*	日期：2019年1月17日
*	时间：上午11:08:20
*	类说明：
*/
public class Test {

	@Resource
	private UserBiz userBiz;
	
	@org.junit.Test
	public void test() {
		System.out.println(userBiz.queryUserCount());
	}
}
