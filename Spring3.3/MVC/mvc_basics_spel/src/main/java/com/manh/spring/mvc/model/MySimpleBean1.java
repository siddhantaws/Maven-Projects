package com.manh.spring.mvc.model;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MySimpleBean1 {

	private String city;
	
	private int population;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
}
