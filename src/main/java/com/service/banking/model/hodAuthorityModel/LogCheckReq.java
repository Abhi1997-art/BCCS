package com.service.banking.model.hodAuthorityModel;

public class LogCheckReq {
	
	
	String modelName;
	String toDate;
	String fromDate;
	Integer primaryKey;
	

	public LogCheckReq() {
		super();
	}
	
	public LogCheckReq(String modelName, String toDate, String fromDate, Integer primaryKey) {
		super();
		this.modelName = modelName;
		this.toDate = toDate;
		this.fromDate = fromDate;
		this.primaryKey = primaryKey;
	}
	
	
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
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
	public Integer getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(Integer primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	
	

}
