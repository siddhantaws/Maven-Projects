package com.manh.springrecipes.shop;

import org.springframework.context.ApplicationListener;

public class CheckoutListenerOne implements ApplicationListener<CheckoutEvent>
{

	@Override
	public void onApplicationEvent(CheckoutEvent checkoutEvent)
	{
		System.out.println("CheckoutListenerOne event [" + checkoutEvent.getAmount() + ", " + checkoutEvent.getTimestamp() + "]");
	}

}
