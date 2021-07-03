package com.service.banking.model.transaction;

import java.util.Date;

import com.service.banking.utils.DateFormater;

public interface ITransactionModel {
	
	public Double getTotalAmountDr();
	public Integer getLastVoucherNo();
	public Double getVocherNo();
	public Date getCreatedAt();

}
