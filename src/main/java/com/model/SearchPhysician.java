package com.model;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
public class SearchPhysician {

	@NotEmpty(message = "Department should not be empty")
	private String department;

	@NotEmpty(message = "State should not be empty")
	private String state;

	@NotEmpty(message = "Insurance plan should not be empty")
	private String insurancePlan;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

}
