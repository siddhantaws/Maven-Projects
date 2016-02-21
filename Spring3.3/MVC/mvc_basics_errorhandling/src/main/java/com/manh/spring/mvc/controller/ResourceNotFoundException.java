package com.manh.spring.mvc.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceNotFoundException extends RuntimeException {
	
	private Long resourceId;
    private Date date;
    
	public ResourceNotFoundException(Long resourceId) {
		this.resourceId = resourceId;
		date = new Date();
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Long getResourceId() {
		return resourceId;
	}
	
}
