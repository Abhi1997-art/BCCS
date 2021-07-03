package com.service.banking.model.transaction;

public class JournalDetails {

	private Integer acFrom1;
	private Integer acFrom2;
	private Integer acFrom3;
	private Integer acFrom4;
	private Integer acFrom5;
	private Integer acTo1;
	private Integer acTo2;
	private Integer acTo3;
	private Integer acTo4;
	private Integer acTo5;
	private String narration;
	private Integer jvtypeid;
	private Double amtFrom1;
	private Double amtFrom2;
	private Double amtFrom3;
	private Double amtFrom4;
	private Double amtFrom5;
	private Double amtTo1;
	private Double amtTo2;
	private Double amtTo3;
	private Double amtTo4;
	private Double amtTo5;
	
	private Integer staffId;
	private Integer branchId;
	private Integer loginBranch;

	public JournalDetails() {
		super();
	}

	public JournalDetails(Integer acFrom1, Integer acFrom2, Integer acFrom3, Integer acFrom4, Integer acFrom5,
			Integer acTo1, Integer acTo2, Integer acTo3, Integer acTo4, Integer acTo5, String narration,
			Integer jvtypeid, Double amtFrom1, Double amtFrom2, Double amtFrom3, Double amtFrom4, Double amtFrom5,
			Double amtTo1, Double amtTo2, Double amtTo3, Double amtTo4, Double amtTo5) {
		super();
		this.acFrom1 = acFrom1;
		this.acFrom2 = acFrom2;
		this.acFrom3 = acFrom3;
		this.acFrom4 = acFrom4;
		this.acFrom5 = acFrom5;
		this.acTo1 = acTo1;
		this.acTo2 = acTo2;
		this.acTo3 = acTo3;
		this.acTo4 = acTo4;
		this.acTo5 = acTo5;
		this.narration = narration;
		this.jvtypeid = jvtypeid;
		this.amtFrom1 = amtFrom1;
		this.amtFrom2 = amtFrom2;
		this.amtFrom3 = amtFrom3;
		this.amtFrom4 = amtFrom4;
		this.amtFrom5 = amtFrom5;
		this.amtTo1 = amtTo1;
		this.amtTo2 = amtTo2;
		this.amtTo3 = amtTo3;
		this.amtTo4 = amtTo4;
		this.amtTo5 = amtTo5;
	}
	
	
	
	

