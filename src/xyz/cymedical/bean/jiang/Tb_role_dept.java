package xyz.cymedical.bean.jiang;

//角色部门表
public class Tb_role_dept {

	private int   role_deptid ;     //角色部门表id     
	private int     role_id    ;    //角色id
	private int    dept_id      ;   //部门id
	
	public Tb_role_dept() {
		super();
	}

	public Tb_role_dept(int role_deptid, int role_id, int dept_id) {
		super();
		this.role_deptid = role_deptid;
		this.role_id = role_id;
		this.dept_id = dept_id;
	}

	public int getRole_deptid() {
		return role_deptid;
	}

	public void setRole_deptid(int role_deptid) {
		this.role_deptid = role_deptid;
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
