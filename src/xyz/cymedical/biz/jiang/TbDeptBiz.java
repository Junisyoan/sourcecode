package xyz.cymedical.biz.jiang;

import java.util.List;

import xyz.cymedical.entity.jiang.Tb_dept;

public interface TbDeptBiz {
  
	public List<Tb_dept> selectDept();
	
	public int addDept(Tb_dept tb_dept);
	
	public int upDept(Tb_dept tb_dept);
	
	public  int delectDept(int dept_id);
	
	
}
