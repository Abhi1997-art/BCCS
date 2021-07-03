package com.service.banking.model.MadModel;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public interface iMemberInsuDetails {
	
	
	// a.AccountNumber , a.created_at, m.name, m.FatherName, m.CurrentAddress , m.PhoneNos ,m.DOB , m.nominee ,a.relationWithNominee , 
	//a.currentBalanceDr , mi.next_insurance_due_date ,mi.id
	public String getAccountNumber();
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
	public Date getCreatedAt();
	public String getName();
	public String getFatherName();
	public String getCurrentAddress();
	public String getPhoneNos();
	public String getDob();
	public String getNominee();
	public String getReltionWithNominee();
	public String getCurrentBalanceDr();
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
	public Date getNextInsurancedueDate();
	public String getId();
	public String getAccountId();
	

}
