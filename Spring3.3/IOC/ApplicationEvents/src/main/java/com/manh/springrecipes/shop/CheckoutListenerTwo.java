package com.manh.springrecipes.shop;

import org.springframework.context.ApplicationListener;

public class CheckoutListenerTwo implements ApplicationListener<CheckoutEvent>
{

	@Override
	public void onApplicationEvent(CheckoutEvent checkoutEvent)
	{
		System.out.println("CheckoutListenerTwo event [" + checkoutEvent.getAmount() + ", " + checkoutEvent.getTimestamp() + "]");
	}

}
