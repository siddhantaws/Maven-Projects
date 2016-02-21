package com.manh.observer;

import java.util.ArrayList;
import java.util.List;

public class NotifactionBroadcast 
{
	private Order order;
	
	private List<Listener> listeners=new ArrayList<Listener>();
	public NotifactionBroadcast(Order order)
	{
		this.order=order;
	}
	
	public void registerListener(Listener listener)
	{
		listeners.add(listener);
	}
	
	public void updateOrder(Order order)
	{
		this.order=order;
		notifyListener();
	}
	private void notifyListener()
	{
		for(Listener listener:listeners)
		{
			listener.update(order);
		}
	}
}
