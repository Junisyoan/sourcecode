package xyz.cymedical.entity.xin;

public class News {
	private int new_id;
	private String title;
	private String info;
	private String time;
	
	public News() {
		super();
	}

	public News(String title, String info, String time) {
		super();
		this.title = title;
		this.info = info;
		this.time = time;
	}

	public News(int new_id, String title, String info, String time) {
		super();
		this.new_id = new_id;
		this.title = title;
		this.info = info;
		this.time = time;
	}

	public int getNew_id() {
		return new_id;
	}

	public void setNew_id(int new_id) {
		this.new_id = new_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "News [new_id=" + new_id + ", title=" + title + ", info=" + info + ", time=" + time + "]";
	}


	
	
	
}
