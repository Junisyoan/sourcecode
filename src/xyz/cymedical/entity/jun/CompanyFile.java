package xyz.cymedical.entity.jun;

import org.springframework.stereotype.Component;

/**
*	@author Junisyoan;
*	日期：2019年1月22日
*	时间：上午11:24:14
*	类说明：公司上传的文件
*/

@Component
public class CompanyFile {

	private int file_id;			//文件id
	private int company_id;			//公司id
	private String name;			//公司名字
	private String fname;			//文件名
	private long fsize;				//文件大小
	private String fpath;			//文件路径
	private String ftime;			//上传时间
	private String cstate;			//审核状态
	public CompanyFile() {
		super();
	}
	public CompanyFile(int file_id, int company_id, String fname, long fsize, String fpath, String ftime,
			String cstate) {
		super();
		this.file_id = file_id;
		this.company_id = company_id;
		this.fname = fname;
		this.fsize = fsize;
		this.fpath = fpath;
		this.ftime = ftime;
		this.cstate = cstate;
	}
	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return name;
	}
	public void setCompany_name(String company_name) {
		this.name = company_name;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public long getFsize() {
		return fsize;
	}
	public void setFsize(long fsize) {
		this.fsize = fsize;
	}
	public String getFpath() {
		return fpath;
	}
	public void setFpath(String fpath) {
		this.fpath = fpath;
	}
	public String getFtime() {
		return ftime;
	}
	public void setFtime(String ftime) {
		this.ftime = ftime;
	}
	public String getCstate() {
		return cstate;
	}
	public void setCstate(String cstate) {
		this.cstate = cstate;
	}
	@Override
	public String toString() {
		return "CompanyFile [file_id=" + file_id + ", company_id=" + company_id + ", company_name=" + name
				+ ", fname=" + fname + ", fsize=" + fsize + ", fpath=" + fpath + ", ftime=" + ftime + ", cstate="
				+ cstate + "]";
	}
}
