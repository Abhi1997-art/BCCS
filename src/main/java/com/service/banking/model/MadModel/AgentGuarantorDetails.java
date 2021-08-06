package com.service.banking.model.MadModel;


public class AgentGuarantorDetails {

	Integer id;
	Integer memberId;
	Integer memberNo;
	String name;
	String currentAddress;
	String andmark;
	Boolean isDefaulter;
	Integer codeNo;
	Integer agentId;
	String agentName;
	String agentCurrentAddress;
	String agentLandmark;
	Boolean agentIsDefaulter;

	public AgentGuarantorDetails() {
		super();
	}

	public AgentGuarantorDetails(Integer id, Integer memberId, Integer memberNo, String name, String currentAddress,
			String andmark, Boolean isDefaulter, Integer codeNo, Integer agentId, String agentName,
			String agentCurrentAddress, String agentLandmark, Boolean agentIsDefaulter) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.memberNo = memberNo;
		this.name = name;
		this.currentAddress = currentAddress;
		this.andmark = andmark;
		this.isDefaulter = isDefaulter;
		this.codeNo = codeNo;
		this.agentId = agentId;
		this.agentName = agentName;
		this.agentCurrentAddress = agentCurrentAddress;
		this.agentLandmark = agentLandmark;
		this.agentIsDefaulter = agentIsDefaulter;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getAndmark() {
		return andmark;
	}

	public void setAndmark(String andmark) {
		this.andmark = andmark;
	}

	public Boolean getIsDefaulter() {
		return isDefaulter;
	}

	public void setIsDefaulter(Boolean isDefaulter) {
		this.isDefaulter = isDefaulter;
	}

	public Integer getCodeNo() {
		return codeNo;
	}

	public void setCodeNo(Integer codeNo) {
		this.codeNo = codeNo;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentCurrentAddress() {
		return agentCurrentAddress;
	}

	public void setAgentCurrentAddress(String agentCurrentAddress) {
		this.agentCurrentAddress = agentCurrentAddress;
	}

	public String getAgentLandmark() {
		return agentLandmark;
	}

	public void setAgentLandmark(String agentLandmark) {
		this.agentLandmark = agentLandmark;
	}

	public Boolean getAgentIsDefaulter() {
		return agentIsDefaulter;
	}

	public void setAgentIsDefaulter(Boolean agentIsDefaulter) {
		this.agentIsDefaulter = agentIsDefaulter;
	}

}