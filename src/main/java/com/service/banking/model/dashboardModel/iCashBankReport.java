package com.service.banking.model.dashboardModel;

public interface iCashBankReport {
	
	public Integer getFirstId();
	public Integer getSecondId();
	public String getAccountNumber();
	public String getOpeningBalance();
	public String getTodaysPayment();
	public String getTodaysReceived();
	public Integer getBank_Account_Limit();
	

}
