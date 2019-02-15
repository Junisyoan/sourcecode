package xyz.cymedical.mapper.xin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jiang.Tb_menu;
import xyz.cymedical.entity.jiang.Tb_user;
import xyz.cymedical.entity.xin.Summarize;

/**
* 2019年1月30日
* @author xin
* @version 1.0
*/

@Repository
public interface DoctorMapper {

	//query
	
	/**
	 * 细项信息
	 * @param code	条码号
	 * @return	细项列表
	 */
	//项目接收
	public boolean receive(int patient_project_id,int userid);

	//获取项目列表
	public List<Map<String,Object>> findMyProject(String onecode);

	//项目细项
	public List<Map<String, Object>> findMyDetail(int projectid,int patientid);

	//获取条码对应病人所有小结
	public List<Map<String, Object>> findAllDetail(String onecode);

	//添加总结
	public boolean addsummarize(String advice, String guide);

	//找到插入总结的id
	public String findsumid();

	//登录
	public Tb_user login(String account, String pwd);

	//获取用户菜单
	public List<Tb_menu> getMyMenu(int user_id, int role_dept_id);

	//修改项目状态为已退费
	public boolean BalanceChange(int patient_project_id);

	//根据角色部门id查找身份
	public String getStatus(int role_dept_id);

	//根据id找总结
	public Summarize findMySummarize(int sumid);
}
