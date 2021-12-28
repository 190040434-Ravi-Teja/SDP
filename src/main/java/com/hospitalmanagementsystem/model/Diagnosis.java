package com.hospitalmanagementsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "diagnosis_details")
public class Diagnosis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="diagnosis_id")
	private Long id;
	private Integer patientId;
	private String name;
	private String administeredBy;
	private Double billAmount;
	@Enumerated(EnumType.STRING)
	private PaymentMode paymentMode;
	
	public Diagnosis() {
		super();
	}

	
	public Diagnosis(Long id, Integer patientId, String name, String administeredBy, Double billAmount,
			PaymentMode paymentMode) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.name = name;
		this.administeredBy = administeredBy;
		this.billAmount = billAmount;
		this.paymentMode = paymentMode;
	}

	

	public Diagnosis(Integer patientId, String name, String administeredBy, Double billAmount,
			PaymentMode paymentMode) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.administeredBy = administeredBy;
		this.billAmount = billAmount;
		this.paymentMode = paymentMode;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdministeredBy() {
		return administeredBy;
	}

	public void setAdministeredBy(String administeredBy) {
		this.administeredBy = administeredBy;
	}

	public Double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	
	
	
}
