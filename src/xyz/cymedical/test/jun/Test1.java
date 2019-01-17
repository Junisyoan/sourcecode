package xyz.cymedical.test.jun;
import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
*	@author Junisyoan;
*	日期：2019年1月17日
*	时间：上午11:08:20
*	类说明：
*/
public class Test1 {

//	@Resource
//	private UserBiz userBiz;
//	
//	@Test
//	public void Test0() {
//		
//	}
	
	
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(applicationContext);
		
		System.out.println("org.springframework.context.support.ClassPathXmlApplicationContext@694f9431, started on Thu Jan 17 15:12:58 CST 2019");
		
	}
}
