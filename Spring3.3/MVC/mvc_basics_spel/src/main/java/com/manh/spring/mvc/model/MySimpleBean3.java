package com.manh.spring.mvc.model;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MySimpleBean3 {

	private String city3;

	private int population3;

	public String getCity3() {
		return city3;
	}

	public void setCity3(String city) {
		this.city3 = city;
	}

	public int getPopulation3() {
		return population3;
	}

	public void setPopulation3(int population) {
		this.population3 = population;
	}
}
