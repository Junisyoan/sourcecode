package xyz.cymedical.entity.xin;

import xyz.cymedical.entity.jun.Company;

//病人类
public class Patient {
	private int patient_id;
	private Company company;
	private Combo combo;
	private String name;
	private String sex;
	private String age;
	private String ID;
	private String code;//条码号
	private String phone;
	private String check_num;//体检号
	
	public Patient() {
		super();
	}

	
	
	public Patient(Company company, Combo combo, String name, String sex, String age, String iD, String code,
			String phone, String check_num) {
		super();
		this.company = company;
		this.combo = combo;
		this.name = name;
		this.sex = sex;
		this.age = age;
		ID = iD;
		this.code = code;
		this.phone = phone;
		this.check_num = check_num;
	}



	public Patient(int patient_id, Company company, Combo combo, String name, String sex, String age, String iD,
			String code, String phone, String check_num) {
		super();
		this.patient_id = patient_id;
		this.company = company;
		this.combo = combo;
		this.name = name;
		this.sex = sex;
		this.age = age;
		ID = iD;
		this.code = code;
		this.phone = phone;
		this.check_num = check_num;
	}



	public int getPatient_id() {
		return patient_id;
	}



	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}



	public Company getCompany() {
		return company;
	}



	public void setCompany(Company company) {
		this.company = company;
	}



	public Combo getCombo() {
		return combo;
	}



	public void setCombo(Combo combo) {
		this.combo = combo;
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



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public String getID() {
		return ID;
	}



	public void setID(String iD) {
		ID = iD;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getCheck_num() {
		return check_num;
	}



	public void setCheck_num(String check_num) {
		this.check_num = check_num;
	}



	@Override
	public String toString() {
		return "Patient [patient_id=" + patient_id + ", company=" + company + ", combo=" + combo + ", name=" + name
				+ ", sex=" + sex + ", age=" + age + ", ID=" + ID + ", code=" + code + ", phone=" + phone
				+ ", check_num=" + check_num + "]";
	}

	
	
}
