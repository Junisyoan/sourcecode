package xyz.cymedical.entity.jiang;

//角色部门表
public class Tb_role_dept {

	private int   role_dept_id ;     //角色部门表id     
	private int     role_id    ;    //角色id
	private int    dept_id      ;   //部门id
	
	public Tb_role_dept() {
		super();
	}

	public Tb_role_dept(int role_dept_id, int role_id, int dept_id) {
		super();
		this.role_dept_id = role_dept_id;
		this.role_id = role_id;
		this.dept_id = dept_id;
	}

	public int getRole_dept_id() {
		return role_dept_id;
	}

	public void setRole_dept_id(int role_dept_id) {
		this.role_dept_id = role_dept_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	
	
	
	
}
