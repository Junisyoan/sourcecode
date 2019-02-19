package xyz.cymedical.entity.jiang;

//部门表
public class Tb_dept {

	private int  dept_id ;  //部门id
	private String   name ; //部门名
	
	private String role;
	
	private String sta;
	public Tb_dept() {
		super();
	}
	
	
 


	public Tb_dept(int dept_id, String name, String role, String sta) {
		super();
		this.dept_id = dept_id;
		this.name = name;
		this.role = role;
		this.sta = sta;
	}





	public Tb_dept(int dept_id, String name) {
		super();
		this.dept_id = dept_id;
		this.name = name;
	}
	
	
	public String getRole() {
		return role;
	}





	public void setRole(String role) {
		this.role = role;
	}





	public String getSta() {
		return sta;
	}


	public void setSta(String sta) {
		this.sta = sta;
	}


	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