	public JournalDetails(Integer acFrom1, Integer acFrom2, Integer acFrom3, Integer acFrom4, Integer acFrom5,
			Integer acTo1, Integer acTo2, Integer acTo3, Integer acTo4, Integer acTo5, String narration,
			Integer jvtypeid, Double amtFrom1, Double amtFrom2, Double amtFrom3, Double amtFrom4, Double amtFrom5,
			Double amtTo1, Double amtTo2, Double amtTo3, Double amtTo4, Double amtTo5, Integer staffId,
			Integer branchId, Integer loginBranch) {
		super();
		this.acFrom1 = acFrom1;
		this.acFrom2 = acFrom2;
		this.acFrom3 = acFrom3;
		this.acFrom4 = acFrom4;
		this.acFrom5 = acFrom5;
		this.acTo1 = acTo1;
		this.acTo2 = acTo2;
		this.acTo3 = acTo3;
		this.acTo4 = acTo4;
		this.acTo5 = acTo5;
		this.narration = narration;
		this.jvtypeid = jvtypeid;
		this.amtFrom1 = amtFrom1;
		this.amtFrom2 = amtFrom2;
		this.amtFrom3 = amtFrom3;
		this.amtFrom4 = amtFrom4;
		this.amtFrom5 = amtFrom5;
		this.amtTo1 = amtTo1;
		this.amtTo2 = amtTo2;
		this.amtTo3 = amtTo3;
		this.amtTo4 = amtTo4;
		this.amtTo5 = amtTo5;
		this.staffId = staffId;
		this.branchId = branchId;
		this.loginBranch = loginBranch;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Integer getLoginBranch() {
		return loginBranch;
	}

	public void setLoginBranch(Integer loginBranch) {
		this.loginBranch = loginBranch;
	}

	public Integer getAcFrom1() {
		return acFrom1;
	}

	public void setAcFrom1(Integer acFrom1) {
		this.acFrom1 = acFrom1;
	}

	public Integer getAcFrom2() {
		return acFrom2;
	}

	public void setAcFrom2(Integer acFrom2) {
		this.acFrom2 = acFrom2;
	}

	public Integer getAcFrom3() {
		return acFrom3;
	}

	public void setAcFrom3(Integer acFrom3) {
		this.acFrom3 = acFrom3;
	}

	public Integer getAcFrom4() {
		return acFrom4;
	}

	public void setAcFrom4(Integer acFrom4) {
		this.acFrom4 = acFrom4;
	}

	public Integer getAcFrom5() {
		return acFrom5;
	}

	public void setAcFrom5(Integer acFrom5) {
		this.acFrom5 = acFrom5;
	}

	public Integer getAcTo1() {
		return acTo1;
	}

	public void setAcTo1(Integer acTo1) {
		this.acTo1 = acTo1;
	}

	public Integer getAcTo2() {
		return acTo2;
	}

	public void setAcTo2(Integer acTo2) {
		this.acTo2 = acTo2;
	}

	public Integer getAcTo3() {
		return acTo3;
	}

	public void setAcTo3(Integer acTo3) {
		this.acTo3 = acTo3;
	}

	public Integer getAcTo4() {
		return acTo4;
	}

	public void setAcTo4(Integer acTo4) {
		this.acTo4 = acTo4;
	}

	public Integer getAcTo5() {
		return acTo5;
	}

	public void setAcTo5(Integer acTo5) {
		this.acTo5 = acTo5;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public Integer getJvtypeid() {
		return jvtypeid;
	}

	public void setJvtypeid(Integer jvtypeid) {
		this.jvtypeid = jvtypeid;
	}

	public Double getAmtFrom1() {
		return amtFrom1;
	}

	public void setAmtFrom1(Double amtFrom1) {
		this.amtFrom1 = amtFrom1;
	}

	public Double getAmtFrom2() {
		return amtFrom2;
	}

	public void setAmtFrom2(Double amtFrom2) {
		this.amtFrom2 = amtFrom2;
	}

	public Double getAmtFrom3() {
		return amtFrom3;
	}

	public void setAmtFrom3(Double amtFrom3) {
		this.amtFrom3 = amtFrom3;
	}

	public Double getAmtFrom4() {
		return amtFrom4;
	}

	public void setAmtFrom4(Double amtFrom4) {
		this.amtFrom4 = amtFrom4;
	}

	public Double getAmtFrom5() {
		return amtFrom5;
	}

	public void setAmtFrom5(Double amtFrom5) {
		this.amtFrom5 = amtFrom5;
	}

	public Double getAmtTo1() {
		return amtTo1;
	}

	public void setAmtTo1(Double amtTo1) {
		this.amtTo1 = amtTo1;
	}

	public Double getAmtTo2() {
		return amtTo2;
	}

	public void setAmtTo2(Double amtTo2) {
		this.amtTo2 = amtTo2;
	}

	public Double getAmtTo3() {
		return amtTo3;
	}

	public void setAmtTo3(Double amtTo3) {
		this.amtTo3 = amtTo3;
	}

	public Double getAmtTo4() {
		return amtTo4;
	}

	public void setAmtTo4(Double amtTo4) {
		this.amtTo4 = amtTo4;
	}

	public Double getAmtTo5() {
		return amtTo5;
	}

	public void setAmtTo5(Double amtTo5) {
		this.amtTo5 = amtTo5;
	}
	
	

}
