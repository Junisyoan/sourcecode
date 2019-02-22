package xyz.cymedical.biz.jun;

import org.springframework.stereotype.Repository;

/**
*	@author Junisyoan;
*	日期：2019年2月21日
*	时间：上午11:12:10
*	类说明：
*/


public interface carouselBiz {
	
	public boolean addCarousel(String content,String name,String path,String time,String state);
	public boolean delCarousel(String id);
	public boolean updateCarousel(String id,String content);
}
