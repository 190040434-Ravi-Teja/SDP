package com.dao;

import java.util.List;

import com.model.PatientDiagnosis;
import com.model.PatientHistory;

public interface ViewPatientHistoryDaoInterface {

	int checkPatientId(PatientHistory patientHistory);

	List<PatientDiagnosis> viewPatientHistory(PatientHistory patientHistory);

}
