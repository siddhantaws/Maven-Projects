package com.manh.spring.mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/helloworld")
public class MyController {

//	Handles /helloworld
	@RequestMapping(method = RequestMethod.GET)
//	Return type is String
//	Receives ModelMap type model object as argument
	public String helloWorld(ModelMap modelMap) {
		modelMap.addAttribute("message1", "JavaPassion.com!");
		
		return "mypage1";
	}

//	Handles /helloworld/sayspring
	@RequestMapping(value = "/sayspring", method = RequestMethod.GET)
//	Return type is String
//	Receives Map type model object as argument
	public String helloWorld(Map<String, String> map) {
		map.put("message2", "Spring!");

		return "mypage2";
	}

//	Handles /helloworld/sayspringmvc
	@RequestMapping(value = "/sayspringmvc", method = RequestMethod.GET)
//	Return type is ModelAndView
//	ModelAndView object is created inside the handler method
	public ModelAndView helloWorld() {
		ModelAndView modelAndView = new ModelAndView("mypage3");
		modelAndView.addObject("message3", "Spring MVC!");

		return modelAndView;
	}

//	Handles /helloworld/sayspringcore
	@RequestMapping(value = "/sayspringcore", method = RequestMethod.GET)
//	Return type is String
//	Receives Model type model object as argument
	public String helloWorld(Model model) {
		model.addAttribute("message4", "Spring Core!");
		
		return "mypage4";
	}

//	Handles helloworld/sayspringbatch
	@RequestMapping(value = "/sayspringbatch", method = RequestMethod.GET)
//	Because the return type is "void", the value of the URL,
//	"/helloworld/sayspringbatch" is set as logical view name,
//	which in turn results in displaying "/helloworld/sayspringbatch.jsp".
//	Receives Model type model object as argument
	public void helloWorld2(Model model) {
		model.addAttribute("message5", "Spring Batch!");
	}
	
//	Handles helloworld/sayspringws	
	@RequestMapping(value = "/sayspringws", method = RequestMethod.GET)
    public String helloWorld3(Model model){
        model.addAttribute("message6", "Spring Web Services!");
        
        return "mypage6";
    }
}