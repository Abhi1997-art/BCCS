package com.service.banking.model.accountsModel;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public interface iReceiveNocDetails { 
	
	public Integer getId();
	public String getAccountNumber();
	public String getName();
	public String getNocLetterReceivedOn();
	public String getSendAt();
	public String getCreatedByIdName();
	public String getFromBranchName();
	public String getSendNarration();
	public String getReceivedAt();
	public String getReceivedByIdName();
	public String getToBranchName();
	public String getReceivedNarration();
	public Integer getIsDispatchtoCustomer(); 
	public String getDispatchAt();
	public String getDispatchByIdName();
	public String getDispatchNarration();
	public Integer getIsReturn();
	public String getReturnAt();
	public String getReturnByIdName();
	public String getReturnNarration();
	public String getReturnRecivedName();
	public String getReturnReceivedName();
	public String getNocHoldDueTo();
	public String getNocNotMadeDue();


}
