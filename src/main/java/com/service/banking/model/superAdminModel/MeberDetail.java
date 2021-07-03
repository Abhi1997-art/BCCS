package com.service.banking.model.superAdminModel;

public class MeberDetail {
	
    Integer memberId;
	String name;
	Integer memberNo;
	String currentAddress;
	String landmark;
	boolean isDefaulter;
	Integer codeNo;
	
	String collecterName;
	Integer collecterId;
	
	public MeberDetail() {
		super();
	}





	public MeberDetail(Integer id, String name, Integer memberNo, String currentAddress,
			boolean isDefaulter,  String landmark, Integer codeNo) {
		super();
		this.memberId = id;
		this.name = name;
		this.memberNo = memberNo;
		this.currentAddress = currentAddress;
		this.landmark = landmark;
		this.isDefaulter = isDefaulter;
		this.codeNo = codeNo;
	}





	public MeberDetail(Integer id, String name, Integer memberNo, String currentAddress, 
			boolean isDefaulter,String landmark) {
		super();
		this.memberId = id;
		this.name = name;
		this.memberNo = memberNo;
		this.currentAddress = currentAddress;
		this.isDefaulter = isDefaulter;
		this.landmark = landmark;
	}





	public MeberDetail(Integer id, String name, Integer memberNo, String currentAddress, 
			boolean isDefaulter,String landmark, String collecterName, Integer collecterId) {
		super();
		this.memberId = id;
		this.name = name;
		this.memberNo = memberNo;
		this.currentAddress = currentAddress;
		this.landmark = landmark;
		this.isDefaulter = isDefaulter;
		this.collecterName = collecterName;
		this.collecterId = collecterId;
	}





	public Integer getMemberId() {
		return memberId;
	}





	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}





	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}


	public String getCurrentAddress() {
		return currentAddress;
	}


	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}


	public String getLandmark() {
		return landmark;
	}


	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}


	public boolean isDefaulter() {
		return isDefaulter;
	}


	public void setDefaulter(boolean isDefaulter) {
		this.isDefaulter = isDefaulter;
	}

	public Integer getCodeNo() {
		return codeNo;
	}

	public void setCodeNo(Integer codeNo) {
		this.codeNo = codeNo;
	}





	public String getCollecterName() {
		return collecterName;
	}





	public void setCollecterName(String collecterName) {
		this.collecterName = collecterName;
	}





	public Integer getCollecterId() {
		return collecterId;
	}





	public void setCollecterId(Integer collecterId) {
		this.collecterId = collecterId;
	}
	
	
	
	
}
