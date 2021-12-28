
package com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity

@SuppressWarnings("deprecation")

@Table(name = "patient_details")
public class Patient {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int patientId;

	@NotEmpty(message = "FirstName should not be empty")
	private String firstName;

	@NotEmpty(message = "LastName should not be empty")
	private String lastName;

	@NotEmpty(message = "Email should not be empty")
	private String email;

	@NotEmpty(message = "Password should not be empty")
	private String password;

	@NotEmpty(message = "State should not be empty")
	private String state;

	@NotEmpty(message = "Gender should not be empty")
	private String gender;

	@NotNull(message = "Dob should not be empty")

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;

	@NotEmpty(message = "Contact Number should not be empty")
	private String contactNumber;

	@NotEmpty(message = "Insurance should not be empty")
	private String insurance;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

}
