package com.service.banking.model.stockModel;

public class ItemRequestDetails {
	
	String transactionType;
	String name;
	String toDate;
	String fromDate;


	public ItemRequestDetails() {
		super();
	}

	// for ledger item search
	public ItemRequestDetails(String name, String toDate, String fromDate) {
		super();
		this.name = name;
		this.toDate = toDate;
		this.fromDate = fromDate;
	}

	
	// for transactiopn search
	
	public ItemRequestDetails(String transactionType, String name, String toDate, String fromDate) {
		super();
		this.transactionType = transactionType;
		this.name = name;
		this.toDate = toDate;
		this.fromDate = fromDate;
	}





	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
