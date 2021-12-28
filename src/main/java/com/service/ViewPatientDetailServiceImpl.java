package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import com.dao.ViewPatientDetailDaoInterface;
import com.model.PatientDiagnosis;

@Service
@Transactional
public class ViewPatientDetailServiceImpl implements ViewPatientDetailServiceInterface {

	@Autowired
	ViewPatientDetailDaoInterface dao;

	public boolean viewPatientDetail(int diagnosisId, Model model) {

		int checkDiagnosisId = dao.checkDiagnosisId(diagnosisId);
		if (checkDiagnosisId == 1) {
			PatientDiagnosis patient = dao.viewPatientDetail(diagnosisId);
			model.addAttribute("patient", patient);
			return true;
		} else {
			return false;
		}

	}
}
