package com.service;

import org.springframework.ui.Model;

import com.model.PatientHistory;

public interface ViewPatientHistoryServiceInterface {

	boolean viewPatientHistory(PatientHistory patientHistory, Model model);

}
