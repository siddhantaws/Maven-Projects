package com.manh.serial;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * 
	*/
	private static final long serialVersionUID = 8614350331710036173L;

	private int id;
	
	private String name;
	
	private Address address;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "ID ->"+getId() +" Name ->"+getName()+" Address ->"+getAddress().getStreet();
	}
}
