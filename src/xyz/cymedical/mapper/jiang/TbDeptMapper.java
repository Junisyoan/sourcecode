package xyz.cymedical.mapper.jiang;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jiang.Tb_dept;

@Repository
public interface TbDeptMapper {

	public List<Tb_dept> selectDept();
	
	public List<Map<String, Object>>  select(String sta);
	
	public int addDept(Tb_dept tb_dept);
	
	public int upDept(Tb_dept tb_dept);

	public  int delectDept(int dept_id);
	
	public List<Map<String,Object>> selectCompany(Map<String, Object> map);  
	
	public List<Tb_dept> selectDeptname(Tb_dept tb_dept);/*查询新添加的部门名是否存在*/
	
	public Tb_dept selectDeptnameid(Tb_dept tb_dept);/*回查新添加的id号*/
	
	

}
