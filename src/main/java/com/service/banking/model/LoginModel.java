package com.service.banking.model;

public class LoginModel {

	String userName;
	String password;

	
	
	public LoginModel() {
		super();
	}

	public LoginModel(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
