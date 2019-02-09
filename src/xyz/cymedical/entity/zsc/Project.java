package xyz.cymedical.entity.zsc;

import java.util.List;

import xyz.cymedical.entity.yjn.Parameter;

public class Project {

	private int project_id;
	private String name;
	private String price;
	private Parameter param;
	private List<Detail> details;

	public Project() {
		super();
	}

	public Project(int project_id, String name, String price, Parameter param, List<Detail> details) {
		super();
		this.project_id = project_id;
		this.name = name;
		this.price = price;
		this.param = param;
		this.details = details;
	}

	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", name=" + name + ", price=" + price + ", param=" + param
				+ ", details=" + details + "]";
	}

	public Parameter getParam() {
		return param;
	}

	public void setParam(Parameter param) {
		this.param = param;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<Detail> getDetails() {
		return details;
	}

	public void setDetails(List<Detail> details) {
		this.details = details;
	}

}
