package com.service.banking.model.hodAuthorityModel;

public class MoRoDetails {

	private Integer id; // mos id
	private String moName; // mos name
	private Byte isActive;
	private Integer branchId;
	private String branchName; // branch name.............

	public MoRoDetails() {
		super();
	}

	
	
	public MoRoDetails(Integer id, String moName) {
		super();
		this.id = id;
		this.moName = moName;
	}

	public MoRoDetails(Integer id, String moName, Byte isActive, Integer branchId, String branchName) {
		super();
		this.id = id;
		this.moName = moName;
		this.isActive = isActive;
		this.branchId = branchId;
		this.branchName = branchName;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the moName
	 */
	public String getMoName() {
		return moName;
	}

	/**
	 * @param moName the moName to set
	 */
	public void setMoName(String moName) {
		this.moName = moName;
	}

	/**
	 * @return the isActive
	 */
	public Byte getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the branchId
	 */
	public Integer getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

}
