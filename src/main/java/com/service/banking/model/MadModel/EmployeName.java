package com.service.banking.model.MadModel;

public class EmployeName {
	
	Integer id;
	String name;
	
	public EmployeName() {
		super();
	}
	
	public EmployeName(Integer id, String name) {
		super();
		this.id = id;
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
