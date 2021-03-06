package xyz.cymedical.entity.ctx;

import org.springframework.stereotype.Component;

import xyz.cymedical.entity.jun.Company;

/**
 * 2019年1月20日
 * 
 * @author ctx
 * @version 1.0
 */

//记账表
@Component
public class LogCompany {

	public int log_company_id;// 公司日志表id
	public int company_id;// 公司表id
	public String operate;// 操作事项
	public float money;// 金额
	public String time;// 时间

	private Company company;

	public LogCompany() {
		super();
	}

	public LogCompany(int log_company_id, int company_id, String operate, int money, String time) {
		super();
		this.log_company_id = log_company_id;
		this.company_id = company_id;
		this.operate = operate;
		this.money = money;
		this.time = time;
	}

	public int getLog_company_id() {
		return log_company_id;
	}

	public void setLog_company_id(int log_company_id) {
		this.log_company_id = log_company_id;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "LogCompany [log_company_id=" + log_company_id + ", company_id=" + company_id + ", operate=" + operate
				+ ", money=" + money + ", time=" + time + ", company=" + company + "]";
	}

}
