package xyz.cymedical.entity.jiang;

import org.springframework.stereotype.Component;

//import org.springframework.stereotype.Component;

@Component
public class Tb_msg {
	
	private int msg_id;
	private String name;
	private String email;
	private String phone;
	private String msg;
	private String state;
	public Tb_msg() {
		super();
	}
	
	
	public Tb_msg(String name, String email, String phone, String msg, String state) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.msg = msg;
		this.state = state;
	}


	public Tb_msg(int msg_id, String name, String email, String phone, String msg, String state) {
		super();
		this.msg_id = msg_id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.msg = msg;
		this.state = state;
	}
	public int getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Tb_msg [msg_id=" + msg_id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", msg=" + msg
				+ ", state=" + state + "]";
	}
	
	

}
