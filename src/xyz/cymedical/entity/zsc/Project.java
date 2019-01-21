package xyz.cymedical.entity.zsc;

import java.util.List;

public class Project {

	private int project_id;
	private String name;
	private String price;
	private List<Detail> detials;

	public Project() {
		super();
	}

	public Project(int project_id, String name, String price, List<Detail> detials) {
		super();
		this.project_id = project_id;
		this.name = name;
		this.price = price;
		this.detials = detials;
	}

	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", name=" + name + ", price=" + price + ", detials=" + detials
				+ "]";
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

	public List<Detail> getDetials() {
		return detials;
	}

	public void setDetials(List<Detail> detials) {
		this.detials = detials;
	}

}
