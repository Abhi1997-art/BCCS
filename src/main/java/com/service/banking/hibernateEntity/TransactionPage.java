package com.service.banking.hibernateEntity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

import net.bytebuddy.asm.Advice.This;

@Entity
@Table(name = "transaction_page")
public class TransactionPage implements java.io.Serializable {

	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id", unique = true, nullable = false)	
private Integer id;

@Column(name = "transName" , length = 70)	
private String transactionName;

@Column(name = "transType" , length = 70)   // gst ,memorandum,non gst
private String transactionType;

@Column(name = "gst_Percentage" , length = 45)  
private Integer gstPercentage;    // 18%,23%,56%

@Column(name = "databasEffected", length = 20)  
private String databaseEffected;   // both account,memorandom, only account

@Column(name = "accountFilter" , length = 80)  
private String accountFilter;   //  for single or multiple account selection

@Column(name = "accountType", length = 70)  
private String accountType;     // DDS SD fixed

@Column(name = "allowMultipleBranch", length = 20)  
 private Boolean allowMultipleBranch;   // yes or no                

@Column(name = "supplierType", length = 70)  
 private String supplierType;   // gst supplier or non gst  supplier....

@Column(name = "tds_deducted", length = 11)  
 private Boolean tdsDeducted;   // yes or no

@Column(name = "narration" , length = 70)  
 private String narration;    // fixed manual

@Column(name = "member", length = 70)  
 private String member;   // staff,Agent,service provider

@Column(name = "pageOrderNumber", length = 70)  
 private Integer pageOrderNumber;

@Column(name = "status", length = 11)  
private Boolean status;

@Temporal(TemporalType.TIMESTAMP)
@Column(name = "created_at", length = 19)
public Date createdAt;


public TransactionPage() {
	super();
}


public TransactionPage(Integer id, String transactionName, String transactionType, Integer gstPercentage,
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

public TransactionPage(String transactionName, String transactionType, Integer gstPercentage, String databaseEffected,
		String accountFilter, String accountType, Boolean allowMultipleBranch, String supplierType, Boolean tdsDeducted,
		String narration, String member, Integer pageOrderNumber, Boolean status, Date createdAt) {
	super();
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