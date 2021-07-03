package com.service.banking.model.hodAuthorityModel;

public class LogCheckModel {
	
	Integer id;
	String name;
	
	
	
	public LogCheckModel() {
		super();
	}
	public LogCheckModel(String name) {
		super();
		//this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
