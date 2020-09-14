package com.rest.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patients {
	@Id
	private int patientId;
	private Date reportedOn;
	private int onSet;
	private String ageEstimate;
	private String gender;
	private String city;
	private String district;
	private String state;
	private String status;
	private String notes;
	private String contractedFrom;
	
	
	public Patients() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Patients(int patientId, Date reportedOn, int onSet, String ageEstimate, String gender, String city,
			String district, String state, String status, String notes, String contractedFrom) {
		super();
		this.patientId = patientId;
		this.reportedOn = reportedOn;
		this.onSet = onSet;
		this.ageEstimate = ageEstimate;
		this.gender = gender;
		this.city = city;
		this.district = district;
		this.state = state;
		this.status = status;
		this.notes = notes;
		this.contractedFrom = contractedFrom;
	}


	public int getPatientId() {
		return patientId;
	}


	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}


	public Date getReportedOn() {
		return reportedOn;
	}


	public void setReportedOn(Date reportedOn) {
		this.reportedOn = reportedOn;
	}


	public int getOnSet() {
		return onSet;
	}


	public void setOnSet(int onSet) {
		this.onSet = onSet;
	}


	


	public String getAgeEstimate() {
		return ageEstimate;
	}


	public void setAgeEstimate(String ageEstimate) {
		this.ageEstimate = ageEstimate;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public String getContractedFrom() {
		return contractedFrom;
	}


	public void setContractedFrom(String contractedFrom) {
		this.contractedFrom = contractedFrom;
	}


	
	
	
	

}
