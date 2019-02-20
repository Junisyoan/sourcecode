package xyz.cymedical.biz.imp.jiang;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jiang.TbDeptBiz;
import xyz.cymedical.entity.jiang.Tb_dept;
import xyz.cymedical.mapper.jiang.TbDeptMapper;

@Service("tbDeptBiz")
public class TbDeptBizImp implements  TbDeptBiz{

	@Resource
	TbDeptMapper tbDeptMapper;
	
	
	@Override
	public List<Tb_dept> selectDept() {
		// TODO Auto-generated method stub
		return tbDeptMapper.selectDept();
	}


	@Override
	public int addDept(Tb_dept tb_dept) {
		// TODO Auto-generated method stub
		return tbDeptMapper.addDept(tb_dept);
	}


	@Override
	public int upDept(Tb_dept tb_dept) {
		// TODO Auto-generated method stub
		return tbDeptMapper.upDept(tb_dept);
	}


	@Override
	public int delectDept(int dept_id) {
		// TODO Auto-generated method stub
		return tbDeptMapper.delectDept(dept_id);
	}


	@Override
	public List<Map<String, Object>> selectCompany(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return tbDeptMapper.selectCompany(map);
	}


	@Override
	public List<Map<String, Object>> select(String sta) {
		// TODO Auto-generated method stub
		return tbDeptMapper.select(sta);
	}


	@Override
	public List<Tb_dept> selectDeptname(Tb_dept tb_dept) {
		// TODO Auto-generated method stub
		return tbDeptMapper.selectDeptname(tb_dept);
	}


	@Override
	public Tb_dept selectDeptnameid(Tb_dept tb_dept) {
		// TODO Auto-generated method stub
		return tbDeptMapper.selectDeptnameid(tb_dept);
	}

	
}
