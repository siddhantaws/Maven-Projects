package com.manh.serial;

import java.io.Serializable;

public class Address implements Serializable
{	
	private int aid ;
	
	private String street;

	public Address(int aid, String street) 
	{
		super();
		this.aid = aid;
		this.street = street;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	
}
