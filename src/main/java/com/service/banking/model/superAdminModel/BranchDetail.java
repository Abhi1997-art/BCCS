package com.service.banking.model.superAdminModel;

import java.util.Date;

import com.service.banking.utils.DateFormater;

public class BranchDetail {

	Integer id;
	String name;
	String address;
	String code;
	Byte performClosings;
	Byte sendSms;
	Byte published;
	Byte allowLogin;
	String daily;


	
	public BranchDetail() {
		super();
	}
	
	
	
	public BranchDetail(Integer id) {
		super();
		this.id = id;
	}



	//b.id, b.name, b.address , b.code ,b.allowLogin ,b.performClosings ,b.published, b.sendSMS , c.daily
	public BranchDetail(Integer id, String name, String address, String code, Byte allowLogin, Byte performClosings, Byte published,
			Byte sendSms, Date daily) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.code = code;
		this.performClosings = performClosings;
		this.sendSms = sendSms;
		this.published = published;
		this.allowLogin = allowLogin;
		this.daily = DateFormater.getformatDate(daily);
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Byte getPerformClosings() {
		return performClosings;
	}
	public void setPerformClosings(Byte performClosings) {
		this.performClosings = performClosings;
	}
	public Byte getSendSms() {
		return sendSms;
	}
	public void setSendSms(Byte sendSms) {
		this.sendSms = sendSms;
	}
	public Byte getPublished() {
		return published;
	}
	public void setPublished(Byte published) {
		this.published = published;
	}

	public Byte getAllowLogin() {
		return allowLogin;
	}
	public void setAllowLogin(Byte allowLogin) {
		this.allowLogin = allowLogin;
	}
	public String getDaily() {
		return daily;
	}
	public void setDaily(String daily) {
		this.daily = daily;
	}
}
