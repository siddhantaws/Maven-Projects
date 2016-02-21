package com.manh.spring.mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/helloworld")
public class MyController{
    
   
    @RequestMapping(method = RequestMethod.GET )
    public String helloWorld(ModelMap modelMap){
 
        modelMap.addAttribute("message1", "JavaPassion.com!");
        return "mypage1";
    }
    
    @RequestMapping(value="/sayspring2", method = RequestMethod.GET)
    public String helloWorld(Map map){
 
        map.put("message2", "Spring!");
        return "mypage2";
    }
   
    @RequestMapping(value="/sayspringmvc", method = RequestMethod.GET)
    public ModelAndView helloWorld(){
 
        ModelAndView modelAndView = new ModelAndView("mypage3");
        modelAndView.addObject("message3", "Spring MVC!");
 
        return modelAndView;
    }

}
