package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Patient;
import com.service.PatientEnrollServiceInterface;

@Controller
public class PatientEnrollController {

	@Autowired
	PatientEnrollServiceInterface service;

	@GetMapping(value = "/patient")
	public ModelAndView patientEnroll(@ModelAttribute("patient") Patient patient, HttpSession session) {
		boolean adminAccess = session.getAttribute("adminAccess") == null ? false
				: (boolean) session.getAttribute("adminAccess");
		if (adminAccess == true) {
			return new ModelAndView("patientenroll");
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	@PostMapping(value = "/enrollPatient")
	public ModelAndView savePatientEnroll(@Validated @ModelAttribute("patient") Patient patient, BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("patientenroll");
		} else {

			service.enrollPatient(patient);
			return new ModelAndView("home","homepagemessage","Patient added successfully");
		}

	}

}
