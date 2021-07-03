package com.service.banking.model.superAdminModel;

import java.util.Date;

public class Branch {
	
	String name;
	String address;
	String code;
	Date daily;

	byte performClosing;
	byte sendSms;
	byte published;
	byte allowLogin;

	public Branch(String name, String address, byte allowLogin) {
		super();
		this.name = name;
		this.address = address;
		this.allowLogin = allowLogin;
	}

	public Branch(String name, String address, String code, Date daily, byte performClosing, byte sendSms,
			byte published, byte allowLogin) {
		super();
		this.name = name;
		this.address = address;
		this.code = code;
		this.daily = daily;
		this.performClosing = performClosing;
		this.sendSms = sendSms;
		this.published = published;
		this.allowLogin = allowLogin;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the daily
	 */
	public Date getDaily() {
		return daily;
	}

	/**
	 * @param daily the daily to set
	 */
	public void setDaily(Date daily) {
		this.daily = daily;
	}

	/**
	 * @return the performClosing
	 */
	public byte getPerformClosing() {
		return performClosing;
	}

	/**
	 * @param performClosing the performClosing to set
	 */
	public void setPerformClosing(byte performClosing) {
		this.performClosing = performClosing;
	}

	/**
	 * @return the sendSms
	 */
	public byte getSendSms() {
		return sendSms;
	}

	/**
	 * @param sendSms the sendSms to set
	 */
	public void setSendSms(byte sendSms) {
		this.sendSms = sendSms;
	}

	/**
	 * @return the published
	 */
	public byte getPublished() {
		return published;
	}

	/**
	 * @param published the published to set
	 */
	public void setPublished(byte published) {
		this.published = published;
	}

	/**
	 * @return the allowLogin
	 */
	public byte getAllowLogin() {
		return allowLogin;
	}

	/**
	 * @param allowLogin the allowLogin to set
	 */
	public void setAllowLogin(byte allowLogin) {
		this.allowLogin = allowLogin;
	}

}
