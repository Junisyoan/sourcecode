package xyz.cymedical.entity.jiang;

public class Tb_contact {
	
	/*
	 * 公司信息表
	 * 
	 * */

	 private int contact_id;/*公司表id*/
	 private String name;/*公司名*/
	 private String province;//省份
	 private String area;//地区 街道
	 private String tel;
	 private String phone;
	 private String fax;/*传真*/
	 private String email;
	 
	public Tb_contact() {
		super();
	}
 
	
	public Tb_contact(int contact_id, String name, String province, String area, String tel, String phone, String fax,
			String email) {
		super();
		this.contact_id = contact_id;
		this.name = name;
		this.province = province;
		this.area = area;
		this.tel = tel;
		this.phone = phone;
		this.fax = fax;
		this.email = email;
	}


	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
	@Override
	public String toString() {
		return "Tb_contact [contact_id=" + contact_id + ", name=" + name + ", province=" + province + ", area=" + area
				+ ", tel=" + tel + ", phone=" + phone + ", fax=" + fax + ", email=" + email + "]";
	}
	 
	 
	 
	 
	 
}
