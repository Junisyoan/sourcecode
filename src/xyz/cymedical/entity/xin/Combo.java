package xyz.cymedical.entity.xin;

import java.util.List;

import xyz.cymedical.entity.zsc.Project;

public class Combo {

	private int combo_id; // 套餐id
	private String name; // 套餐名
	private double price; // 价格
	private List<Project> projects;
	
	private Project project;

	public Combo() {
		super();
	}

	public Combo(int combo_id, String name, double price) {
		super();
		this.combo_id = combo_id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Combo [combo_id=" + combo_id + ", name=" + name + ", price=" + price + ", projects=" + projects + "]";
	}

	public int getCombo_id() {
		return combo_id;
	}

	public void setCombo_id(int combo_id) {
		this.combo_id = combo_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
