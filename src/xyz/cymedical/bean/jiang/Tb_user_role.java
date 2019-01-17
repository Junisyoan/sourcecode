package xyz.cymedical.bean.jiang;

//用户角色表
public class Tb_user_role {

	private int   user_roleid ;//用户角色表id
	private int    user_id ;//用户id
	private int   role_id;//角色id
	
	public Tb_user_role() {
		super();
	}

	public Tb_user_role(int user_roleid, int user_id, int role_id) {
		super();
		this.user_roleid = user_roleid;
		this.user_id = user_id;
		this.role_id = role_id;
	}

	public int getUser_roleid() {
		return user_roleid;
	}

	public void setUser_roleid(int user_roleid) {
		this.user_roleid = user_roleid;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	      
	
	
	
}
