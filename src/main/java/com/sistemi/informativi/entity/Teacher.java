package com.sistemi.informativi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Teacher implements Serializable {

	@Id
	@Column(name="fiscal_code", length=10)
	private String fiscalCode;
	
	@Column(name="full_name", length=10)
	private String fullName;
	private String subject;
	
	@Column(name="experience_years")
	private int experienceYears;

	public String getFiscalCode() {
		return fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}

	protected Teacher() {};
	
	public Teacher(String fiscalCode, String fullName, String subject, int experienceYears) {
		super();
		this.fiscalCode = fiscalCode;
		this.fullName = fullName;
		this.subject = subject;
		this.experienceYears = experienceYears;
	}
	
	
}
