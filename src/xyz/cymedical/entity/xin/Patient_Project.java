//package xyz.cymedical.entity.xin;
//
//import java.util.List;
//
//import org.springframework.stereotype.Component;
//
//import xyz.cymedical.entity.zsc.Project;
//
//@Component
//public class Patient_Project {
//	
//	/**
//	* 2019年1月21日
//	* @author xin
//	* @version 1.0
//	*/
//	
//	private int patient_project_id;
//	
//	private List<Patient> patients;
//	private List<Project> projects;
//	
//	private String state;
//	
//	public Patient_Project() {
//		super();
//	}
//
//	
//	
//	public Patient_Project(List<Patient> patients, List<Project> projects, String state) {
//		super();
//		this.patients = patients;
//		this.projects = projects;
//		this.state = state;
//	}
//
//
//
//	public Patient_Project(int patient_project_id, List<Patient> patients, List<Project> projects, String state) {
//		super();
//		this.patient_project_id = patient_project_id;
//		this.patients = patients;
//		this.projects = projects;
//		this.state = state;
//	}
//
//
//
//	public int getPatient_project_id() {
//		return patient_project_id;
//	}
//
//
//
//	public void setPatient_project_id(int patient_project_id) {
//		this.patient_project_id = patient_project_id;
//	}
//
//
//
//	public List<Patient> getPatients() {
//		return patients;
//	}
//
//
//
//	public void setPatients(List<Patient> patients) {
//		this.patients = patients;
//	}
//
//
//
//	public List<Project> getProjects() {
//		return projects;
//	}
//
//
//
//	public void setProjects(List<Project> projects) {
//		this.projects = projects;
//	}
//
//
//
//	public String getState() {
//		return state;
//	}
//
//
//
//	public void setState(String state) {
//		this.state = state;
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "Patient_Project [patient_project_id=" + patient_project_id + ", patients=" + patients + ", projects="
//				+ projects + ", state=" + state + "]";
//	}
//
//	
//}
