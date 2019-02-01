package xyz.cymedical.entity.jun;


/**
*	@author Junisyoan;
*	日期：2019年1月29日
*	时间：上午11:34:18
*	类说明：体检工作站人员信息
*/
public class Nurse {
	
	private int user_id;		//用户id
	private int role_dept_id;	//所属角色部门id
	private String account;		//账户
	private String sex;			//性别
	private String address;		//住址
	private String phone;		//电话
	private String IDcard;		//身份证
	private String state;		//状态
	public Nurse() {
		super();
	}
	public Nurse(int user_id, int role_dept_id, String account, String sex, String address, String phone,
			String iDcard, String state) {
		super();
		this.user_id = user_id;
		this.role_dept_id = role_dept_id;
		this.account = account;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		IDcard = iDcard;
		this.state = state;
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
	@Override
	public String toString() {
		return "Nurse [user_id=" + user_id + ", role_dept_id=" + role_dept_id + ", account=" + account
				+ ", sex=" + sex + ", address=" + address + ", phone=" + phone + ", IDcard=" + IDcard + ", state="
				+ state + "]";
	}
}
