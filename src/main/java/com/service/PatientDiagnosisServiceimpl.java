package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PatientDiagnosisDaoInterface;
import com.model.PatientDiagnosis;

@Service
@Transactional
public class PatientDiagnosisServiceimpl implements PatientDiagnosisServiceInterface {

	@Autowired
	PatientDiagnosisDaoInterface dao;

	public boolean addPatientDiagnosis(PatientDiagnosis patientDiagnosis) {

		int checkPatientId = dao.checkPatientId(patientDiagnosis);
		if (checkPatientId == 1) {
			dao.addPatientDiagnosis(patientDiagnosis);
			return true;
		} else {
			return false;
		}

	}

}
