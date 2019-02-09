package xyz.cymedical.biz.imp.jun;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jun.GroupBiz;
import xyz.cymedical.entity.jun.Group;
import xyz.cymedical.mapper.jun.GroupMapper;

/**
*	@author Junisyoan;
*	日期：2019年1月29日
*	时间：下午11:46:33
*	类说明：实现类
*/

@Service("groupBiz")
public class GroupBizImpl extends BaseImpl implements GroupBiz {

	@Resource
	private GroupMapper groupMapper;
	
	@Override
	public Group queryGroupByFileId(int fid) {
		return groupMapper.queryGroupByFileId(fid);
	}

	@Override
	public boolean updateGroupInfo(int fid, int pnum, float price) {
		if (groupMapper.updateGroupInfo(fid, pnum, price)>0) {
			isUpdate=true;
		}else {
			isUpdate=false;
		}
		return isUpdate;
	}

	@Override
	public boolean createGroup(int cid, int fid) {
		return groupMapper.insert(cid, fid);
	}

}
