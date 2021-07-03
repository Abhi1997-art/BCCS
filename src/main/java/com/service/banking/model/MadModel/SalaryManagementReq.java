package com.service.banking.model.MadModel;

import org.hibernate.id.IntegralDataTypeHolder;

public class SalaryManagementReq
{

	Integer branchId;
	String month;
	String year;
	Integer empId;
	
	public SalaryManagementReq() {
		super();
	}

	public SalaryManagementReq(Integer branchId, String month, String year, Integer empId) {
		super();
		this.branchId = branchId;
		this.month = month;
		this.year = year;
		this.empId = empId;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
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

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	
	
}