package xyz.cymedical.mapper.jun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jun.CompanyFile;
import xyz.cymedical.entity.jun.Nurse;
import xyz.cymedical.entity.jun.Patient;
import xyz.cymedical.entity.xin.Combo;
import xyz.cymedical.entity.xin.News;
import xyz.cymedical.entity.zsc.Detail;
import xyz.cymedical.entity.zsc.Project;

/**
*	@author Junisyoan;
*	日期：2019年1月29日
*	时间：下午1:27:34
*	类说明：体检工作站相关操作
*/

@Repository
public interface NurseMapper {
	
	//insert
	/**
	 * 创建体检人套餐关系表
	 * @param patients	体检人列表
	 * @return	是否成功
	 */
	public int insertPaitentCombo(
			@Param("bid")int bid,
			@Param("pList")List<Patient> pList);
	
	/**
	 * 批量插入记账病人关系表
	 * @param bid
	 * @param pList
	 * @return
	 */
	public int insertBatchRelation(
			@Param("bid")int bid, 
			@Param("pList")List<Patient> pList);

	//query
	
	/**
	 * 打印导检单
	 * @param bid	记账表id
	 * @return	导检单列表
	 */
	public List<Patient> getCheckPage(String bid);
	
	/**
	 * 查询套餐
	 * @param comboName	套餐名
	 * @return	套餐信息
	 */
	public Combo queryComboByName(String comboName);
	
	/**
	 * 查询待审核文件列表
	 * @return	文件列表
	 */
	public List<CompanyFile> queryCheckFile(String state);
	
	/**
	 * 登录
	 * @param account	用户
	 * @param pwd	密码
	 * @return	用户信息
	 */
	public Nurse queryNurseByLogin(@Param("account")String account, @Param("pwd")String pwd);

	
	//查找所有新闻
	public ArrayList<News> findAllNews();

	//条件查询
	public List<News> searchNews(Map<String, Object> map);

	//添加
	public boolean addNews(News news);

	//id找新闻
	public News findMyNews(int newsid);

	//新闻修改
	public boolean updateNews(News news);

	//id删新闻
	public boolean delNews(String newsid);

	//comboname找项目
	public List<Project> findMyProject(String comboname);

	//插入病人项目表
	public void insertPaitentProject(String ID, int project_id);

	//项目id找细项
	public List<Detail> findMyDetail(int project_id);

	//插入小结表
	public boolean insertbrief(int detail_id, String ID, String time,int project_id);
}
