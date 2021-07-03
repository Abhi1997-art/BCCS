package com.service.banking.model.stockModel;

public class StockRowModel {
	int id;
	String rowName;
	String branchName;
	String containerName;
	
	public StockRowModel(int id, String rowName, String branchName, String containerName) {
		super();
		this.id = id;
		this.rowName = rowName;
		this.branchName = branchName;
		this.containerName = containerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRowName() {
		return rowName;
	}

	public void setRowName(String rowName) {
		this.rowName = rowName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getContainerName() {
		return containerName;
	}

	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}
	
	
	
	
	

}
