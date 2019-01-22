package xyz.cymedical.entity.xin;

import org.springframework.stereotype.Component;

import xyz.cymedical.entity.zsc.Project;

@Component
public class Patient_Project {
	
	/**
	* 2019年1月21日
	* @author xin
	* @version 1.0
	*/
	
	private int patient_project_id;
	
	private Patient patient;
	private Project project;
	
	private String state;
	
	public Patient_Project() {
		super();
	}

	public Patient_Project(Patient patient, Project project, String state) {
		super();
		this.patient = patient;
		this.project = project;
		this.state = state;
	}

	public Patient_Project(int patient_project_id, Patient patient, Project project, String state) {
		super();
		this.patient_project_id = patient_project_id;
		this.patient = patient;
		this.project = project;
		this.state = state;
	}

	public int getPatient_project_id() {
		return patient_project_id;
	}

	public void setPatient_project_id(int patient_project_id) {
		this.patient_project_id = patient_project_id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Patient_Project [patient_project_id=" + patient_project_id + ", patient=" + patient + ", project="
				+ project + ", state=" + state + "]";
	}

	
	
}
