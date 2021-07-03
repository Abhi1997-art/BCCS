package com.service.banking.model.transaction;

import java.util.Date;
import java.util.List;



import com.service.banking.hibernateEntity.TransactionPage;

public class NewPageReq {
	
	TransactionPage transactionPage;   
	List<PageElementReq> pageElementReqs;
	
	public NewPageReq() {
		super();
	}

	public NewPageReq(TransactionPage transactionPage, List<PageElementReq> pageElementReqs) {
		super();
		this.transactionPage = transactionPage;
		this.pageElementReqs = pageElementReqs;
	}

	public TransactionPage getTransactionPage() {
		return transactionPage;
	}

	public void setTransactionPage(TransactionPage transactionPage) {
		this.transactionPage = transactionPage;
	}

	public List<PageElementReq> getPageElementReqs() {
		return pageElementReqs;
	}

	public void setPageElementReqs(List<PageElementReq> pageElementReqs) {
		this.pageElementReqs = pageElementReqs;
	}

}
