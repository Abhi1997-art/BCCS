package com.service.banking.model.stockModel;

import java.util.HashSet;
import java.util.Set;



public class StockMemberModel {
	
	public Integer id;
	public String name;
	public String bName;
	public String address;
	public String phNo;
	public String type;
	public Boolean isActive;
	
	
	
	public StockMemberModel(Integer id, String name, String bName, String address, String phNo, String type,
			Boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.bName = bName;
		this.address = address;
		this.phNo = phNo;
		this.type = type;
		this.isActive = isActive;
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
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	

}
