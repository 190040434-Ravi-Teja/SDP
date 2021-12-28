package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.model.PatientDiagnosis;
import com.service.PatientDiagnosisServiceInterface;

@Controller
public class PatientDiagnosisController {

	@Autowired
	PatientDiagnosisServiceInterface service;

	@GetMapping("/diagnosis")
	public ModelAndView patientDiagnosisPage(@ModelAttribute("diagnosis") PatientDiagnosis patientDiagnosis,
			HttpSession session) {

		boolean adminAccess = session.getAttribute("adminAccess") == null ? false
				: (boolean) session.getAttribute("adminAccess");
		if (adminAccess == true) {
			return new ModelAndView("patientdiagnosis");
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	@PostMapping(value = "/addDiagnosis")
	public ModelAndView addPatientDiagnosisPage(
			@Validated @ModelAttribute("diagnosis") PatientDiagnosis patientDiagnosis, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return new ModelAndView("patientdiagnosis");
		} else {
			boolean checkAddPatientDiagnosis = service.addPatientDiagnosis(patientDiagnosis);
			if (checkAddPatientDiagnosis == true) {
				return new ModelAndView("home","homepagemessage","Patient Diagnosis added successfully");
			} else {
				model.addAttribute("message", "Patient Id doesnot exist");
				return new ModelAndView("patientdiagnosis");
			}

		}
	}
}
