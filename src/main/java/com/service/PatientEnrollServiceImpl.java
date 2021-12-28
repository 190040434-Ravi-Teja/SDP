package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PatientEnrollDaoInterface;
import com.model.Patient;

@Service
@Transactional
public class PatientEnrollServiceImpl implements PatientEnrollServiceInterface {

	@Autowired
	PatientEnrollDaoInterface dao;

	public void enrollPatient(Patient patient) {
		dao.enrollPatient(patient);

	}

}
