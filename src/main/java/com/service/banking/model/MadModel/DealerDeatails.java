package com.service.banking.model.MadModel;

import com.service.banking.hibernateEntity.Dsa;

public class DealerDeatails {

	private Integer id;
	private String name;
	private String address;
	private String loanPaneltyPerDay;
	private String timeOverCharge;
	private String dealerMonthlyDate;
	private String properitorName;
	private String properitorPhoneNo1;
	private String properitorPhoneNo2;
	private String emailId1;
	private String emailId2;
	private String product;
	private Byte activeStatus;
	private String username;
	private String password;
	private String dsName;
	private Integer dsid;
	
	
	public DealerDeatails() {
		super();
	}
	
	
	public DealerDeatails(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public DealerDeatails(Integer id, String name, String address, String loanPaneltyPerDay, String timeOverCharge,
			String dealerMonthlyDate, String properitorName, String properitorPhoneNo1, String properitorPhoneNo2,
			String emailId1, String emailId2, String product, Byte activeStatus, String username, String password,
			String dsName, Integer dsid) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.loanPaneltyPerDay = loanPaneltyPerDay;
		this.timeOverCharge = timeOverCharge;
		this.dealerMonthlyDate = dealerMonthlyDate;
		this.properitorName = properitorName;
		this.properitorPhoneNo1 = properitorPhoneNo1;
		this.properitorPhoneNo2 = properitorPhoneNo2;
		this.emailId1 = emailId1;
		this.emailId2 = emailId2;
		this.product = product;
		this.activeStatus = activeStatus;
		this.username = username;
		this.password = password;
		this.dsName = dsName;
		this.dsid=dsid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLoanPaneltyPerDay() {
		return loanPaneltyPerDay;
	}
	public void setLoanPaneltyPerDay(String loanPaneltyPerDay) {
		this.loanPaneltyPerDay = loanPaneltyPerDay;
	}
	public String getTimeOverCharge() {
		return timeOverCharge;
	}
	public void setTimeOverCharge(String timeOverCharge) {
		this.timeOverCharge = timeOverCharge;
	}
	public String getDealerMonthlyDate() {
		return dealerMonthlyDate;
	}
	public void setDealerMonthlyDate(String dealerMonthlyDate) {
		this.dealerMonthlyDate = dealerMonthlyDate;
	}
	public String getProperitorName() {
		return properitorName;
	}
	public void setProperitorName(String properitorName) {
		this.properitorName = properitorName;
	}
	public String getProperitorPhoneNo1() {
		return properitorPhoneNo1;
	}
	public void setProperitorPhoneNo1(String properitorPhoneNo1) {
		this.properitorPhoneNo1 = properitorPhoneNo1;
	}
	public String getProperitorPhoneNo2() {
		return properitorPhoneNo2;
	}
	public void setProperitorPhoneNo2(String properitorPhoneNo2) {
		this.properitorPhoneNo2 = properitorPhoneNo2;
	}
	public String getEmailId1() {
		return emailId1;
	}
	public void setEmailId1(String emailId1) {
		this.emailId1 = emailId1;
	}
	public String getEmailId2() {
		return emailId2;
	}
	public void setEmailId2(String emailId2) {
		this.emailId2 = emailId2;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Byte getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(Byte activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDsName() {
		return dsName;
	}
	public void setDsName(String dsName) {
		this.dsName = dsName;
	}
	public Integer getDsid() {
		return dsid;
	}
	public void setDsid(Integer dsid) {
		this.dsid = dsid;
	}
	
	
	
	
}
