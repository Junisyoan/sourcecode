package xyz.cymedical.entity.yjn;

public class Parameter {
	private int param_id;
	private int pid;
	private String name;

	public Parameter() {
		super();
	}

	public Parameter(int param_id, int pid, String name) {
		super();
		this.param_id = param_id;
		this.pid = pid;
		this.name = name;
	}

	public int getParam_id() {
		return param_id;
	}

	public void setParam_id(int param_id) {
		this.param_id = param_id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
