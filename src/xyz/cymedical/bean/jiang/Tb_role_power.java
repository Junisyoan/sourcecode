package xyz.cymedical.bean.jiang;

//角色权限表
public class Tb_role_power {

	private int role_powerid;//角色权限id
	private int power_id;//权限id
	private int role_id;//角色id
	public Tb_role_power() {
		super();
	}
	public Tb_role_power(int role_powerid, int power_id, int role_id) {
		super();
		this.role_powerid = role_powerid;
		this.power_id = power_id;
		this.role_id = role_id;
	}
	public int getRole_powerid() {
		return role_powerid;
	}
	public void setRole_powerid(int role_powerid) {
		this.role_powerid = role_powerid;
	}
	public int getPower_id() {
		return power_id;
	}
	public void setPower_id(int power_id) {
		this.power_id = power_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
 


}
