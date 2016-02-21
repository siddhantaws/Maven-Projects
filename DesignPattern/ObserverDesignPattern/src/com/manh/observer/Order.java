package com.manh.observer;

public class Order 
{
	private String orderId;
	
	private String orderName;
	
	private int orderQty;

	public Order(String orderId, String orderName, int orderQty) 
	{
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderQty = orderQty;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	
	
}
