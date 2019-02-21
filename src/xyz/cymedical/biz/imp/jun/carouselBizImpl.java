package xyz.cymedical.biz.imp.jun;

import org.springframework.stereotype.Service;

import xyz.cymedical.biz.jun.carouselBiz;

/**
*	@author Junisyoan;
*	日期：2019年2月21日
*	时间：上午11:14:22
*	类说明：
*/

@Service("carouselBiz")
public class carouselBizImpl extends BaseImpl implements carouselBiz {

	@Override
	public boolean addCarousel(String content, String name, String path, String time, String state) {
		return false;
	}

	@Override
	public boolean delCarousel(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCarousel(String id, String content) {
		// TODO Auto-generated method stub
		return false;
	}

}
