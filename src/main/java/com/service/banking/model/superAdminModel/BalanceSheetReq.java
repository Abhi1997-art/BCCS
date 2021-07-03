package com.service.banking.model.superAdminModel;

public class BalanceSheetReq {

	
	private Integer id;
	private String name;
	private String positiveSide;
	private Boolean isPandl;
	private String showSub;
	private String subtractFrom;
	private int orderOfBalanceSheet;
	
	
	
	public BalanceSheetReq() {
		super();
	}
	public BalanceSheetReq(Integer id, String name, String positiveSide, Boolean isPandl, String showSub,
			String subtractFrom, int orderOfBalanceSheet) {
		super();
		this.id = id;
		this.name = name;
		this.positiveSide = positiveSide;
		this.isPandl = isPandl;
		this.showSub = showSub;
		this.subtractFrom = subtractFrom;
		this.orderOfBalanceSheet = orderOfBalanceSheet;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPositiveSide() {
		return positiveSide;
	}
	public void setPositiveSide(String positiveSide) {
		this.positiveSide = positiveSide;
	}
	public Boolean getIsPandl() {
		return isPandl;
	}
	public void setIsPandl(Boolean isPandl) {
		this.isPandl = isPandl;
	}
	public String getShowSub() {
		return showSub;
	}
	public void setShowSub(String showSub) {
		this.showSub = showSub;
	}
	public String getSubtractFrom() {
		return subtractFrom;
	}
	public void setSubtractFrom(String subtractFrom) {
		this.subtractFrom = subtractFrom;
	}
	public int getOrderOfBalanceSheet() {
		return orderOfBalanceSheet;
	}
	public void setOrderOfBalanceSheet(int orderOfBalanceSheet) {
		this.orderOfBalanceSheet = orderOfBalanceSheet;
	}
	
	
	
	
	
}
