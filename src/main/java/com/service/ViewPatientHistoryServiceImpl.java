package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import com.dao.ViewPatientHistoryDaoInterface;
import com.model.PatientDiagnosis;
import com.model.PatientHistory;

@Service
@Transactional
public class ViewPatientHistoryServiceImpl implements ViewPatientHistoryServiceInterface {

	@Autowired
	ViewPatientHistoryDaoInterface dao;

	public boolean viewPatientHistory(PatientHistory patientHistory, Model model) {

		int checkPatientId = dao.checkPatientId(patientHistory);
		if (checkPatientId == 1) {
			List<PatientDiagnosis> patientList = dao.viewPatientHistory(patientHistory);
			if (patientList != null) {
				model.addAttribute("patientList", patientList);
				System.out.println(patientList);
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

}
