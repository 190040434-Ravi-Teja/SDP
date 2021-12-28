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
@Table(name = "PatientDiagnosisDetail")
public class PatientDiagnosis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int diagnosisId;

	@NotNull(message = "Patient Id should not be empty")
	private Integer patientId;

	@NotEmpty(message = "Symptoms should not be empty")
	private String symptoms;

	@NotEmpty(message = "Diagnosis Provided should not be empty")
	private String diagnosisProvided;

	@NotEmpty(message = "Administered by should not be empty")
	private String administeredBy;

	@NotNull(message = "Date of Diagnosis should not be empty")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfDiagnosis;

	private String followUpRequired;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfFollowUp;

	@NotNull(message = "Mode of payment should not be empty")
	private String modeOfPayment;

	private String cardNumber;

	@NotNull(message = "Bill Amount should not be empty")
	private Integer billAmount;

	public int getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(int diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDiagnosisProvided() {
		return diagnosisProvided;
	}

	public void setDiagnosisProvided(String diagnosisProvided) {
		this.diagnosisProvided = diagnosisProvided;
	}

	public String getAdministeredBy() {
		return administeredBy;
	}

	public void setAdministeredBy(String administeredBy) {
		this.administeredBy = administeredBy;
	}

	public Date getDateOfDiagnosis() {
		return dateOfDiagnosis;
	}

	public void setDateOfDiagnosis(Date dateOfDiagnosis) {
		this.dateOfDiagnosis = dateOfDiagnosis;
	}

	public String getFollowUpRequired() {
		return followUpRequired;
	}

	public void setFollowUpRequired(String followUpRequired) {
		this.followUpRequired = followUpRequired;
	}

	public Date getDateOfFollowUp() {
		return dateOfFollowUp;
	}

	public void setDateOfFollowUp(Date dateOfFollowUp) {
		this.dateOfFollowUp = dateOfFollowUp;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Integer getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Integer billAmount) {
		this.billAmount = billAmount;
	}

}
