package com.service.banking.model.dashboardModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public interface iAccountDetails {
	
	public Integer getId();
	public String getDocumentName();
	public String getAccountNumber();
	public String getName();
	public String getFatherName();
	public String getDescription();
	public String getDealerName();
	public String getSubmitted_On();
	public String getInsurance_Start_Date();
	public String getNext_Insurance_Due_Date();
	public String getNarration();
	public Integer getCode_No();
	public String getAgentName();
	public String getMember_no();
	public String getPermanentAddress();
	public String getIs_defaulter();
	public String getPhoneNos();
	public String getLandmark();
	public String getCreated_At();
	public String getMaturityDate();
	public String getSchemeName();
	
	
}
