package xyz.cymedical.biz.jiang;

import java.util.List;
import java.util.Map;

import xyz.cymedical.entity.jiang.Tb_dept;

public interface TbDeptBiz {
  
	public List<Tb_dept> selectDept();
	
	public List<Tb_dept> selectDeptname(Tb_dept tb_dept);/*查询新添加的部门名是否存在*/
	
	public Tb_dept selectDeptnameid(Tb_dept tb_dept);/*回查新添加的id号*/
	
	public List<Map<String, Object>>  select(String sta);/*新版查询 带状态*/
	
	public int addDept(Tb_dept tb_dept);
	
	public int upDept(Tb_dept tb_dept);
	
	public  int delectDept(int dept_id);
	
	public List<Map<String,Object>> selectCompany(Map<String, Object> map);  
	
	
}
