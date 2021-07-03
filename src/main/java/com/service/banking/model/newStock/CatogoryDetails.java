package com.service.banking.model.newStock;

public class CatogoryDetails {

	public Integer id;
	public String name;
	public String allowedInTransactions;
	
	
	
	public CatogoryDetails() {
		super();
	}



	public CatogoryDetails(Integer id, String name, String allowedInTransactions) {
		super();
		this.id = id;
		this.name = name;
		this.allowedInTransactions = allowedInTransactions;
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



	public String getAllowedInTransactions() {
		return allowedInTransactions;
	}



	public void setAllowedInTransactions(String allowedInTransactions) {
		this.allowedInTransactions = allowedInTransactions;
	}
	
	
	
}
