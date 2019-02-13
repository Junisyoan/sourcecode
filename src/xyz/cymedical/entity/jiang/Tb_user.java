package xyz.cymedical.entity.jiang;

import org.springframework.stereotype.Component;

//用户表
@Component
public class Tb_user {
	private int user_id;//用戶表id
	private int role_dept_id;//role_dept_id
	private String account;//账号
	private String pwd;//密码
	private String name;//
	private String sex;//性别
	private String address;//地址
	private String phone;//电话
	private String IDcard;//身份证
	private String state;//身份证
	private int param_id;
	private String doctor;
	
	public Tb_user() {
		super();
	}

	public Tb_user(int user_id, int role_dept_id, String account, String pwd, String name, String sex, String address,
			String phone, String iDcard, String state, int param_id, String doctor) {
		super();
		this.user_id = user_id;
		this.role_dept_id = role_dept_id;
		this.account = account;
		this.pwd = pwd;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		IDcard = iDcard;
		this.state = state;
		this.param_id = param_id;
		this.doctor = doctor;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getRole_dept_id() {
		return role_dept_id;
	}

	public void setRole_dept_id(int role_dept_id) {
		this.role_dept_id = role_dept_id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getParam_id() {
		return param_id;
	}

	public void setParam_id(int param_id) {
		this.param_id = param_id;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

 

	 
}
  