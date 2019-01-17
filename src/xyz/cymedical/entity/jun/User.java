package xyz.cymedical.entity.jun;

import org.springframework.stereotype.Component;

/**
*	@author Junisyoan;
*	���ڣ�2018��12��25��
*	ʱ�䣺����11:11:01
*	��˵����
*/

@Component
public class User {

	private String user_id;
	private String account;
	private String pwd;
	private int age;
	private String sex;
	private String edu;
	private String occu;
	private String phone;
	private String email;
	private String state;
	
	public User() {
		super();
	}

	public User(String user_id, String account, String pwd, int age, String sex, String edu, String occu, String phone,
			String email, String state) {
		super();
		this.user_id = user_id;
		this.account = account;
		this.pwd = pwd;
		this.age = age;
		this.sex = sex;
		this.edu = edu;
		this.occu = occu;
		this.phone = phone;
		this.email = email;
		this.state = state;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getOccu() {
		return occu;
	}

	public void setOccu(String occu) {
		this.occu = occu;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", account=" + account + ", pwd=" + pwd + ", age=" + age + ", sex=" + sex
				+ ", edu=" + edu + ", occu=" + occu + ", phone=" + phone + ", email=" + email + ", state=" + state
				+ "]";
	}

	
}
