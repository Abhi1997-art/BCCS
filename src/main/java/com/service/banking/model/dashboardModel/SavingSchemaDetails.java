package com.service.banking.model.dashboardModel;

import java.util.Date;

import com.service.banking.utils.DateFormater;

public class SavingSchemaDetails {

	Long totalAccounts;
	Long activeAccounts;
	Integer id;
	String schemaName;
	String interest;
	String validTill;
	String accountType;
	Double maxlimits;
	Double minlimits;
	String createdAt;
	Integer headId;
	String head;

	public SavingSchemaDetails() {
		super();
	}

	public SavingSchemaDetails(Long totalAccounts, Long activeAccounts, Integer id, String schemaName, String interest,
			String accountType, String validTill, Double maxlimits, Double minlimits, Date createdAt, Integer headId, String head) {
		super();
		this.totalAccounts = totalAccounts;
		this.activeAccounts = activeAccounts;
		this.id = id;
		this.schemaName = schemaName;
		this.interest = interest;
		this.accountType = accountType;
		this.validTill = validTill;
		this.maxlimits = maxlimits;
		this.minlimits = minlimits;
		this.createdAt = DateFormater.getformatDate(createdAt);
		this.headId=headId;
		this.head= head;
	}
	

	public Integer getHeadId() {
		return headId;
	}

	public void setHeadId(Integer headId) {
		this.headId = headId;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public Long getTotalAccounts() {
		return totalAccounts;
	}

	public void setTotalAccounts(Long totalAccounts) {
		this.totalAccounts = totalAccounts;
	}

	public Long getActiveAccounts() {
		return activeAccounts;
	}

	public void setActiveAccounts(Long activeAccounts) {
		this.activeAccounts = activeAccounts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getMaxlimits() {
		return maxlimits;
	}

	public void setMaxlimits(Double maxlimits) {
		this.maxlimits = maxlimits;
	}

	public Double getMinlimits() {
		return minlimits;
	}

	public void setMinlimits(Double minlimits) {
		this.minlimits = minlimits;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}
