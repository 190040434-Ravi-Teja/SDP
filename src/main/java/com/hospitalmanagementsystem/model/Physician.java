package com.hospitalmanagementsystem.model;

//import java.util.List;


//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "physician_data")
public class Physician {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "physician_id")
	private Long id;
	private String firstName;
	private String lastName;
	private String department;
	private String qualification;
	private Integer yearsOfExperience;
	
	
	
	/* @JsonManagedReference
	    @OneToMany(mappedBy="physician",cascade= {CascadeType.ALL})
	    private List<Patient> patient;
	    
	    
	    
	    public List<Patient> getPatient() {
	        return patient;
	    }

	    public void setPatient(List<Patient> patient) {
	        this.patient = patient;
	    }*/

	    
	    
	    
	public Physician() {
		super();
	}

	public Physician(Long id, String firstName, String lastName, String department, String qualification,
			Integer yearsOfExperience) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.qualification = qualification;
		this.yearsOfExperience = yearsOfExperience;
	}

	
	public Physician(String firstName, String lastName, String department, String qualification,
			Integer yearsOfExperience) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.qualification = qualification;
		this.yearsOfExperience = yearsOfExperience;
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


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public Integer getYearsOfExperience() {
		return yearsOfExperience;
	}


	public void setYearsOfExperience(Integer yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	

}
