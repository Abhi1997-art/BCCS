package com.service.banking.model.hodAuthorityModel;

import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;

public interface iDeleteVoucherDetails {
	//a.AccountNumber , m.name , m.FatherName , tr.amountDr , tr.amountCr, tr.created_at, tr.Narration, tt.name
	

	public String getAccountNumber();
	public String getMemberName();
	public String getFatherName();
	public Double getAmountDr();
	public Double getAmountCr();
	public String getCreatedAt();
	public String getNarration();
	public String getTransactionTypeName();
	public Integer getRelated_account_Id();
	
}
