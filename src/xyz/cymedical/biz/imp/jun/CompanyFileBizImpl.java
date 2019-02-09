package xyz.cymedical.biz.imp.jun;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jun.CompanyFileBiz;
import xyz.cymedical.entity.jun.CompanyFile;
import xyz.cymedical.mapper.jun.CompanyFileMapper;

/**
*	@author Junisyoan;
*	日期：2019年1月22日
*	时间：上午11:32:16
*	类说明：
*/
@Service("companyFileBiz")
public class CompanyFileBizImpl extends BaseImpl implements CompanyFileBiz {

	@Resource
	private CompanyFileMapper companyFileMapper;
	
	@Override
	public boolean insertFile(CompanyFile file) {
		System.out.println("文件插入数据库"+file);
		return companyFileMapper.insertFile(file);
	}

	@Override
	public List<CompanyFile> queryFileList(String pageNum) {
		pageNo = Integer.parseInt(pageNum);
		pageNo=(pageNo-1)*10;
		List<CompanyFile> list = companyFileMapper.queryFileList(pageNo);
		System.out.println(list);
		return list;
	}

	@Override
	public CompanyFile queryFile(String file_id) {
		return companyFileMapper.queryFileById(file_id);
	}

	@Override
	public boolean updateFileState(int fid) {
		return companyFileMapper.updateFileState(fid);
	}

	@Override
	public List<CompanyFile> queryPassFileList() {
		return companyFileMapper.queryPassFileList();
	}

	@Override
	public CompanyFile queryFileByBillerId(String bid) {
		return companyFileMapper.queryFileByBillerId(bid);
	}

}
