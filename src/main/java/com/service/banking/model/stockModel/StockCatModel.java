package com.service.banking.model.stockModel;

public class StockCatModel {
	int id;
	String catName;
	String branchName;
	
	public StockCatModel(int id, String catName, String branchName) {
		super();
		this.id = id;
		this.catName = catName;
		this.branchName = branchName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	
	
	
}
