package com.manh.spring.mvc.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4411446104878349326L;
	
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