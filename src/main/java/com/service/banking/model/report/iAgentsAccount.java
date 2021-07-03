package com.service.banking.model.report;

import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;

public interface iAgentsAccount {
	
	//a.AccountNumber, a.created_at, m.name, m.FatherName, m.CurrentAddress, m.PhoneNos, p.Amount ,a.ActiveStatus
	
	public Integer geId();
	public String getAccountNumber();
	public String getCreated_At();
	public String getName();
	public String getFatherName();
	public String getCurrentAddress();
	public String getPhoneNos();
	public String getAmount();
	public String getActiveStatus();
	
	
	

}
