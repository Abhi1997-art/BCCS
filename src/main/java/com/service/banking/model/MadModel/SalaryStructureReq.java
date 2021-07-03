package com.service.banking.model.MadModel;

public class SalaryStructureReq {
	
	String month;
	String year;
	
	public SalaryStructureReq(String month, String year) {
		super();
		this.month = month;
		this.year = year;
	}

	public SalaryStructureReq() {
		super();
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	

}
