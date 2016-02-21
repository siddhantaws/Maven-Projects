package com.manh.spring.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ContextPathInterceptor extends HandlerInterceptorAdapter {

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
    		throws Exception {
		System.out.println("ContextPathInterceptor:preHandle");
    	request.setAttribute("contextPath", request.getContextPath());
        
    	return true;
    }
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) 
			throws Exception {
		System.out.println("ContextPathInterceptor:postHandle");
		modelAndView.addObject("contextPath", (String) request.getAttribute("contextPath"));
		request.removeAttribute("contextPath");
	}
}
