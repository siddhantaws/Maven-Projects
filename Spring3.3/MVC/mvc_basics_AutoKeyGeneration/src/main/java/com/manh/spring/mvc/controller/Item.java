package com.manh.spring.mvc.controller;

public class Item {
	private String itemName;
	private double price;
	public Item(String itemName, double price) {
		super();
		this.itemName = itemName;
		this.price = price;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String name) {
		this.itemName = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
