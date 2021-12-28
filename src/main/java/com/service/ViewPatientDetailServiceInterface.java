package com.service;

import org.springframework.ui.Model;

public interface ViewPatientDetailServiceInterface {

	boolean viewPatientDetail(int diagnosisId, Model model);

}
