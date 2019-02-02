package xyz.cymedical.entity.jun;


/**
*	@author Junisyoan;
*	日期：2019年1月27日
*	时间：下午7:36:26
*	类说明：记账表
*/
public class Biller {

	private int biller_id;			//记账表id
	private int group_id;			//团检表id
	private String bstate;			//是否结算
	private double totalMoney;		//总金额
	private String btime;			//结算时间
	public Biller() {
		super();
	}
	public Biller(int biller_id, int group_id, String bstate, double totalMoney, String btime) {
		super();
		this.biller_id = biller_id;
		this.group_id = group_id;
		this.bstate = bstate;
		this.totalMoney = totalMoney;
		this.btime = btime;
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
	@Override
	public String toString() {
		return "Biller [biller_id=" + biller_id + ", group_id=" + group_id + ", bstate=" + bstate + ", totalMoney="
				+ totalMoney + ", btime=" + btime + "]";
	}
}
