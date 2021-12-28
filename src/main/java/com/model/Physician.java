package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings({ "unused", "deprecation" })
@Entity
@Table(name = "Physicians")
public class Physician{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int physicianId;
	
	private String physicianCustomId;
	
	@NotEmpty(message = "First Name should not be empty")
	private String firstName;

	
	@NotEmpty(message = "Last Name should not be empty")
	private String lastName;

	@NotEmpty(message = "Department should not be empty")
	private String department;

	@NotEmpty(message = "Educational Qualifications should not be empty")
	private String educationalQualifications;

	@NotEmpty(message = "Years Of Experience should not be empty")
	private String yearsOfExperience;

	@NotEmpty(message = "State should not be empty")
	private String state;

	@NotEmpty(message = "Insurance plan should not be empty")
	private String insurancePlan;
	
	public int getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(int physicianId) {
		this.physicianId = physicianId;
	}

	public String getPhysicianCustomId() {
		return physicianCustomId;
	}

	public void setPhysicianCustomId(String physicianCustomId) {
		this.physicianCustomId = physicianCustomId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getInsurancePlan() {
		return insurancePlan;
	}

	public void setInsurancePlan(String insurancePlan) {
		this.insurancePlan = insurancePlan;
	}
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEducationalQualifications() {
		return educationalQualifications;
	}

	public void setEducationalQualifications(String educationalQualifications) {
		this.educationalQualifications = educationalQualifications;
	}

	public String getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

}