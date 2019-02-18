package xyz.cymedical.entity.jun;


/**
*	@author Junisyoan;
*	日期：2019年2月18日
*	时间：下午4:09:55
*	类说明：
*/
public class Invalide {

	private int invalide_id;
	private int file_id;
	private String name;
	private String reason;
	
	
	
	public Invalide() {
		super();
	}
	public Invalide(int invalide_id, int file_id, String name, String reason) {
		super();
		this.invalide_id = invalide_id;
		this.file_id = file_id;
		this.name = name;
		this.reason = reason;
	}
	public int getInvalide_id() {
		return invalide_id;
	}
	public void setInvalide_id(int invalide_id) {
		this.invalide_id = invalide_id;
	}
	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "Invalide [invalide_id=" + invalide_id + ", file_id=" + file_id + ", name=" + name + ", reason=" + reason
				+ "]";
	}
}
