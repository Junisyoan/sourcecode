package xyz.cymedical.entity.xin;

import org.springframework.stereotype.Component;

@Component
public class Patient_Project {
	
	/**
	* 2019年1月19日
	* @author xin
	* @version 1.0
	*/
	
	private int patient_project_id;
	private int patient_id;
	private int project_id;
	private String state;
	
	public Patient_Project() {
		super();
	}

	public Patient_Project(int patient_id, int project_id, String state) {
		super();
		this.patient_id = patient_id;
		this.project_id = project_id;
		this.state = state;
	}

	public Patient_Project(int patient_project_id, int patient_id, int project_id, String state) {
		super();
		this.patient_project_id = patient_project_id;
		this.patient_id = patient_id;
		this.project_id = project_id;
		this.state = state;
	}

	public int getPatient_project_id() {
		return patient_project_id;
	}

	public void setPatient_project_id(int patient_project_id) {
		this.patient_project_id = patient_project_id;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Patient_Project [patient_project_id=" + patient_project_id + ", patient_id=" + patient_id
				+ ", project_id=" + project_id + ", state=" + state + "]";
	}

	
	
}
