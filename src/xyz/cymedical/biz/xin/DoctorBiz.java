package xyz.cymedical.biz.xin;

import java.util.List;
import java.util.Map;

import xyz.cymedical.entity.jiang.Tb_menu;
import xyz.cymedical.entity.jiang.Tb_user;


/**
* 2019年1月20日
* @author xin
* @version 1.0
*/

public interface DoctorBiz {
	
	/**
	 * 项目接收
	 * @param code	条码号
	 * @return	返回条码对应的病人所有已选项目
	 */
	public List<Map<String,Object>> findMyProject(String code);
	
	public List<Map<String,Object>> findMyDetail(int projectid,int patientid);
	
	//项目接收
	public boolean receive(int patient_project_id,int userid);

	//查找条码号对应病人的所有小结
	public List<Map<String, Object>> findAllDetail(String onecode);

	public boolean addsummarize(String advice, String guide);

	//找到插入总结的id
	public String findsumid();

	//登录
	public Tb_user login(String account, String pwd);

	//获取菜单列表
	public List<Tb_menu> getMyMenu(int user_id, int role_dept_id);

	//修改项目为已退费
	public boolean BalanceChange(int patient_project_id);


}
