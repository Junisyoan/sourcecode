package xyz.cymedical.entity.jun;

import org.springframework.stereotype.Component;

/**
 * @author Junisyoan; 日期：2019年1月21日 时间：下午10:03:44 类说明：病人实体类
 *
 */
@Component
public class Patient {

	private int paitent_id; // 病人id
	private int company_id; // 公司id
	private int combo_id; // 套餐id
	private String name; // 姓名
	private String sex; // 性别
	private String age; // 年龄
	private String ID; // 身份证
	private String code; // 条形码
	private String phone; // 手机号
	private String check_num; // 体检号

	private Company company;

	public Patient() {
		super();
	}

	public Patient(int paitent_id, int company_id, int combo_id, String name, String sex, String age, String iD,
			String code, String phone, String check_num) {
		super();
		this.paitent_id = paitent_id;
		this.company_id = company_id;
		this.combo_id = combo_id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		ID = iD;
		this.code = code;
		this.phone = phone;
		this.check_num = check_num;
	}

	public int getPaitent_id() {
		return paitent_id;
	}

	public void setPaitent_id(int paitent_id) {
		this.paitent_id = paitent_id;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public int getCombo_id() {
		return combo_id;
	}

	public void setCombo_id(int combo_id) {
		this.combo_id = combo_id;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Patient [paitent_id=" + paitent_id + ", company_id=" + company_id + ", combo_id=" + combo_id + ", name="
				+ name + ", sex=" + sex + ", age=" + age + ", ID=" + ID + ", code=" + code + ", phone=" + phone
				+ ", check_num=" + check_num + "]";
	}
}
