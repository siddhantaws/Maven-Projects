package com.manh.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/helloworld")
public class MyController {

	// Select a view through view resolver
	@RequestMapping(value = "/hello/{helloId}", method = RequestMethod.GET)
	public String helloURI(@PathVariable int helloId, Model model) {
		model.addAttribute("message" + helloId, "message" + helloId + " is selected!");
		
		return "mypage" + helloId;
	}

//	Send a response directly to the client
	@RequestMapping(value = "responsebody1")
	public @ResponseBody String withHeader1() {
		String xmlFragment = "<person><name>Sang Shin</name><address>1 dreamland, Boston, MA</address></person>";
		
		return xmlFragment;
	}
	
//	Send a response directly to the client
	@RequestMapping(value = "responsebody2")
	public @ResponseBody String withHeader2() {
		String xmlFragment = "<car><brand>Ford</brand><model>Focus 1.0 Ecoboost 125 HP</model></car>";
		
		return xmlFragment;
	}
}