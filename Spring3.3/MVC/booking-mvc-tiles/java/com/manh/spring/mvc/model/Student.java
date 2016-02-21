package com.manh.spring.mvc.model;

public class Student {

	private String userName;
	
	private String address;
	
	private String password;
	
	private String confirmPassword;
	
	private boolean receiveNewsletter;
	
	private String[] subject;
	
	private String favNumber;
	
	private String sex;

	private String country;
	
	private String springExperiences;

//	hidden value
	private String secretValue;

	public String getSecretValue() {
		return secretValue;
	}

	public void setSecretValue(String secretValue) {
		this.secretValue = secretValue;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isReceiveNewsletter() {
		return receiveNewsletter;
	}

	public void setReceiveNewsletter(boolean receiveNewsletter) {
		this.receiveNewsletter = receiveNewsletter;
	}

	public String[] getSubject() {
		return subject;
	}

	public void setSubject(String[] subject) {
		this.subject = subject;
	}

	public String getFavNumber() {
		return favNumber;
	}

	public void setFavNumber(String favNumber) {
		this.favNumber = favNumber;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSpringExperiences() {
		return springExperiences;
	}

	public void setSpringExperiences(String springExperiences) {
		this.springExperiences = springExperiences;
	}
}