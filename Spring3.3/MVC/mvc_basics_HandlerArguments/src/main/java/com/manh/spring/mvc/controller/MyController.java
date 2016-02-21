package com.manh.spring.mvc.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/helloworld")
public class MyController {

	@RequestMapping(value = "/hello/{helloId}", method = RequestMethod.GET)
	public String helloURI(@PathVariable int helloId, Model model) {
		model.addAttribute("message" + helloId, "message" + helloId + " is selected!");
		
		return "mypage" + helloId;
	}

//	Receive request parameters
	@RequestMapping(value = "/hello/{helloId}", method = RequestMethod.GET, params = "myCity=Boston")
	public String helloURIparams(@PathVariable int helloId, @RequestParam("myCity") String city, Model model) {
		model.addAttribute("message" + helloId, "I live in " + city);
		
		return "mypage" + helloId;
	}
	
	@RequestMapping(value = "/hello/{helloId}", method = RequestMethod.GET, params = "myCity=Seoul")
	public String helloURIparams2(@PathVariable int helloId, @RequestParam("myCity") String city, Model model) {
		model.addAttribute("message" + helloId, "I live in " + city);
		
		return "mypage" + helloId;
	}

//	Receive Locale and HttpServletRequest
	@RequestMapping(value = "/mylocale", method = RequestMethod.GET)
	public String helloObjects(Model model, Locale locale, HttpServletRequest httpServletRequest) {
		model.addAttribute("country", locale.getCountry());
		model.addAttribute("ContextPath", httpServletRequest.getContextPath());
		
		return "mylocale";
	}

//	Display a request header with explicit name
	@RequestMapping(value = "requestHeader1")
	public @ResponseBody String withHeader1(@RequestHeader("Accept") String Accept) {
		return "Obtained 'Accept' header '" + Accept + "'";
	}

//	Display a request header with implicit name
	@RequestMapping(value = "requestHeader2")
	public @ResponseBody String withHeader2(@RequestHeader String Accept) {
		return "Obtained 'Accept' header '" + Accept + "'";
	}
}