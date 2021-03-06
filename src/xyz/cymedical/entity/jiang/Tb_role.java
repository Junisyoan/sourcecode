package xyz.cymedical.entity.jiang;

import org.springframework.stereotype.Component;

//角色表
@Component
public class Tb_role {

	private int role_id;//角色id
	private String name;//角色名字 
	private int  dept_id;
	 
	
	public Tb_role() {
		super();
	}
	
	public Tb_role(int role_id, String name, int dept_id) {
		super();
		this.role_id = role_id;
		this.name = name;
		this.dept_id = dept_id;
	}

	
	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
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

	@Override
	public String toString() {
		return "Tb_role [role_id=" + role_id + ", name=" + name + ", dept_id=" + dept_id + "]";
	}
	
	
	
	
	
}
