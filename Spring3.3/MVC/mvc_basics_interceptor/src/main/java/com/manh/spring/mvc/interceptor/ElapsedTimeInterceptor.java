package com.manh.spring.mvc.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ElapsedTimeInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(ElapsedTimeInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception {
		logger.info("ElapsedTimeInterceptor: preHandle() entered");
		System.out.println("ElapsedTimeInterceptor:preHandle");
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) 
			throws Exception {
		System.out.println("ElapsedTimeInterceptor:postHandle");
		long startTime = (Long) request.getAttribute("startTime");
		request.removeAttribute("startTime");
		long endTime = System.currentTimeMillis();
		// model.addAttribute("handlingTime", endTime - startTime);
		modelAndView.addObject("handlingTime", endTime - startTime);
		logger.info("ElapsedTimeInterceptor: postHandle() exiting");
	}
}
