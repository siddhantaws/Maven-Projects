package com.manh.springrecipes.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

public class Cashier 
{
	@Autowired
	ApplicationEventPublisher eventPublisher;
	
	public void checkout(CheckoutEvent event) 
	{ 
		eventPublisher.publishEvent(event); 
	} 
}
