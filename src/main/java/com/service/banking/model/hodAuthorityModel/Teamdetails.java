package com.service.banking.model.hodAuthorityModel;

public class Teamdetails {
	
	private Integer teamId;
	private String teamName;
	private Byte isActive;
	
	
	
	
	public Teamdetails() {
		super();
	}




	public Teamdetails(Integer teamId, String teamName) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
	}








	public Integer getTeamId() {
		return teamId;
	}




	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}




	public String getTeamName() {
		return teamName;
	}




	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}








	public Byte getIsActive() {
		return isActive;
	}




	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}
	
	
	

}
