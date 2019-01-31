package xyz.cymedical.entity.jun;


/**
*	@author Junisyoan;
*	日期：2019年1月27日
*	时间：下午7:37:14
*	类说明：团检表实体
*/
public class Group {

	private int group_id;			//团检表id
	private int company_id;			//公司id
	private int file_id;			//文件id
	private int pamount;			//人数
	private String time;			//团检开单时间
	private double limitMoney;		//上限金额
	public Group() {
		super();
	}
	public Group(int group_id, int company_id, int file_id, int pamount, String time, double limitMoney) {
		super();
		this.group_id = group_id;
		this.company_id = company_id;
		this.file_id = file_id;
		this.pamount = pamount;
		this.time = time;
		this.limitMoney = limitMoney;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	public int getPamount() {
		return pamount;
	}
	public void setPamount(int pamount) {
		this.pamount = pamount;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getLimitMoney() {
		return limitMoney;
	}
	public void setLimitMoney(double limitMoney) {
		this.limitMoney = limitMoney;
	}
	@Override
	public String toString() {
		return "Group [group_id=" + group_id + ", company_id=" + company_id + ", file_id=" + file_id + ", pamount="
				+ pamount + ", time=" + time + ", limitMoney=" + limitMoney + "]";
	}
}
