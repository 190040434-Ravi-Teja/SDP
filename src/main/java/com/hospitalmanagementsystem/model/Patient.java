package com.hospitalmanagementsystem.model;

//import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "patient_details")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private Long id;
	private String firstName;
	private String lastName;
	private Integer age;
	private String diseaseName;
	private String phone;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	
/*	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="physician_id")
	@JsonBackReference
    private Physician physician;	
	
	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}
*/
	

	public Patient() {
		super();
	}

	public Patient(Long id, String firstName, String lastName, Integer age, String diseaseName, String phone,
			Gender gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.diseaseName = diseaseName;
		this.phone = phone;
		this.gender = gender;
	}

	public Patient(String firstName, String lastName, Integer age, String diseaseName, String phone, Gender gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.diseaseName = diseaseName;
		this.phone = phone;
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	
}
