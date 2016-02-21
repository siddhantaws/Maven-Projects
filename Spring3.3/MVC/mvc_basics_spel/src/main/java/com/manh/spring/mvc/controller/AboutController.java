package com.manh.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manh.spring.mvc.model.MySimpleBean2;
import com.manh.spring.mvc.model.MySimpleBean3;


@Controller
public class AboutController {

//	"messageSource" bean is declared in the "app-config.xml"
//	geMessage(<key>, <Array of arguments>, <locale>
	@Value("#{ messageSource.getMessage('admin.email',null,'de')}")
	private String email;

	@Value("#{ systemProperties['user.country'] }")
	private String defaultCountry;

	@Autowired
	MySimpleBean2 mySimpleBean2;
	
	@Autowired
	MySimpleBean3 mySimpleBean3;

	@RequestMapping("/about")
	public String courtReservation(Model model) {
		model.addAttribute("email", email);
		model.addAttribute("defaultCountry", defaultCountry);
		model.addAttribute("city2", mySimpleBean2.getCity2());
		model.addAttribute("population2", mySimpleBean2.getPopulation2());
		model.addAttribute("city3", mySimpleBean3.getCity3());
		model.addAttribute("population3", mySimpleBean3.getPopulation3());
		
		return "about";
	}
}
