package xyz.cymedical.mapper.jun;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
*	@author Junisyoan;
*	日期：2019年2月21日
*	时间：上午11:18:24
*	类说明：
*/


@Repository
public interface CarouselMapper {

	public boolean addCarousel(
			@Param("content")String content,
			@Param("name")String name,
			@Param("path")String path,
			@Param("time")String time,
			@Param("state")String state);
	public boolean delCarousel(String id);
	public boolean updateCarousel(String id,String content);
}
