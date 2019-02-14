package xyz.cymedical.biz.imp.jun;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.cymedical.biz.jun.GroupBiz;
import xyz.cymedical.entity.jun.Group;
import xyz.cymedical.mapper.jun.GroupMapper;

/**
*	@author Junisyoan;
*	日期：2019年1月29日
*	时间：下午11:46:33
*	类说明：实现类
*/

@Transactional(rollbackFor=Exception.class)
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
		Group group = new Group();
		group.setCompany_id(cid);
		//创建团检表
		isUpdate = groupMapper.insert(group);
		System.out.println(group.getGroup_id());
		if (isUpdate) {
			//创建关联表
			isUpdate = groupMapper.insertFileGroup(fid, group.getGroup_id());
			if (isUpdate) {
				System.out.println("关联表创建成功");
			} else {
				System.out.println("关联表创建失败");
			}
		}
		return isUpdate;
	}

}
