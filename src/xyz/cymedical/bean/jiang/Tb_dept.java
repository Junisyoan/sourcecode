package xyz.cymedical.bean.jiang;

//部门表
public class Tb_dept {

	private int  dept_id ;  //部门id
	private String   name ; //部门名
	public Tb_dept() {
		super();
	}
	public Tb_dept(int dept_id, String name) {
		super();
		this.dept_id = dept_id;
		this.name = name;
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
