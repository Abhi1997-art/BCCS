package com.service.banking.model.report;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public interface iLoanReport {

	public Integer getId();
	public String getAccountNumber();
	public String getName();
	public String getFatherName();
	public String getPermanentAddress();
	public String getPhoneNos();
	public String getLoanInsurranceDate();
	public String getInsurance_Tenure();
	public String getDealerName();
	public String getMaturityDate();
	public String getCreated_At();
	public String getCurrentAddress();
	public String getSchemeName();
	public String getNominee();
	public String getMinorNomineeParentName();
	public Double getAmount();
	public Integer getNumberOfPremiums();
	public Integer getDealerId();
	public Integer getCountAccounts();
	public Double getSumAmount();
	
	
}
