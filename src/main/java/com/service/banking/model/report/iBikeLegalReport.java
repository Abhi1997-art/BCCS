package com.service.banking.model.report;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public interface iBikeLegalReport {
	
	public Integer getId();
	public String getAccountNumber();
	public String getName();
	public String getPhoneNos();
	public String getFatherName();
	public String getCurrenyAddress();
	public String getLandmark();
	public Double getAmount();
	public Boolean getActiveStatus();
	public String getCreated_At();
	public Integer getMember_No();
	public String getPermanentAddress();
	public Boolean getIsDefaulter();
	public String getBike_surrendered_on();
	public String getBike_surrendered_by();
	public String getDealerName();
	public String getTehsil();
	public Integer getNoOFEmi();
	public String getEmiAmount();
	public String getBike_Auctioned_On();
	public String getLegal_Process_Given_date();
	public String getLegal_Case_Not_Submitted_Reason();
	public String getCheque_Returned_On();
	public String getNotice_Sent_After_Cheque_Returned_On();
	public String getBike_not_sold_reason();
	
	
	
	
	

}
