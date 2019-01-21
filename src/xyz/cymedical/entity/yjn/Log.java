package xyz.cymedical.entity.yjn;

import org.springframework.stereotype.Component;

@Component
public class Log {
	private int log_id;
	private int user_id;
	private String opera;
	private String time;

	public Log() {
		super();
	}

	public Log(int log_id, int user_id, String opera, String time) {
		super();
		this.log_id = log_id;
		this.user_id = user_id;
		this.opera = opera;
		this.time = time;
	}

	public int getLog_id() {
		return log_id;
	}

	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getOpera() {
		return opera;
	}

	public void setOpera(String opera) {
		this.opera = opera;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
