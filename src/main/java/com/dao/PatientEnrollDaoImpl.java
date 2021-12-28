package com.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Patient;

@Repository
public class PatientEnrollDaoImpl implements PatientEnrollDaoInterface {

	@Autowired
	SessionFactory sessionFactory;

	public void enrollPatient(Patient patient) {
		sessionFactory.openSession().save(patient);

	}

}
