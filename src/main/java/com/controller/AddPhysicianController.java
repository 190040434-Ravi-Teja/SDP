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
import com.model.Physician;
import com.model.SearchPhysician;
import com.service.PhysicianDetailServiceInterface;

@Controller
public class AddPhysicianController {

	@Autowired
	PhysicianDetailServiceInterface service;

	@GetMapping("/physician")
	public ModelAndView physicianPage(@ModelAttribute("physician") Physician physician, HttpSession session) {

		boolean adminAccess = session.getAttribute("adminAccess") == null ? false
				: (boolean) session.getAttribute("adminAccess");
		if (adminAccess == true) {
			return new ModelAndView("addphysician"); 
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	@PostMapping("/savePhysician")
	public ModelAndView savePhysicianPage(@Validated @ModelAttribute("physician") Physician physician,
			BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("addphysician");
		} else {

			service.savePhysician(physician);
			return new ModelAndView("home","homepagemessage","Physician added successfully");
		}
	}

	@GetMapping("/searchPhysician")
	public ModelAndView searchPhysicianPage(@ModelAttribute("searchPhysician") SearchPhysician searchPhysician,
			HttpSession session) {

		boolean adminAccess = session.getAttribute("adminAccess") == null ? false
				: (boolean) session.getAttribute("adminAccess");
		if (adminAccess == true) {
			return new ModelAndView("searchPhysician");
		} else {
			return new ModelAndView("redirect:/");
		}

	}

	@PostMapping("/saveSearchPhysician")
	public ModelAndView saveSearchPhysicianPage(
			@Validated @ModelAttribute("searchPhysician") SearchPhysician searchPhysician, BindingResult result,
			Model model) {

		if (result.hasErrors()) {

			return new ModelAndView("searchPhysician");
		} else {

			boolean checkSearchPhysician = service.checkSearchPhysician(searchPhysician, model);
			if (checkSearchPhysician == true) {

				return new ModelAndView("searchPhysicianTable");
			} else {
				model.addAttribute("physicianMessage", "Physician doesnot exist");
				return new ModelAndView("searchPhysician");
			}
		}
	}

}
