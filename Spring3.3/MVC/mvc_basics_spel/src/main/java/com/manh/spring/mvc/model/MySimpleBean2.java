package com.manh.spring.mvc.model;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MySimpleBean2 {

	private String city2;
	
	private int population2;

	public String getCity2() {
		return city2;
	}

	public void setCity2(String city) {
		this.city2 = city;
	}

	public int getPopulation2() {
		return population2;
	}

	public void setPopulation2(int population) {
		this.population2 = population;
	}
}