package xyz.cymedical.entity.jiang;

import org.springframework.stereotype.Component;

//用户表
@Component
public class Tb_user {
	private int user_id;//用戶表id
	private String account;//账号
	private String pwd;//密码
	private String sex;//性别
	private String address;//地址
	private String phone;//电话
	private String IDcard;//身份证
	
	public Tb_user() {
		super();
	}

	public Tb_user(int user_id, String account, String pwd, String sex, String address, String phone, String iDcard) {
		super();
		this.user_id = user_id;
		this.account = account;
		this.pwd = pwd;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		IDcard = iDcard;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIDcard() {
		return IDcard;
	}

	public void setIDcard(String iDcard) {
		IDcard = iDcard;
	}

	@Override
	public String toString() {
		return "Tb_user [user_id=" + user_id + ", account=" + account + ", pwd=" + pwd + ", sex=" + sex + ", address="
				+ address + ", phone=" + phone + ", IDcard=" + IDcard + "]";
	}
	
	

}
