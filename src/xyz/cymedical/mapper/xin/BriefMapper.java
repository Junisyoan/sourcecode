package xyz.cymedical.mapper.xin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
* 2019年1月30日
* @author xin
* @version 1.0
*/

@Repository
public interface BriefMapper {

	//query
	
	/**
	 * 细项信息
	 * @param code	条码号
	 * @return	细项列表
	 */
	

	//普通小结
	public boolean Normal(String result, String id);
	//影像小结
	public boolean Photo(String result,String path,String id);
	//检验小结
	public boolean Check(String result, String tips, String id);
	//为小结添加总结
	public boolean addsummarize(int briefid, String sumid);

}
