package com.service.banking.model.transaction;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class TransPageDetails implements java.io.Serializable {

public Integer id;	
public String transactionName;  
public String transactionType;  // gst ,memorandum,non gst
public Integer gstPercentage;    // 18%,23%,56%
public String databaseEffected;   // both account,memorandom, only account
public String accountFilter;   //  for single or multiple account selection
public String accountType;     // DDS SD fixed
public Boolean allowMultipleBranch;   // yes or no                
public String supplierType;   // gst supplier or non gst  supplier....
public Boolean tdsDeducted;   // yes or no
public String narration;    // fixed manual
public String member;   // staff,Agent,service provider
public Integer pageOrderNumber;
public Boolean status;
public Date createdAt;


public TransPageDetails() {
	super();
}
public TransPageDetails(Integer id, String transactionName, String transactionType, Integer gstPercentage,
		String databaseEffected, String accountFilter, String accountType, Boolean allowMultipleBranch,
		String supplierType, Boolean tdsDeducted, String narration, String member, Integer pageOrderNumber,
		Boolean status, Date createdAt) {
	super();
	this.id = id;
	this.transactionName = transactionName;
	this.transactionType = transactionType;
	this.gstPercentage = gstPercentage;
	this.databaseEffected = databaseEffected;
	this.accountFilter = accountFilter;
	this.accountType = accountType;
	this.allowMultipleBranch = allowMultipleBranch;
	this.supplierType = supplierType;
	this.tdsDeducted = tdsDeducted;
	this.narration = narration;
	this.member = member;
	this.pageOrderNumber = pageOrderNumber;
	this.status = status;
	this.createdAt = createdAt;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getTransactionName() {
	return transactionName;
}
public void setTransactionName(String transactionName) {
	this.transactionName = transactionName;
}
public String getTransactionType() {
	return transactionType;
}
public void setTransactionType(String transactionType) {
	this.transactionType = transactionType;
}
public Integer getGstPercentage() {
	return gstPercentage;
}
public void setGstPercentage(Integer gstPercentage) {
	this.gstPercentage = gstPercentage;
}
public String getDatabaseEffected() {
	return databaseEffected;
}
public void setDatabaseEffected(String databaseEffected) {
	this.databaseEffected = databaseEffected;
}
public String getAccountFilter() {
	return accountFilter;
}
public void setAccountFilter(String accountFilter) {
	this.accountFilter = accountFilter;
}
public String getAccountType() {
	return accountType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
public Boolean getAllowMultipleBranch() {
	return allowMultipleBranch;
}
public void setAllowMultipleBranch(Boolean allowMultipleBranch) {
	this.allowMultipleBranch = allowMultipleBranch;
}
public String getSupplierType() {
	return supplierType;
}
public void setSupplierType(String supplierType) {
	this.supplierType = supplierType;
}
public Boolean getTdsDeducted() {
	return tdsDeducted;
}
public void setTdsDeducted(Boolean tdsDeducted) {
	this.tdsDeducted = tdsDeducted;
}
public String getNarration() {
	return narration;
}
public void setNarration(String narration) {
	this.narration = narration;
}
public String getMember() {
	return member;
}
public void setMember(String member) {
	this.member = member;
}
public Integer getPageOrderNumber() {
	return pageOrderNumber;
}
public void setPageOrderNumber(Integer pageOrderNumber) {
	this.pageOrderNumber = pageOrderNumber;
}
public Boolean getStatus() {
	return status;
}
public void setStatus(Boolean status) {
	this.status = status;
}
public Date getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}


	
}

