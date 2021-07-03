package com.service.banking.model.stockModel;

public class StockContainerModel {
	
	int id;
	String name;
	String branchName;
	
	public StockContainerModel(int id, String name, String branchName) {
		super();
		this.id = id;
		this.name = name;
		this.branchName = branchName;
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
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	

}
