package com.service.banking.model.stockModel;

public class LedgerReqModel {
	
	String name;
	String itemName;
	String toDate;
	String fromDate;
	
	public LedgerReqModel(String name, String itemName, String toDate, String fromDate) {
		super();
		this.name = name;
		this.itemName = itemName;
		this.toDate = toDate;
		this.fromDate = fromDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	
	


}
