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
	
	
}
