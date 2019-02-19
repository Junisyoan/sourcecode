package xyz.cymedical.biz.imp.jiang;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jiang.TbRoleDept;
import xyz.cymedical.entity.jiang.Tb_role_dept;
import xyz.cymedical.mapper.jiang.TbRoleDeptMapper;

@Service("tbRoleDept")
public class TbRoleDeptBizImp implements TbRoleDept{

	@Resource
	TbRoleDeptMapper tbRoleDeptMapper;
	
	@Override
	public List<Tb_role_dept> findroledeptid(int role_dept_id) {
		return tbRoleDeptMapper.findroledeptid(role_dept_id);
	}

	@Override
	public List<Tb_role_dept> selectroledeptid(int dept_id) {
		// TODO Auto-generated method stub
		return tbRoleDeptMapper.selectroledeptid(dept_id);
	}

	@Override
	public int deleteroledept(int dept_id) {
		// TODO Auto-generated method stub
		return tbRoleDeptMapper.deleteroledept(dept_id);
	}

	@Override
	public int deletelogic(Tb_role_dept tb_role_dept) {
		// TODO Auto-generated method stub
		return tbRoleDeptMapper.deletelogic(tb_role_dept);
	}

	@Override
	public int addroledept(Tb_role_dept tb_role_dept) {
		// TODO Auto-generated method stub
		return tbRoleDeptMapper.addroledept(tb_role_dept);
	}

 

}
