package com.model;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
public class PatientHistory {

	@NotNull(message = "Patient Id should not be empty")
	private Integer patientId;

	@NotEmpty(message = "FirstName should not be empty")
	private String firstName;

	@NotEmpty(message = "LastName should not be empty")
	private String lastName;

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
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

}
