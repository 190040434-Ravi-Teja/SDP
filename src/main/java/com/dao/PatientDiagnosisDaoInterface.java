package com.dao;

import com.model.PatientDiagnosis;

public interface PatientDiagnosisDaoInterface {

	void addPatientDiagnosis(PatientDiagnosis patientDiagnosis);

	int checkPatientId(PatientDiagnosis patientDiagnosis);

}
