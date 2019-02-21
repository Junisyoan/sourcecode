package xyz.cymedical.entity.jun;


/**
*	@author Junisyoan;
*	日期：2019年2月21日
*	时间：上午11:05:51
*	类说明：
*/
public class Carousel {

	private int carousel_id;
	private String content;
	private String time;
	private String state;
	public Carousel() {
		super();
	}
	public Carousel(int carousel_id, String content, String time, String state) {
		super();
		this.carousel_id = carousel_id;
		this.content = content;
		this.time = time;
		this.state = state;
	}
	public int getCarousel_id() {
		return carousel_id;
	}
	public void setCarousel_id(int carousel_id) {
		this.carousel_id = carousel_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
