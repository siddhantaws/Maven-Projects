package com.manh.observer;

public class EmailNotification  extends Listener
{

	public EmailNotification(NotifactionBroadcast broadcast) 
	{
		super(broadcast);
	}

	@Override
	public void update(Order order) 
	{
		show(order);
	}

	@Override
	public void show(Order order)
	{
		System.out.println(order.getOrderId()+"\t"+order.getOrderName());
	}

	
}
