package com.service.banking.model.dashboardModel;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.service.banking.utils.DateFormater;

public class CCSchemaDetails {

	Long totalAccounts;
	Long activeAccounts;
	Integer id;
	String schemaName;
	String interest;
	Double processingFees;
	Boolean activeStatus;
	String validTill;
	String head;
	Double maxlimits;
	Double minlimits;
	String createdAt;
	Boolean processingFeesinPercent;
	Integer headId;

	public CCSchemaDetails() {
		super();
	}

	public CCSchemaDetails(Long totalAccounts, Long activeAccounts, Integer id, String schemaName, String interest,
			Double processingFees, String validTill, Boolean activeStatus, Double maxlimits, Double minlimits,
			String head, Date createdAt) {
		super();
		this.totalAccounts = totalAccounts;
		this.activeAccounts = activeAccounts;
		this.id = id;
		this.schemaName = schemaName;
		this.interest = interest;
		this.processingFees = processingFees;
		this.validTill = validTill;
		this.activeStatus = activeStatus;
		this.maxlimits = maxlimits;
		this.minlimits = minlimits;
		this.head = head;
		this.createdAt = DateFormater.getformatDate(createdAt);
	}
	
	public CCSchemaDetails(Long totalAccounts, Long activeAccounts, Integer id, String schemaName, String interest,
			Double processingFees, String validTill, Boolean activeStatus, Double maxlimits, Double minlimits,
			String head, Date createdAt,Boolean processingFeesinPercent, Integer headId) {
		super();
		this.totalAccounts = totalAccounts;
		this.activeAccounts = activeAccounts;
		this.id = id;
		this.schemaName = schemaName;
		this.interest = interest;
		this.processingFees = processingFees;
		this.validTill = validTill;
		this.activeStatus = activeStatus;
		this.maxlimits = maxlimits;
		this.minlimits = minlimits;
		this.head = head;
		this.createdAt = DateFormater.getformatDate(createdAt);
		this.processingFeesinPercent=processingFeesinPercent;
		this.headId=headId;
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

	public Double getProcessingFees() {
		return processingFees;
	}

	public void setProcessingFees(Double processingFees) {
		this.processingFees = processingFees;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		// this.validTill=DateFormater.gettDate();
		this.validTill = validTill;
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

	public Boolean getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Boolean getProcessingFeesinPercent() {
		return processingFeesinPercent;
	}

	public void setProcessingFeesinPercent(Boolean processingFeesinPercent) {
		this.processingFeesinPercent = processingFeesinPercent;
	}

	public Integer getHeadId() {
		return headId;
	}

	public void setHeadId(Integer headId) {
		this.headId = headId;
	}
	

}
