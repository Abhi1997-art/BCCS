package com.service.banking.model.stockModel;

public class StockItemModel {
	
	int id;
	String itemName;
	String catName;
	String branchName; 
	 String description;
	 Boolean isConsumable;
	 Boolean isIssueable;
	 Boolean isFixedassets;
	 Boolean isActive;
	 
	 
	 
	public StockItemModel(int id, String itemName, String catName, String branchName, String description,
			Boolean isConsumable, Boolean isIssueable, Boolean isFixedassets, Boolean isActive) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.catName = catName;
		this.branchName = branchName;
		this.description = description;
		this.isConsumable = isConsumable;
		this.isIssueable = isIssueable;
		this.isFixedassets = isFixedassets;
		this.isActive = isActive;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getIsConsumable() {
		return isConsumable;
	}
	public void setIsConsumable(Boolean isConsumable) {
		this.isConsumable = isConsumable;
	}
	public Boolean getIsIssueable() {
		return isIssueable;
	}
	public void setIsIssueable(Boolean isIssueable) {
		this.isIssueable = isIssueable;
	}
	public Boolean getIsFixedassets() {
		return isFixedassets;
	}
	public void setIsFixedassets(Boolean isFixedassets) {
		this.isFixedassets = isFixedassets;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
	
	
}

