package com.service.banking.model.report;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public interface iNewLoanMemberInsuranceReport {
	public String getAccountNumber();
	public String getCreated_At();
	public String getTitle();
	public String getName();
	public String getFatherName();
	public String getCurrentAddress();
	public String getPhoneNos();
	public String getDOB();
	public String getNominee();
	public String getRelationWithNominee();
	public String getAmount();
	

}
