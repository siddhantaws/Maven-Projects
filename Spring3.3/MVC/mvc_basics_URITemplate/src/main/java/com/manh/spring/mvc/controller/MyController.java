package com.manh.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/helloworld")
public class MyController {

//	Handle URI template, receive it as a String type
	@RequestMapping(value = "/helloString/{helloId}", method = RequestMethod.GET)
	public String helloURITemplate(@PathVariable String helloId, Model model) {
		model.addAttribute("message" + helloId, "message" + helloId + " is selected!");
		
		return "mypage" + helloId;
	}

//	Handle URI template, receive it as a int type
	@RequestMapping(value = "/helloint/{helloId}", method = RequestMethod.GET)
	public String helloURITemplate2(@PathVariable int helloId, Model model) {
		model.addAttribute("message" + helloId, "message" + helloId + " is selected!");
		
		return "mypage" + helloId;
	}

//	Handle URI template, receive it as a int type
	@RequestMapping(value = "/helloint/{helloId}/{number}", method = RequestMethod.GET)
	public String helloURITemplate3(@PathVariable int helloId, @PathVariable int number, Model model) {
		int result = helloId + number;
		model.addAttribute("message" + helloId, "message" + helloId	+ " is selected!");
		model.addAttribute("mynumber", result);
		
		return "mypage" + helloId;
	}
	
//	Handle URI template, receive it as a int type followed by a string type
	@RequestMapping(value = "/helloString/{helloId}/{greeting}", method = RequestMethod.GET)
	public String helloURITemplate4(@PathVariable int helloId, @PathVariable String greeting, ModelMap model) {
		model
			.addAttribute("message" + helloId, "message" + helloId + " is selected!")
			.addAttribute("mygreeting", "Greeting message is " + greeting);
		
		return "mypage" + helloId;
	}
}