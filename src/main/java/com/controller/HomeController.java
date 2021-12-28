package com.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping(value = "/home")
	public ModelAndView patientEnroll(HttpSession session) {
		boolean adminAccess = session.getAttribute("adminAccess") == null ? false
				: (boolean) session.getAttribute("adminAccess");
		if (adminAccess == true) {
			return new ModelAndView("home");
		} else {
			return new ModelAndView("redirect:/");
		}

	}
}
