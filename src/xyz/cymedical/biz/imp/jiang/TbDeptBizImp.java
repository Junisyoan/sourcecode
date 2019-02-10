package xyz.cymedical.biz.imp.jiang;

import java.util.List;

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

	
}
