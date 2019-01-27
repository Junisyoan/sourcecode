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
	private double totalMoney;		//总金额
	private String bstate;			//是否结算
	public Biller() {
		super();
	}
	public Biller(int biller_id, int group_id, double totalMoney, String bstate) {
		super();
		this.biller_id = biller_id;
		this.group_id = group_id;
		this.totalMoney = totalMoney;
		this.bstate = bstate;
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
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public String getBstate() {
		return bstate;
	}
	public void setBstate(String bstate) {
		this.bstate = bstate;
	}
	@Override
	public String toString() {
		return "Biller [biller_id=" + biller_id + ", group_id=" + group_id + ", totalMoney=" + totalMoney + ", bstate="
				+ bstate + "]";
	}
}
