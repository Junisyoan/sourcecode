package xyz.cymedical.entity.jun;

import java.util.List;

/**
*	@author Junisyoan;
*	日期：2019年1月27日
*	时间：下午7:36:26
*	类说明：记账表
*/
public class Biller {

	private int biller_id;				//记账表id
	private int group_id;				//团检表id
	private String batch;				//批次
	private String fname;				//文件名
	private String name;				//公司名
	private String bstate;				//是否结算
	private double totalMoney;			//总金额
	private String btime;				//结算时间
	private String bcreate;				//是否开单
	private List<Patient> patientList;	//病人信息
	private String hcode;
	
	public Biller() {
		super();
	}

	public Biller(int biller_id, int group_id, String batch, String name, String bstate, double totalMoney,
			String btime, String bcreate) {
		super();
		this.biller_id = biller_id;
		this.group_id = group_id;
		this.batch = batch;
		this.name = name;
		this.bstate = bstate;
		this.totalMoney = totalMoney;
		this.btime = btime;
		this.bcreate = bcreate;
	}

	public int getBiller_id() {
		return biller_id;
	}

	public void setBiller_id(int biller_id) {
		this.biller_id = biller_id;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBstate() {
		return bstate;
	}

	public void setBstate(String bstate) {
		this.bstate = bstate;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getBtime() {
		return btime;
	}

	public void setBtime(String btime) {
		this.btime = btime;
	}

	public String getBcreate() {
		return bcreate;
	}

	public void setBcreate(String bcreate) {
		this.bcreate = bcreate;
	}

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getHcode() {
		return hcode;
	}

	public void setHcode(String hcode) {
		this.hcode = hcode;
	}

	@Override
	public String toString() {
		return "Biller [biller_id=" + biller_id + ", group_id=" + group_id + ", batch=" + batch + ", name=" + name
				+ ", bstate=" + bstate + ", totalMoney=" + totalMoney + ", btime=" + btime + ", bcreate=" + bcreate
				+ "]";
	}
	
}
