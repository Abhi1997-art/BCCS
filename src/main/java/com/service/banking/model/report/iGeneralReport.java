package com.service.banking.model.report;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public interface iGeneralReport {
	
	public Integer getId();
	public String getAccount_Type();
	public String getNumberOfAccounts();
	public String getTotalAmount();
	public String getAccountNumber();
	public String getCreated_At();
	public String getName();
	public String getFatherName();
	public String getPermanentAddress();
	public String getPhoneNos();
	public String getSchemeName();
	public String getMaturedStatus();
	public Integer getMember_No();
	public String getCurrentAddress();
	public Boolean getIs_Defaulter();
	public String getSchemeGroup();
	public String getDealerName();
	public Boolean getActiveStatus();
	public String getClosingBalance();
	
	
	
	
	
	
	

}
