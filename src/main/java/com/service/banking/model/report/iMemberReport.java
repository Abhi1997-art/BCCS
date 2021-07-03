package com.service.banking.model.report;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public interface iMemberReport {
	
	public Integer getId();
	public String getName();
	public String getMember_No();
	public String getBranchName();
	public String getGender();
	public String getFatherName();
	public String getCast();
	public String getRelation();
	public String getCurrentAddress();
	public String getPermanentAddress();
	public String getLandmark();
	public String getTehsil();
	public String getCity();
	public String getPhoneNos();
	public String getCreated_At();
	public Boolean getIs_Active();
	public Boolean getIs_Defaulter();
	public String getComment();
	public String getOccupation();
	public String getBranch_Id();
	public String getTitle();
	public String getRelationWithFatherField();
	public String getSchemeName();
	public String getDefaulter_On();
	
	

}
