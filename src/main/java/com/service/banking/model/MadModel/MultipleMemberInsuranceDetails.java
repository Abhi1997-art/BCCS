package com.service.banking.model.MadModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MultipleMemberInsuranceDetails {
	
	private Date insuranceStartDate;
	private byte insuranceDuration;
	private String narration;
	private Date nextInsuranceDueDate;
	private Byte isRenew;
	
	List<Integer> accountsId = new ArrayList<Integer>();
	
	
	
	

	public MultipleMemberInsuranceDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public MultipleMemberInsuranceDetails(Date insuranceStartDate, byte insuranceDuration, String narration,
			Date nextInsuranceDueDate, Byte isRenew, List<Integer> accountsId) {
		super();
		this.insuranceStartDate = insuranceStartDate;
		this.insuranceDuration = insuranceDuration;
		this.narration = narration;
		this.nextInsuranceDueDate = nextInsuranceDueDate;
		this.isRenew = isRenew;
		this.accountsId = accountsId;
	}



	public Date getInsuranceStartDate() {
		return insuranceStartDate;
	}

	public void setInsuranceStartDate(Date insuranceStartDate) {
		this.insuranceStartDate = insuranceStartDate;
	}

	public byte getInsuranceDuration() {
		return insuranceDuration;
	}

	public void setInsuranceDuration(byte insuranceDuration) {
		this.insuranceDuration = insuranceDuration;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public Date getNextInsuranceDueDate() {
		return nextInsuranceDueDate;
	}

	public void setNextInsuranceDueDate(Date nextInsuranceDueDate) {
		this.nextInsuranceDueDate = nextInsuranceDueDate;
	}

	public Byte getIsRenew() {
		return isRenew;
	}

	public void setIsRenew(Byte isRenew) {
		this.isRenew = isRenew;
	}

	public List<Integer> getAccountsId() {
		return accountsId;
	}

	public void setAccountsId(List<Integer> accountsId) {
		this.accountsId = accountsId;
	}
	
	
	

}
