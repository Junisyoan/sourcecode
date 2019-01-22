package xyz.cymedical.entity.xin;

import xyz.cymedical.entity.jun.Company;

//病人类
public class Patient {
	private int patient_id;
	private Company company;
//	private int company_id;
	private String name;
	private String sex;
	private String age;
	private String ID;
	private String code;
	
	public Patient() {
		super();
	}

	public Patient(Company company, String name, String sex, String age, String iD, String code) {
		super();
		this.company = company;
		this.name = name;
		this.sex = sex;
		this.age = age;
		ID = iD;
		this.code = code;
	}

	public Patient(String name, String sex, String age, String iD, String code) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		ID = iD;
		this.code = code;
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

	@Override
	public String toString() {
		return "Patient [patient_id=" + patient_id + ", company=" + company + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + ", ID=" + ID + ", code=" + code + "]";
	}


	
	
}
