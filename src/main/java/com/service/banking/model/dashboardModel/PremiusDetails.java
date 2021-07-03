package com.service.banking.model.dashboardModel;

import java.math.BigDecimal;
import java.util.Date;

public class PremiusDetails {
	
	private Integer id;
	private Date dueDate;
	private String amount;
	private Integer paid;
	private Date paidOn;
	private Boolean agentCommissionSend;
	private Double agentCommissionPercentage;
	private BigDecimal agentCollectionChargesPercentage;
	private Boolean agentCollectionChargesSend;
	private BigDecimal paneltyCharged;
	private BigDecimal paneltyPosted;
	public PremiusDetails(Integer id, Date dueDate, String amount, Integer paid, Date paidOn,
			Boolean agentCommissionSend, Double agentCommissionPercentage, BigDecimal agentCollectionChargesPercentage,
			Boolean agentCollectionChargesSend, BigDecimal paneltyCharged, BigDecimal paneltyPosted) {
		super();
		this.id = id;
		this.dueDate = dueDate;
		this.amount = amount;
		this.paid = paid;
		this.paidOn = paidOn;
		this.agentCommissionSend = agentCommissionSend;
		this.agentCommissionPercentage = agentCommissionPercentage;
		this.agentCollectionChargesPercentage = agentCollectionChargesPercentage;
		this.agentCollectionChargesSend = agentCollectionChargesSend;
		this.paneltyCharged = paneltyCharged;
		this.paneltyPosted = paneltyPosted;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Integer getPaid() {
		return paid;
	}
	public void setPaid(Integer paid) {
		this.paid = paid;
	}
	public Date getPaidOn() {
		return paidOn;
	}
	public void setPaidOn(Date paidOn) {
		this.paidOn = paidOn;
	}
	public Boolean getAgentCommissionSend() {
		return agentCommissionSend;
	}
	public void setAgentCommissionSend(Boolean agentCommissionSend) {
		this.agentCommissionSend = agentCommissionSend;
	}
	public Double getAgentCommissionPercentage() {
		return agentCommissionPercentage;
	}
	public void setAgentCommissionPercentage(Double agentCommissionPercentage) {
		this.agentCommissionPercentage = agentCommissionPercentage;
	}
	public BigDecimal getAgentCollectionChargesPercentage() {
		return agentCollectionChargesPercentage;
	}
	public void setAgentCollectionChargesPercentage(BigDecimal agentCollectionChargesPercentage) {
		this.agentCollectionChargesPercentage = agentCollectionChargesPercentage;
	}
	public Boolean getAgentCollectionChargesSend() {
		return agentCollectionChargesSend;
	}
	public void setAgentCollectionChargesSend(Boolean agentCollectionChargesSend) {
		this.agentCollectionChargesSend = agentCollectionChargesSend;
	}
	public BigDecimal getPaneltyCharged() {
		return paneltyCharged;
	}
	public void setPaneltyCharged(BigDecimal paneltyCharged) {
		this.paneltyCharged = paneltyCharged;
	}
	public BigDecimal getPaneltyPosted() {
		return paneltyPosted;
	}
	public void setPaneltyPosted(BigDecimal paneltyPosted) {
		this.paneltyPosted = paneltyPosted;
	}
	
	
	

}
