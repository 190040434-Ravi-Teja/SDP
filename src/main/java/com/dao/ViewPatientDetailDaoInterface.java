package com.dao;

import com.model.PatientDiagnosis;

public interface ViewPatientDetailDaoInterface {

	int checkDiagnosisId(int diagnosisId);

	PatientDiagnosis viewPatientDetail(int diagnosisId);

}
