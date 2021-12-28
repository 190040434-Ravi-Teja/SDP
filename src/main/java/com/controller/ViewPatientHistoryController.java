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
import com.model.PatientHistory;
import com.service.ViewPatientHistoryServiceInterface;

@Controller
public class ViewPatientHistoryController {

	@Autowired
	ViewPatientHistoryServiceInterface service;

	@GetMapping("/patientHistory")
	public ModelAndView patientHistoryPage(@ModelAttribute("patientHistory") PatientHistory patientHisory,
			HttpSession session) {

		boolean adminAccess = session.getAttribute("adminAccess") == null ? false
				: (boolean) session.getAttribute("adminAccess");
		if (adminAccess == true) {
			return new ModelAndView("viewpatienthistory");
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	@PostMapping(value = "/viewPatientHistory")
	public ModelAndView ViewPatientHistoryPage(
			@Validated @ModelAttribute("patientHistory") PatientHistory patientHistory, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return new ModelAndView("viewpatienthistory");
		} else {
			boolean checkViewPatientHistory = service.viewPatientHistory(patientHistory, model);
			if (checkViewPatientHistory == true) {
				return new ModelAndView("viewpatienthistorytable");
			} else {
				model.addAttribute("message", "Patient doesnot exist");
				return new ModelAndView("viewpatienthistory");
			}

		}
	}

}
