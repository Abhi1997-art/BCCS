package com.service.banking.model.GstModel;

import java.io.Serializable;
import java.util.Date;

public class SupplierDetails implements Serializable {
	
	
	public Integer id;
	public String name;
	public String organization;
	public String gstin;
	public String emailIds;
	public String phoneNos;
	public String address;
	public Date createdAt;
	public Byte isActive;
	
	public String branchName;
     public  String bnchCode;	
	
     
     

	public SupplierDetails(Integer id, String name, String organization, String gstin, String emailIds, String phoneNos,
			String address, Date createdAt, Byte isActive, String branchName, String bnchCode) {
		super();
		this.id = id;
		this.name = name;
		this.organization = organization;
		this.gstin = gstin;
		this.emailIds = emailIds;
		this.phoneNos = phoneNos;
		this.address = address;
		this.createdAt = createdAt;
		this.isActive = isActive;
		this.branchName = branchName;
		this.bnchCode = bnchCode;
	}


	public SupplierDetails() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOrganization() {
		return organization;
	}


	public void setOrganization(String organization) {
		this.organization = organization;
	}


	public String getGstin() {
		return gstin;
	}


	public void setGstin(String gstin) {
		this.gstin = gstin;
	}


	public String getEmailIds() {
		return emailIds;
	}


	public void setEmailIds(String emailIds) {
		this.emailIds = emailIds;
	}


	public String getPhoneNos() {
		return phoneNos;
	}


	public void setPhoneNos(String phoneNos) {
		this.phoneNos = phoneNos;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Byte getIsActive() {
		return isActive;
	}


	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public String getBnchCode() {
		return bnchCode;
	}


	public void setBnchCode(String bnchCode) {
		this.bnchCode = bnchCode;
	}

	
	
	
}
