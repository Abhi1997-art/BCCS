package com.service.banking.model.printingModel;

import java.util.Date;

public class ShareAccountDetail {
	
	//a.id, m.name,a.AccountNumber, count( DISTINCT s.id) as sharenumber,a.created_at
	 Integer id;
	 String name;
	String accountNumber;
	
	Long sharenumber;
	Date creteDate;
	
	
	
	public ShareAccountDetail(Integer id, String name, String accountNumber, Long sharenumber, Date creteDate) {
		super();
		this.id = id;
		this.name = name;
		this.accountNumber = accountNumber;
		this.sharenumber = sharenumber;
		this.creteDate = creteDate;
	}

	public ShareAccountDetail() {
		super();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Long getSharenumber() {
		return sharenumber;
	}
	public void setSharenumber(Long sharenumber) {
		this.sharenumber = sharenumber;
	}
	public Date getCreteDate() {
		return creteDate;
	}
	public void setCreteDate(Date creteDate) {
		this.creteDate = creteDate;
	}
	
	
	
	

}
