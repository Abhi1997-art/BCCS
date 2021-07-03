package com.service.banking.model.printingModel;

public class PrintFileContentReq {

	String accountNumber;
	Integer contentFileId;
	

	public PrintFileContentReq() {
		super();
	}


	public PrintFileContentReq(String accountNumber, Integer contentFileId) {
		super();
		this.accountNumber = accountNumber;
		this.contentFileId = contentFileId;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public Integer getContentFileId() {
		return contentFileId;
	}


	public void setContentFileId(Integer contentFileId) {
		this.contentFileId = contentFileId;
	}



}
