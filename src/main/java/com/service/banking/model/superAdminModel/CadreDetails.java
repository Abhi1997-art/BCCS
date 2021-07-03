package com.service.banking.model.superAdminModel;

public class CadreDetails {
	
	
	//cd.id,cd.name ,cd.percentageShare ,cd.reqUnder ,cd.totalCrpb ,c.name
	
	public Integer id;
	public String name;
	public Integer percentageShare;
	public String reqUnder;
	public String totalCrpb;
	public String  nextcadreName;
    public  Integer nextcadreId;
	
	public CadreDetails() {
		super();
	}

	public CadreDetails(Integer id, String name, Integer percentageShare, String reqUnder, String totalCrpb,
			String nextcadreName,Integer nextcadreId) {
		super();
		this.id = id;
		this.name = name;
		this.percentageShare = percentageShare;
		this.reqUnder = reqUnder;
		this.totalCrpb = totalCrpb;
		this.nextcadreName = nextcadreName;
		this.nextcadreId = nextcadreId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	 
	public Integer getNextcadreId() {
		return nextcadreId;
	}

	public void setNextcadreId(Integer nextcadreId) {
		this.nextcadreId = nextcadreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPercentageShare() {
		return percentageShare;
	}

	public void setPercentageShare(Integer percentageShare) {
		this.percentageShare = percentageShare;
	}

	public String getReqUnder() {
		return reqUnder;
	}

	public void setReqUnder(String reqUnder) {
		this.reqUnder = reqUnder;
	}

	public String getTotalCrpb() {
		return totalCrpb;
	}

	public void setTotalCrpb(String totalCrpb) {
		this.totalCrpb = totalCrpb;
	}

	public String getNextcadreName() {
		return nextcadreName;
	}

	public void setNextcadreName(String nextcadreName) {
		this.nextcadreName = nextcadreName;
	}
	
	
	

}
