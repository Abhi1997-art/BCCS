package com.service.banking.model.MadModel;

public class AgentGuarantorDetails {

	Integer agentId;
	Integer agentGuarantorId;
	String agentGuarantorName;
	String agentGuarantorCurrentAddress;
	String agentGuarantorLandmark;
	Boolean agentGuarantorIsDefaulter;
	Integer agentCodeNo;
	Integer memberId;
	String memberName;
	String memberCurrentAddress;

	String memberLandmark;
	Boolean memberIsDefaulter;

	public AgentGuarantorDetails() {
		super();
	}

	public AgentGuarantorDetails(Integer agentId, Integer agentGuarantorId, String agentGuarantorName,
			String agentGuarantorCurrentAddress, String agentGuarantorLandmark, Boolean agentGuarantorIsDefaulter,
			Integer agentCodeNo, Integer memberId, String memberName, String memberCurrentAddress,
			String memberLandmark, Boolean memberIsDefaulter) {
		super();
		this.agentId = agentId;
		this.agentGuarantorId = agentGuarantorId;
		this.agentGuarantorName = agentGuarantorName;
		this.agentGuarantorCurrentAddress = agentGuarantorCurrentAddress;
		this.agentGuarantorLandmark = agentGuarantorLandmark;
		this.agentGuarantorIsDefaulter = agentGuarantorIsDefaulter;
		this.agentCodeNo = agentCodeNo;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberCurrentAddress = memberCurrentAddress;
		this.memberLandmark = memberLandmark;
		this.memberIsDefaulter = memberIsDefaulter;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public Integer getAgentGuarantorId() {
		return agentGuarantorId;
	}

	public void setAgentGuarantorId(Integer agentGuarantorId) {
		this.agentGuarantorId = agentGuarantorId;
	}

	public String getAgentGuarantorName() {
		return agentGuarantorName;
	}

	public void setAgentGuarantorName(String agentGuarantorName) {
		this.agentGuarantorName = agentGuarantorName;
	}

	public String getAgentGuarantorCurrentAddress() {
		return agentGuarantorCurrentAddress;
	}

	public void setAgentGuarantorCurrentAddress(String agentGuarantorCurrentAddress) {
		this.agentGuarantorCurrentAddress = agentGuarantorCurrentAddress;
	}

	public String getAgentGuarantorLandmark() {
		return agentGuarantorLandmark;
	}

	public void setAgentGuarantorLandmark(String agentGuarantorLandmark) {
		this.agentGuarantorLandmark = agentGuarantorLandmark;
	}

	public Boolean getAgentGuarantorIsDefaulter() {
		return agentGuarantorIsDefaulter;
	}

	public void setAgentGuarantorIsDefaulter(Boolean agentGuarantorIsDefaulter) {
		this.agentGuarantorIsDefaulter = agentGuarantorIsDefaulter;
	}

	public Integer getAgentCodeNo() {
		return agentCodeNo;
	}

	public void setAgentCodeNo(Integer agentCodeNo) {
		this.agentCodeNo = agentCodeNo;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberCurrentAddress() {
		return memberCurrentAddress;
	}

	public void setMemberCurrentAddress(String memberCurrentAddress) {
		this.memberCurrentAddress = memberCurrentAddress;
	}

	public String getMemberLandmark() {
		return memberLandmark;
	}

	public void setMemberLandmark(String memberLandmark) {
		this.memberLandmark = memberLandmark;
	}

	public Boolean getMemberIsDefaulter() {
		return memberIsDefaulter;
	}

	public void setMemberIsDefaulter(Boolean memberIsDefaulter) {
		this.memberIsDefaulter = memberIsDefaulter;
	}

}