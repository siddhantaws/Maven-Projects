package com.manh.observer;

public abstract class Listener implements DisplayElement
{
	private NotifactionBroadcast broadcast;
	
	
	public Listener(NotifactionBroadcast broadcast) 
	{
		super();
		this.broadcast = broadcast;
		broadcast.registerListener(this);
	}


	public abstract void update(Order order);
	
	public abstract void show(Order order) ;
}
