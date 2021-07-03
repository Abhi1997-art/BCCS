package com.service.banking.model.hodAuthorityModel;

import java.math.BigDecimal;
import java.util.Date;

public class PremiumDetails {

	private Integer id;
	private String accountNumber;
	private String name;
	private String fatherName;
	private String amount;
	private Integer paid;
	private Boolean skipped;
	private Date dueDate;
	private Date paidOn;
	private Boolean agentCommissionSend;
	private Double agentCommissionPercentage;
	private Boolean agentCollectionChargesSend;
	private BigDecimal agentCollectionChargesPercentage;
	private BigDecimal paneltyCharged;
	private BigDecimal paneltyPosted;
	private Date createdAt;
	private Date updatedAt;

	public PremiumDetails() {
		super();
	}
	
	

	public PremiumDetails(String amount, Integer paid) {
		super();
		this.amount = amount;
		this.paid = paid;
	}
	
	



	public PremiumDetails(String amount, Integer paid, Date paidOn) {
		super();
		this.amount = amount;
		this.paid = paid;
		this.paidOn = paidOn;
	}



	public PremiumDetails(Integer id, String accountNumber, String name, String fatherName, String amount, Integer paid,
			Boolean skipped, Date dueDate, Date paidOn, Boolean agentCommissionSend, Double agentCommissionPercentage,
			Boolean agentCollectionChargesSend, BigDecimal agentCollectionChargesPercentage, BigDecimal paneltyCharged,
			BigDecimal paneltyPosted, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.name = name;
		this.fatherName = fatherName;
		this.amount = amount;
		this.paid = paid;
		this.skipped = skipped;
		this.dueDate = dueDate;
		this.paidOn = paidOn;
		this.agentCommissionSend = agentCommissionSend;
		this.agentCommissionPercentage = agentCommissionPercentage;
		this.agentCollectionChargesSend = agentCollectionChargesSend;
		this.agentCollectionChargesPercentage = agentCollectionChargesPercentage;
		this.paneltyCharged = paneltyCharged;
		this.paneltyPosted = paneltyPosted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the paid
	 */
	public Integer getPaid() {
		return paid;
	}

	/**
	 * @param paid the paid to set
	 */
	public void setPaid(Integer paid) {
		this.paid = paid;
	}

	/**
	 * @return the skipped
	 */
	public Boolean getSkipped() {
		return skipped;
	}

	/**
	 * @param skipped the skipped to set
	 */
	public void setSkipped(Boolean skipped) {
		this.skipped = skipped;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the paidOn
	 */
	public Date getPaidOn() {
		return paidOn;
	}

	/**
	 * @param paidOn the paidOn to set
	 */
	public void setPaidOn(Date paidOn) {
		this.paidOn = paidOn;
	}

	/**
	 * @return the agentCommissionSend
	 */
	public Boolean getAgentCommissionSend() {
		return agentCommissionSend;
	}

	/**
	 * @param agentCommissionSend the agentCommissionSend to set
	 */
	public void setAgentCommissionSend(Boolean agentCommissionSend) {
		this.agentCommissionSend = agentCommissionSend;
	}

	/**
	 * @return the agentCommissionPercentage
	 */
	public Double getAgentCommissionPercentage() {
		return agentCommissionPercentage;
	}

	/**
	 * @param agentCommissionPercentage the agentCommissionPercentage to set
	 */
	public void setAgentCommissionPercentage(Double agentCommissionPercentage) {
		this.agentCommissionPercentage = agentCommissionPercentage;
	}

	/**
	 * @return the agentCollectionChargesSend
	 */
	public Boolean getAgentCollectionChargesSend() {
		return agentCollectionChargesSend;
	}

	/**
	 * @param agentCollectionChargesSend the agentCollectionChargesSend to set
	 */
	public void setAgentCollectionChargesSend(Boolean agentCollectionChargesSend) {
		this.agentCollectionChargesSend = agentCollectionChargesSend;
	}

	/**
	 * @return the agentCollectionChargesPercentage
	 */
	public BigDecimal getAgentCollectionChargesPercentage() {
		return agentCollectionChargesPercentage;
	}

	/**
	 * @param agentCollectionChargesPercentage the agentCollectionChargesPercentage
	 *                                         to set
	 */
	public void setAgentCollectionChargesPercentage(BigDecimal agentCollectionChargesPercentage) {
		this.agentCollectionChargesPercentage = agentCollectionChargesPercentage;
	}

	/**
	 * @return the paneltyCharged
	 */
	public BigDecimal getPaneltyCharged() {
		return paneltyCharged;
	}

	/**
	 * @param paneltyCharged the paneltyCharged to set
	 */
	public void setPaneltyCharged(BigDecimal paneltyCharged) {
		this.paneltyCharged = paneltyCharged;
	}

	/**
	 * @return the paneltyPosted
	 */
	public BigDecimal getPaneltyPosted() {
		return paneltyPosted;
	}

	/**
	 * @param paneltyPosted the paneltyPosted to set
	 */
	public void setPaneltyPosted(BigDecimal paneltyPosted) {
		this.paneltyPosted = paneltyPosted;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
