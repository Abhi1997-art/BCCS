package com.service.banking.model.dashboardModel;

import java.util.Date;

import com.service.banking.utils.DateFormater;

public class DefaultSchemaDetails {

	Long totalAccounts;
	Long activeAccounts;
	Integer id;
	String schemaName;
	Byte isDepriciable;
	String depriciationPercentBeforeSep;
	String depriciationPercentAfterSep;
	public String validTill;
	public Boolean activeStatus;
	public Double minLimit;
	public Double maxLimit;
	String head;
	String createdAt;

	public DefaultSchemaDetails() {
		super();
	}

	public DefaultSchemaDetails(Long totalAccounts, Long activeAccounts, Integer id, String schemaName,
			Byte isDepriciable, String depriciationPercentBeforeSep, String depriciationPercentAfterSep,
			String validTill, Boolean activeStatus, Double minLimit, Double maxLimit, String head, Date createdAt) {
		super();
		this.totalAccounts = totalAccounts;
		this.activeAccounts = activeAccounts;
		this.id = id;
		this.schemaName = schemaName;
		this.isDepriciable = isDepriciable;
		this.depriciationPercentBeforeSep = depriciationPercentBeforeSep;
		this.depriciationPercentAfterSep = depriciationPercentAfterSep;
		this.validTill = validTill;
		this.activeStatus = activeStatus;
		this.minLimit = minLimit;
		this.maxLimit = maxLimit;
		this.head = head;
		this.createdAt = DateFormater.getformatDate(createdAt);
	}
	
	

	public DefaultSchemaDetails(Long totalAccounts, Integer id, String schemaName, Byte isDepriciable,
			String depriciationPercentBeforeSep, String depriciationPercentAfterSep, Date validTill,
			Boolean activeStatus, Double minLimit, Double maxLimit, String head, Date createdAt) {
		super();
		this.totalAccounts = totalAccounts;
		this.id = id;
		this.schemaName = schemaName;
		this.isDepriciable = isDepriciable;
		this.depriciationPercentBeforeSep = depriciationPercentBeforeSep;
		this.depriciationPercentAfterSep = depriciationPercentAfterSep;
		this.validTill = DateFormater.getformatDate(validTill);
		this.activeStatus = activeStatus;
		this.minLimit = minLimit;
		this.maxLimit = maxLimit;
		this.head = head;
		this.createdAt = DateFormater.getformatDate(createdAt);
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

	public Byte getIsDepriciable() {
		return isDepriciable;
	}

	public void setIsDepriciable(Byte isDepriciable) {
		this.isDepriciable = isDepriciable;
	}

	public String getDepriciationPercentBeforeSep() {
		return depriciationPercentBeforeSep;
	}

	public void setDepriciationPercentBeforeSep(String depriciationPercentBeforeSep) {
		this.depriciationPercentBeforeSep = depriciationPercentBeforeSep;
	}

	public String getDepriciationPercentAfterSep() {
		return depriciationPercentAfterSep;
	}

	public void setDepriciationPercentAfterSep(String depriciationPercentAfterSep) {
		this.depriciationPercentAfterSep = depriciationPercentAfterSep;
	}

	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}

	public Double getMinLimit() {
		return minLimit;
	}

	public void setMinLimit(Double minLimit) {
		this.minLimit = minLimit;
	}

	public Double getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(Double maxLimit) {
		this.maxLimit = maxLimit;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	
}
