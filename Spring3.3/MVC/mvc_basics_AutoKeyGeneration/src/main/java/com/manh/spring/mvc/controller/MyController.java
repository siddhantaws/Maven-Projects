package com.manh.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/helloworld")
public class MyController {

//	Automatic key generation for ModelMap attribute
	@RequestMapping(value = "/automaticKeyGeneration_ModelMap", method = RequestMethod.GET)
	public String handleRequest1(ModelMap modelMap) {
		List<Item> cartItems = new ArrayList<Item>();
		cartItems.add(new Item("Apple", 10.0));
		cartItems.add(new Item("Orange", 20.0));

		User user = new User("Sang Shin");

//		This is the same as modelMap.addAttribute("itemList", cartItems);
//		"itemList" is automatically generated as a key
		modelMap.addAttribute(cartItems); 

//		This is the same as modelMap.addAttribute("user", user);
//	    "user" is automatically generated as a key
		modelMap.addAttribute(user);

		return "shoppingCart";
	}

//	Automatic key generation for ModelAndView attribute
	@RequestMapping(value = "/automaticKeyGeneration_ModelAndView", method = RequestMethod.GET)
//	Return type is ModelAndView
//	ModelAndView object is created inside the handler method
	public ModelAndView handleRequest2() {
		List<Item> cartItems = new ArrayList<Item>();
		cartItems.add(new Item("Apple", 10.0));
		cartItems.add(new Item("Orange", 20.0));

		User user = new User("Sang Shin");

//		shoppingCart2 is logical view name
		ModelAndView mav = new ModelAndView("shoppingCart2");

//		This is the same as mav.addObject("itemList", cartItems);
//		itemList is automatically generated as a key
		mav.addObject(cartItems);

//		This is the same as mav.addObject("user", user);
//		user is automatically generated as a key
		mav.addObject(user);

		return mav;
	}

//	Automatic view generation on ModelandView
	@RequestMapping(value = "/automaticViewGeneration", method = RequestMethod.GET)
//	Return type is ModelAndView
//	ModelAndView object is created inside the handler method
	public ModelAndView handleRequest3() {
		List<Item> cartItems = new ArrayList<Item>();
		cartItems.add(new Item("Apple", 10.0));
		cartItems.add(new Item("Orange", 20.0));

		User user = new User("Sang Shin");

//		"automaticViewGenerationis" is the logical view because view was not set explicitly
		ModelAndView mav = new ModelAndView();

//		This is the same as mav.addObject("itemList", cartItems);
//		itemList is automatically generated as a key
		mav.addObject(cartItems);

//		This is the same as mav.addObject("user", user);
//		user is automatically generated as a key
		mav.addObject(user);

		return mav;
	}

//	Another way of creating model attribute of collection object
	@ModelAttribute("itemList2")
	@RequestMapping(method = RequestMethod.GET)
	public List<Item> populateSubjectList() {
		List<Item> cartItems = new ArrayList<Item>();
		cartItems.add(new Item("Apple iPad", 150.0));
		cartItems.add(new Item("SamSung Galaxy", 200.0));

		return cartItems;
	}
	
	@RequestMapping(value ="/automaticViewGeneration2", method = RequestMethod.GET)
	public ModelMap handleStudents() {
		ModelMap model = new ModelMap();
		
		List<Student> retVal = new ArrayList<Student>();
		retVal.add(new Student(10.0d, "Massimo Manfredino"));
		retVal.add(new Student(20.0d, "Annalisa Galoppo"));
		
		model.addAttribute(retVal);
		
		return model;
	}
}