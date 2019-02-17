package xyz.cymedical.handle.jun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
*	@author Junisyoan;
*	日期：2019年2月15日
*	时间：下午1:53:43
*	类说明：门户页面数据的获取
*/

@Controller
@RequestMapping("/jiang")
public class IndexAction {

	
	
	@RequestMapping(value="/get.so",method=RequestMethod.GET)
	public @ResponseBody String get() {
		
		return null;
	}
	
}
