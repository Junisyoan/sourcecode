package xyz.cymedical.entity.xin;

public class Patient {
	private int patient_id;
	private int company_id;
	private String name;
	private String sex;
	private String age;
	private String ID;
	private String code;
	
	public Patient() {
		super();
	}

	public Patient(int company_id, String name, String sex, String age, String iD, String code) {
		super();
		this.company_id = company_id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		ID = iD;
		this.code = code;
	}

	public Patient(int patient_id, int company_id, String name, String sex, String age, String iD, String code) {
		super();
		this.patient_id = patient_id;
		this.company_id = company_id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		ID = iD;
		this.code = code;
	}

	@Override
	public String toString() {
		return "Patient [patient_id=" + patient_id + ", company_id=" + company_id + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + ", ID=" + ID + ", code=" + code + "]";
	}
	
	
	
}
