package xyz.cymedical.entity.xin;

import java.util.List;

import xyz.cymedical.entity.zsc.Project;

public class Combo {

	private int combo_id;
	private String name;
	private float price;
	private List<Project> projects;

	public Combo() {
		super();
	}

	public Combo(int combo_id, String name, float price) {
		super();
		this.combo_id = combo_id;
		this.name = name;
		this.price = price;
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

	public float getPrice() {
		return price;
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

}
