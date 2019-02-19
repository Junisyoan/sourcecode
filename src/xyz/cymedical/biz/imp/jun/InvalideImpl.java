package xyz.cymedical.biz.imp.jun;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.cymedical.biz.jun.InvalideBiz;
import xyz.cymedical.entity.jun.CompanyFile;
import xyz.cymedical.entity.jun.Invalide;
import xyz.cymedical.mapper.jun.InvalideMapper;

/**
*	@author Junisyoan;
*	日期：2019年2月18日
*	时间：下午4:12:52
*	类说明：
*/

@Transactional(rollbackFor=Exception.class)
@Service("invalideBiz")
public class InvalideImpl extends BaseImpl implements InvalideBiz {

	
	@Resource
	private InvalideMapper invalideMapper;
	
	@Override
	public boolean insert(Invalide invalide) {
		return invalideMapper.insert(invalide);
	}

	@Override
	public boolean delete(int id) {
		System.out.println("删除不合格文件列表");
		return invalideMapper.delete(id);
	}

	@Override
	public List<CompanyFile> queryInvalide() {
		return invalideMapper.queryInvalide();
	}

	@Override
	public List<Invalide> queryInvalideByFileId(int id) {
		return invalideMapper.queryInvalideByFileId(id);
	}

}
