package com.service.banking.model.dashboardModel;

import java.util.Date;

import com.service.banking.utils.DateFormater;

public class LoanSchemaDetails {

	Long totalAccounts;
	Long activeAccounts;

	String schemaType;
	String premiumMode;
	Integer numberOfPremiums;
	Integer id;
	String schemaName;
	String interest;
	Double processingFees;
	String validTill;
	String head;
	Boolean activeStatus;
	Double maxlimits;
	Double minlimits;
	String createdAt;
	Integer panelty;
	Integer paneltyGrace;
	Boolean processingFeesinPercent;

	public LoanSchemaDetails(Long totalAccounts, Long activeAccounts, String schemaType, Integer numberOfPremiums,
			String interest, Double processingFees, Double maxlimits, Double minlimits) {
		super();
		this.totalAccounts = totalAccounts;
		this.activeAccounts = activeAccounts;
		this.schemaType = schemaType;
		this.numberOfPremiums = numberOfPremiums;
		this.interest = interest;
		this.processingFees = processingFees;
		// this.validTill=validTill;
		this.maxlimits = maxlimits;
		this.minlimits = minlimits;
	}

	// Dash-board scheme loan........................................
	public LoanSchemaDetails(Long totalAccounts, Long activeAccounts, Integer id, String schemaType, String schemaName,
			String interest, String premiumMode, Integer numberOfPremiums, Double processingFees, Boolean activeStatus,
			String validTill, Double maxlimits, Double minlimits, String head, Date createdAt) {
		super();
		this.totalAccounts = totalAccounts;
		this.activeAccounts = activeAccounts;
		this.id = id;
		this.schemaType = schemaType;
		this.schemaName = schemaName;
		this.interest = interest;
		this.premiumMode = premiumMode;
		this.numberOfPremiums = numberOfPremiums;
		this.processingFees = processingFees;
		this.activeStatus = activeStatus;
		this.validTill = validTill;
		this.maxlimits = maxlimits;
		this.minlimits = minlimits;
		this.head = head;
		this.createdAt = DateFormater.getformatDate(createdAt);
	}
	
	public LoanSchemaDetails(Long totalAccounts, Long activeAccounts, Integer id, String schemaType, String schemaName,
			String interest, String premiumMode, Integer numberOfPremiums, Double processingFees, Boolean activeStatus,
			String validTill, Double maxlimits, Double minlimits, String head, Date createdAt, Integer panelty, Integer paneltyGrace,Boolean processingFeesinPercent ) {
		super();
		this.totalAccounts = totalAccounts;
		this.activeAccounts = activeAccounts;
		this.id = id;
		this.schemaType = schemaType;
		this.schemaName = schemaName;
		this.interest = interest;
		this.premiumMode = premiumMode;
		this.numberOfPremiums = numberOfPremiums;
		this.processingFees = processingFees;
		this.activeStatus = activeStatus;
		this.validTill = validTill;
		this.maxlimits = maxlimits;
		this.minlimits = minlimits;
		this.head = head;
		this.createdAt = DateFormater.getformatDate(createdAt);
		this.panelty=panelty;
		this.paneltyGrace=paneltyGrace;
		this.processingFeesinPercent=processingFeesinPercent;
	}
	
	

	public LoanSchemaDetails() {
		super();
	}

	public Integer getNumberOfPremiums() {
		return numberOfPremiums;
	}

	public void setNumberOfPremiums(Integer numberOfPremiums) {
		this.numberOfPremiums = numberOfPremiums;
	}

	public Boolean getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Boolean activeStatus) {
		this.activeStatus = activeStatus;
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

	public String getSchemaType() {
		return schemaType;
	}

	public void setSchemaType(String schemaType) {
		this.schemaType = schemaType;
	}

	public String getPremiumMode() {
		return premiumMode;
	}

	public void setPremiumMode(String premiumMode) {
		this.premiumMode = premiumMode;
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

	public Integer getPanelty() {
		return panelty;
	}

	public void setPanelty(Integer panelty) {
		this.panelty = panelty;
	}

	public Integer getPaneltyGrace() {
		return paneltyGrace;
	}

	public void setPaneltyGrace(Integer paneltyGrace) {
		this.paneltyGrace = paneltyGrace;
	}

	public Boolean getProcessingFeesinPercent() {
		return processingFeesinPercent;
	}

	public void setProcessingFeesinPercent(Boolean processingFeesinPercent) {
		this.processingFeesinPercent = processingFeesinPercent;
	}

	
}
