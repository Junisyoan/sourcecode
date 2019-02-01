package xyz.cymedical.biz.xin;

import java.util.List;
import java.util.Map;


/**
* 2019年1月30日
* @author xin
* @version 1.0
*/

public interface BriefBiz {
	
	/**
	 * 项目小结
	 * @param 
	 * @return	
//	 */
	
	public boolean Normal(String result,String id);
	
	public boolean Photo(String result,String path,String id);
	
	public boolean Check(String result,String tips,String id);



}
