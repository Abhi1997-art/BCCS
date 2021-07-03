package com.service.banking.model.hodAuthorityModel;

import java.util.Date;

public class LogCheckDetails {
	// x.id,x.name,s.name,x.modelClass ,x.pkId ,x.createdAt ,
	// ,x.type,a.accountNumber ,m.name as memberName,m.fatherName
	int id;
	String staffName;
	String modelClass;
	int pkId;
	Date createdAt;
	String name;
	String type;
	String accountNumber;
	String memberName;
	String fatherName;

	public LogCheckDetails() {
		super();
	}

	public LogCheckDetails(int id, String staffName, String modelClass, int pkId, Date createdAt, String name,
			String type, String accountNumber, String memberName, String fatherName) {
		super();
		this.id = id;
		this.staffName = staffName;
		this.modelClass = modelClass;
		this.pkId = pkId;
		this.createdAt = createdAt;
		this.name = name;
		this.type = type;
		this.accountNumber = accountNumber;
		this.memberName = memberName;
		this.fatherName = fatherName;
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
	 * @return the staffName
	 */
	public String getStaffName() {
		return staffName;
	}

	/**
	 * @param staffName the staffName to set
	 */
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	/**
	 * @return the modelClass
	 */
	public String getModelClass() {
		return modelClass;
	}

	/**
	 * @param modelClass the modelClass to set
	 */
	public void setModelClass(String modelClass) {
		this.modelClass = modelClass;
	}

	/**
	 * @return the pkId
	 */
	public int getPkId() {
		return pkId;
	}

	/**
	 * @param pkId the pkId to set
	 */
	public void setPkId(int pkId) {
		this.pkId = pkId;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

}
