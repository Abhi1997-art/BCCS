package com.service.banking.model.accountsModel;

import java.math.BigDecimal;
import java.util.Date;

public class OtherAccountDetails {
 
	 //a.id,a.accountNumber,a.createdAt ,m.name ,m.memberNo ,m.currentAddress,m.landmark,M.isDefaulter,schm.name
	 
	    public Integer id;
		public String accountNumber;
		public Date createdAt;
		public String name;
		public Integer memberNo;
		public String currentAddress;
		public String landmark;
		public Boolean Deafulter;
		public String schemaName;
		
		public String accountType;
		public Boolean activeStatus;
		public Integer memberId;
		public Integer schemaId;
		public String PAndLGroup;
		public Integer branchId;
		public Integer staffId;
		
		
		public OtherAccountDetails() {
			super();
		}
		public OtherAccountDetails(Integer id, String accountNumber, Date createdAt, String name,
				Integer memberNo, String currentAddress, String landmark, Boolean deafulter, String schemaName, String accountType, Boolean activeStatus) {
			super();
			this.id = id;
			this.accountNumber = accountNumber;
			this.createdAt = createdAt;
			this.name = name;
			this.memberNo = memberNo;
			this.currentAddress = currentAddress;
			this.landmark = landmark;
			Deafulter = deafulter;
			this.schemaName = schemaName;
			this.accountType = accountType;
			this.activeStatus = activeStatus;
		}
		
		
		public OtherAccountDetails(Integer id, String accountNumber, Date createdAt, String name,
				Integer memberNo, String currentAddress, String landmark, Boolean deafulter, String schemaName,
				String accountType, Boolean activeStatus, Integer memberId, Integer schemaId, String pAndLGroup) {
			super();
			this.id = id;
			this.accountNumber = accountNumber;
			this.createdAt = createdAt;
			this.name = name;
			this.memberNo = memberNo;
			this.currentAddress = currentAddress;
			this.landmark = landmark;
			Deafulter = deafulter;
			this.schemaName = schemaName;
			this.accountType = accountType;
			this.activeStatus = activeStatus;
			this.memberId = memberId;
			this.schemaId = schemaId;
			PAndLGroup = pAndLGroup;
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
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getMemberNo() {
			return memberNo;
		}
		public void setMemberNo(Integer memberNo) {
			this.memberNo = memberNo;
		}
		public String getCurrentAddress() {
			return currentAddress;
		}
		public void setCurrentAddress(String currentAddress) {
			this.currentAddress = currentAddress;
		}
		public String getLandmark() {
			return landmark;
		}
		public void setLandmark(String landmark) {
			this.landmark = landmark;
		}
		public Boolean getDeafulter() {
			return Deafulter;
		}
		public void setDeafulter(Boolean deafulter) {
			Deafulter = deafulter;
		}
		public String getSchemaName() {
			return schemaName;
		}
		public void setSchemaName(String schemaName) {
			this.schemaName = schemaName;
		}
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		public Boolean getActiveStatus() {
			return activeStatus;
		}
		public void setActiveStatus(Boolean activeStatus) {
			this.activeStatus = activeStatus;
		}
		public Integer getMemberId() {
			return memberId;
		}
		public void setMemberId(Integer memberId) {
			this.memberId = memberId;
		}
		public Integer getSchemaId() {
			return schemaId;
		}
		public void setSchemaId(Integer schemaId) {
			this.schemaId = schemaId;
		}
		public String getPAndLGroup() {
			return PAndLGroup;
		}
		public void setPAndLGroup(String pAndLGroup) {
			PAndLGroup = pAndLGroup;
		}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
}