package com.service.banking.model.superAdminModel;

import java.util.Date;

public class ClosingDetails {
	int id;
	String name;
	Date date;
	String performClosing;

	public ClosingDetails(int id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.performClosing = performClosing;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the performClosing
	 */
	public String getPerformClosing() {
		return performClosing;
	}

	/**
	 * @param performClosing the performClosing to set
	 */
	public void setPerformClosing(String performClosing) {
		this.performClosing = performClosing;
	}
}
