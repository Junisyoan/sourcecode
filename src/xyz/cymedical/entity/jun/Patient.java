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
	private String comboName;	//套餐名字
	private String prname;		//检查科室
	private String pname;		//项目名字
	private String dname;		//细项名字
	private double a;			//临时存储变量
	
	private Company company;
//	private Combo combo;
	public Patient() {
		super();
	}
	
	public Patient(int paitent_id, 
			int company_id, 
			int combo_id, 
			String name, 
			String sex, 
			String age, 
			String iD,
			String code, 
			String phone, 
			String check_num, 
			String comboName) {
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
		this.comboName = comboName;
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

	public String getComboName() {
		return comboName;
	}

	public void setComboName(String comboName) {
		this.comboName = comboName;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

//	public Combo getCombo() {
//		return combo;
//	}

//	public void setCombo(Combo combo) {
//		this.combo = combo;
//	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
	
	public String getPrname() {
		return prname;
	}

	public void setPrname(String prname) {
		this.prname = prname;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "Patient [paitent_id=" + paitent_id + ", company_id=" + company_id + ", combo_id=" + combo_id + ", name="
				+ name + ", sex=" + sex + ", age=" + age + ", ID=" + ID + ", code=" + code + ", phone=" + phone
				+ ", check_num=" + check_num + ", comboName=" + comboName + ", prname=" + prname + ", pname=" + pname
				+ ", dname=" + dname + ", company=" + company + "]";
	}
}
