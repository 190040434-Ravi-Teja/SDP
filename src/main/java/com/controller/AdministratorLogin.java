package com.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.model.Administrator;
import com.service.AdministratorLoginServiceInterface;

@Controller
public class AdministratorLogin {

	@Autowired
	AdministratorLoginServiceInterface service;

	@GetMapping("/")
	public ModelAndView registerPage(@ModelAttribute("administrator") Administrator administrator) {

		return new ModelAndView("administratorlogin");
	}

	@PostMapping(value = "/login")
	public ModelAndView administratorLogin(@Valid @ModelAttribute("administrator") Administrator administrator,
			BindingResult result, Model model, HttpSession session) {

		if (result.hasErrors()) {
			return new ModelAndView("administratorlogin");
		} else {
			boolean checkCredential = service.checkCredential(administrator);

			if (checkCredential == true) {
				session.setAttribute("adminAccess", true);
				return new ModelAndView("redirect:home");
			} else {
				model.addAttribute("message", "Invalid username and password");
				return new ModelAndView("administratorlogin");
			}
		}

	}

	@GetMapping(value = "logout")
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("adminAccess");
		return new ModelAndView("redirect:/");
	}
}
