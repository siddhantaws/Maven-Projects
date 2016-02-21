package com.manh.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {

//	@Value annotation indicates a default value expression for the affected argument.

	@Value("Live your life with Passion!")
	private String somewords;

	@Value("25")
	private int someNumber;

//	Read from property file (see property-placeholder in app-config.xml)	
	@Value("${username}")
	private String username;
	
	@Value("${hobby}")
	private String hobby;

	@RequestMapping("/about")
	public String courtReservation(Model model) {
		model.addAttribute("somewords", somewords);
		model.addAttribute("someNumber", someNumber);
		model.addAttribute("username", username);
		model.addAttribute("hobby", hobby);
	
		return "about";
	}
}