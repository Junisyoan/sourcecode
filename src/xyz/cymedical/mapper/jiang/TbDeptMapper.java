package xyz.cymedical.mapper.jiang;

import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jiang.Tb_dept;

@Repository
public interface TbDeptMapper {

	public List<Tb_dept> selectDept();
}
