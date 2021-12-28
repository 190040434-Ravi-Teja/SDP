package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.ViewPatientDetailServiceInterface;

@Controller
public class ViewPatientDetailController {

	@Autowired
	ViewPatientDetailServiceInterface service;

	@GetMapping(value = "/viewPatientDetail")
	public ModelAndView viewPatientDetailpage(HttpServletRequest request, Model model, HttpSession session) {

		boolean adminAccess = session.getAttribute("adminAccess") == null ? false
				: (boolean) session.getAttribute("adminAccess");
		if (adminAccess == true) {

			int diagnosisId = Integer.parseInt(request.getParameter("id"));
			boolean checkViewPatientDetail = service.viewPatientDetail(diagnosisId, model);
			if (checkViewPatientDetail == true) {
				return new ModelAndView("viewpatienthistorytable2");
			} else {
				model.addAttribute("message", "Diagnosis Id doesnot exist");
				return new ModelAndView("viewpatienthistorytable");
			}
		}

		else {
			return new ModelAndView("redirect:/");
		}

	}
}
