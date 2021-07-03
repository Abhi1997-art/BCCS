package com.service.banking.model.report;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public interface iDepositeReport {
	
		public Integer getId();
		public String getAccountNumber();
		public String getName();
		public String getPhoneNos();
		public String getFatherName();
		public String getCurrenyAddress();
		public String getLandmark();
		public Double getAmountCr();
		public Double getAmountDr();
		public String getAgentName();
		public String getAgentAccountNumber();
		public String getDepositedOn();
		public String getNarration();
		public String getSchemeName();
		public String getLastPaidOn();
		public String getAmount();
		public String getMaturity();
		public String getDescription();
		public String getAgentPhoneno();
		public String getCreated_At();
		public String getSchemeType();
		public Double getBalance();
		public Boolean getActiveStatus();
		public String getPanNo();
		public Integer getMember_No();
		public String getPermanentAddress();
		public Integer getInActiveRdAccountCount();
		public String getLastRdAccount();
		public Integer getInActiveRdAmountSum();
		public Integer getCode_No();
		public Boolean getIsDefaulter();
		public String getAgentAddress();
		public Boolean getagentDefaulter();
		
		
		
		
}
