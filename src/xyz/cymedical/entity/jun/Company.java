package xyz.cymedical.entity.jun;

import org.springframework.stereotype.Component;

/**
* 2019年1月19日
* @author Junisyoan
* @version 1.0
*/

@Component
public class Company {

	private int company_id;			//主键id
	private String name;			//公司名称
	private String account;			//账户
	private String pwd;				//密码
	private String tel;				//公司电话
	private String address;			//公司地址
	private String people;			//领队人
	private String phone;			//领队人电话
	public Company() {
		super();
	}
	public Company(int company_id, String name, String account, String pwd, String tel, String address,
			String people, String phone) {
		super();
		this.company_id = company_id;
		this.name = name;
		this.account = account;
		this.pwd = pwd;
		this.tel = tel;
		this.address = address;
		this.people = people;
		this.phone = phone;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "公司信息 [company_id=" + company_id + ", name=" + name + ", account=" + account + ", pwd=" + pwd
				+ ", tel=" + tel + ", address=" + address + ", people=" + people + ", phone=" + phone + "]";
	}
	
}
