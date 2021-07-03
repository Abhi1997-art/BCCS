package com.service.banking.model.printingModel;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.id.IntegralDataTypeHolder;

import com.service.banking.utils.DateFormater;

public class AcountDetails {
	

		  public AcountDetails() {
			// TODO Auto-generated constructor stub
		}
	Integer id;
	String accountNumber;
	String nominee;
	Short nomineeAge;
	String relationWithNominee;
	Double amount;
	String lastCurrentInterestUpdatedAt;
	BigDecimal currentBalanceCr;
	String name;
	String fatherName;
	String currentAddress;
	String updatedAt;
	String createdAt;
	Date DOB;
	String phoneNos;
	Integer maturityPeriod;
	String interest;
	String branchName;
	
	public AcountDetails(Integer id, String accountNumber, String nominee, Short nomineeAge, String relationWithNominee,
			Double amount, Date lastCurrentInterestUpdatedAt, BigDecimal currentBalanceCr, String name,
			String fatherName, String currentAddress, Date updatedAt, Date createdAt, Date dOB, String phoneNos,
			Integer maturityPeriod, String interest, String branchName) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.nominee = nominee;
		this.nomineeAge = nomineeAge;
		this.relationWithNominee = relationWithNominee;
		this.amount = amount;
		this.lastCurrentInterestUpdatedAt =DateFormater.getformatDate(lastCurrentInterestUpdatedAt) ;
		this.currentBalanceCr = currentBalanceCr;
		this.name = name;
		this.fatherName = fatherName;
		this.currentAddress = currentAddress;
		this.updatedAt = DateFormater.getformatDate(updatedAt);
		this.createdAt =DateFormater.getformatDate(createdAt);
		DOB = dOB ;
		this.phoneNos = phoneNos;
		this.maturityPeriod = maturityPeriod;
		this.interest = interest;
		this.branchName = branchName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getNominee() {
		return nominee;
	}
	public void setNominee(String nominee) {
		this.nominee = nominee;
	}
	public Short getNomineeAge() {
		return nomineeAge;
	}
	public void setNomineeAge(Short nomineeAge) {
		this.nomineeAge = nomineeAge;
	}
	public String getRelationWithNominee() {
		return relationWithNominee;
	}
	public void setRelationWithNominee(String relationWithNominee) {
		this.relationWithNominee = relationWithNominee;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getLastCurrentInterestUpdatedAt() {
		return lastCurrentInterestUpdatedAt;
	}
	public void setLastCurrentInterestUpdatedAt(String lastCurrentInterestUpdatedAt) {
		this.lastCurrentInterestUpdatedAt = lastCurrentInterestUpdatedAt;
	}
	public BigDecimal getCurrentBalanceCr() {
		return currentBalanceCr;
	}
	public void setCurrentBalanceCr(BigDecimal currentBalanceCr) {
		this.currentBalanceCr = currentBalanceCr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getPhoneNos() {
		return phoneNos;
	}
	public void setPhoneNos(String phoneNos) {
		this.phoneNos = phoneNos;
	}
	public Integer getMaturityPeriod() {
		return maturityPeriod;
	}
	public void setMaturityPeriod(Integer maturityPeriod) {
		this.maturityPeriod = maturityPeriod;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	
	
	
}
