package com.service.banking.model.report;

import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public interface iEmployee {
	
	public Integer getId();
	public String getAccountNumber();
	public String getName();
	public String getFatherName();
	public String getSchemeName();
	public Double getAmountCr();
	public Integer getVoucher_No();
	public String getNarration();
	public String getCreated_At();
	
	

}
