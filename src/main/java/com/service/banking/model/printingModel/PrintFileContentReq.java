package com.service.banking.model.printingModel;

import java.util.List;

public class PrintFileContentReq {

	Integer contentFileId;
	String accountNumbers;
	

	public PrintFileContentReq() {
		super();
	}

	public PrintFileContentReq(Integer contentFileId, String accountNumbers) {
		this.contentFileId = contentFileId;
		this.accountNumbers = accountNumbers;
	}

	public Integer getContentFileId() {
		return contentFileId;
	}

	public void setContentFileId(Integer contentFileId) {
		this.contentFileId = contentFileId;
	}

	public String getAccountNumbers() {
		return accountNumbers;
	}

	public void setAccountNumbers(String accountNumbers) {
		this.accountNumbers = accountNumbers;
	}
}
