package xyz.cymedical.entity.jun;


/**
*	@author Junisyoan;
*	日期：2019年2月21日
*	时间：下午3:48:22
*	类说明：
*/
public class PatientTmp {

	private int patient_tmp_id;
	private int biller_id;
	private String name;
	private String age;
	private String ID;
	private String phone;
	private String comboName;
	private String hcode;
	private String sex;
	public PatientTmp() {
		super();
	}
	public PatientTmp(int patient_tmp_id, int biller_id, String name, String age, String iD, String phone,
			String comboName, String hcode, String sex) {
		super();
		this.patient_tmp_id = patient_tmp_id;
		this.biller_id = biller_id;
		this.name = name;
		this.age = age;
		ID = iD;
		this.phone = phone;
		this.comboName = comboName;
		this.hcode = hcode;
		this.sex = sex;
	}
	public int getPatient_tmp_id() {
		return patient_tmp_id;
	}
	public void setPatient_tmp_id(int patient_tmp_id) {
		this.patient_tmp_id = patient_tmp_id;
	}
	public int getBiller_id() {
		return biller_id;
	}
	public void setBiller_id(int biller_id) {
		this.biller_id = biller_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getComboName() {
		return comboName;
	}
	public void setComboName(String comboName) {
		this.comboName = comboName;
	}
	public String getHcode() {
		return hcode;
	}
	public void setHcode(String hcode) {
		this.hcode = hcode;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "PatientTmp [patient_tmp_id=" + patient_tmp_id + ", biller_id=" + biller_id + ", name=" + name + ", age="
				+ age + ", ID=" + ID + ", phone=" + phone + ", comboName=" + comboName + ", hcode=" + hcode + ", sex="
				+ sex + "]";
	}
	
}
