package com.service.banking.model.hodAuthorityModel;

public class FilterMoAgentUpdateDetails {

	private Integer codeNo;
	private String memberName;
	private Integer memberId;
	private String permanentAddress;
	private String landmark;
	private Boolean isDefaulter;
	private String mosName;
	private Integer agentId;

	public FilterMoAgentUpdateDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FilterMoAgentUpdateDetails(Integer codeNo, String memberName, Integer memberId, String permanentAddress,
			String landmark, Boolean isDefaulter, String mosName) {
		super();
		this.codeNo = codeNo;
		this.memberName = memberName;
		this.memberId = memberId;
		this.permanentAddress = permanentAddress;
		this.landmark = landmark;
		this.isDefaulter = isDefaulter;
		this.mosName = mosName;
	}
	
	

	public FilterMoAgentUpdateDetails(Integer codeNo, String memberName, Integer memberId, String permanentAddress,
			String landmark, Boolean isDefaulter, String mosName, Integer agentId) {
		super();
		this.codeNo = codeNo;
		this.memberName = memberName;
		this.memberId = memberId;
		this.permanentAddress = permanentAddress;
		this.landmark = landmark;
		this.isDefaulter = isDefaulter;
		this.mosName = mosName;
		this.agentId = agentId;
	}

	public Integer getCodeNo() {
		return codeNo;
	}

	public void setCodeNo(Integer codeNo) {
		this.codeNo = codeNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public Boolean getIsDefaulter() {
		return isDefaulter;
	}

	public void setIsDefaulter(Boolean isDefaulter) {
		this.isDefaulter = isDefaulter;
	}

	public String getMosName() {
		return mosName;
	}

	public void setMosName(String mosName) {
		this.mosName = mosName;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
	
	

}