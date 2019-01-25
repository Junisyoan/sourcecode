package xyz.cymedical.entity.jiang;

//角色表
public class Tb_role {

	private int role_id;//角色id
	private String name;//角色名字
	public Tb_role() {
		super();
	}
	public Tb_role(int role_id, String name) {
		super();
		this.role_id = role_id;
		this.name = name;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
