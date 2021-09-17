package com.service.banking.model.accountsModel;

import java.util.Date;

public class ReturnNocDetails {

	Integer id;
	String accountNumber;
	String name;
	Date nocLetterReceivedOn;
	Date sendAt;
	String createdName; // staff name
	String branchName; // branch name
	String sendNarration;
	Date receivedAt;
	String recieveName; // staff name
	String rcvbranchName; // branch name
	String rcvsendNarration;
	Integer isReturn;
	Date returnAt;
	String returnName; // name
	String returnNarration;
	String rtrn_rcvName; // name
	String returnReceivedNarration;
	String nocNotMadeDueTo;
	String nocHoldDueTo;
	Integer isDispatchToCustomer;
	String dispatchNarration;
	Date dispatchAt;
	Integer dispatchById;
	String dispatchName;
	Integer returnReceivedId;
	Integer returnReceivedIdName;

	public ReturnNocDetails() {
		super();
	}

	public ReturnNocDetails(Integer id, String accountNumber, String name, Date nocLetterReceivedOn, Date sendAt,
							String createdName, String branchName, String sendNarration, Date receivedAt, String recieveName,
							String rcvbranchName, String rcvsendNarration, Integer isReturn, Date returnAt, String returnName,
							String returnNarration, String rtrn_rcvName, String returnReceivedNarration) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.name = name;
		this.nocLetterReceivedOn = nocLetterReceivedOn;
		this.sendAt = sendAt;
		this.createdName = createdName;
		this.branchName = branchName;
		this.sendNarration = sendNarration;
		this.receivedAt = receivedAt;
		this.recieveName = recieveName;
		this.rcvbranchName = rcvbranchName;
		this.rcvsendNarration = rcvsendNarration;
		this.isReturn = isReturn;
		this.returnAt = returnAt;
		this.returnName = returnName;
		this.returnNarration = returnNarration;
		this.rtrn_rcvName = rtrn_rcvName;
		this.returnReceivedNarration = returnReceivedNarration;
		this.nocNotMadeDueTo = nocNotMadeDueTo;
		this.nocHoldDueTo = nocHoldDueTo;
		this.isDispatchToCustomer = isDispatchToCustomer;
		this.dispatchNarration = dispatchNarration;
		this.dispatchAt = dispatchAt;
		this.dispatchById = dispatchById;
		this.dispatchName = dispatchName;
		this.returnReceivedId=returnReceivedId;
		this.returnReceivedIdName=returnReceivedIdName;
	}


	public ReturnNocDetails(Integer id, String accountNumber, String name, Date nocLetterReceivedOn, Date sendAt,
			String createdName, String branchName, String sendNarration, Date receivedAt, String recieveName,
			String rcvbranchName, String rcvsendNarration, Integer isReturn, Date returnAt, String returnName,
			String returnNarration, String rtrn_rcvName, String returnReceivedNarration, Integer returnReceivedId, Integer returnReceivedIdName) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.name = name;
		this.nocLetterReceivedOn = nocLetterReceivedOn;
		this.sendAt = sendAt;
		this.createdName = createdName;
		this.branchName = branchName;
		this.sendNarration = sendNarration;
		this.receivedAt = receivedAt;
		this.recieveName = recieveName;
		this.rcvbranchName = rcvbranchName;
		this.rcvsendNarration = rcvsendNarration;
		this.isReturn = isReturn;
		this.returnAt = returnAt;
		this.returnName = returnName;
		this.returnNarration = returnNarration;
		this.rtrn_rcvName = rtrn_rcvName;
		this.returnReceivedNarration = returnReceivedNarration;
		this.nocNotMadeDueTo = nocNotMadeDueTo;
		this.nocHoldDueTo = nocHoldDueTo;
		this.isDispatchToCustomer = isDispatchToCustomer;
		this.dispatchNarration = dispatchNarration;
		this.dispatchAt = dispatchAt;
		this.dispatchById = dispatchById;
		this.dispatchName = dispatchName;
		this.returnReceivedId=returnReceivedId;
		this.returnReceivedIdName=returnReceivedIdName;
	}

	/*
	 * public ReturnNocDetails(Integer id, String accountNumber, String name, Date
	 * nocLetterReceivedOn, Date sendAt, String createdName, String branchName,
	 * String sendNarration, Date receivedAt, String recieveName, String
	 * rcvbranchName, String rcvsendNarration, Integer isReturn, Date returnAt,
	 * String returnName, String returnNarration, String rtrn_rcvName, String
	 * returnReceivedNarration) { super(); this.id = id; this.accountNumber =
	 * accountNumber; this.name = name; this.nocLetterReceivedOn =
	 * nocLetterReceivedOn; this.sendAt = sendAt; this.createdName = createdName;
	 * this.branchName = branchName; this.sendNarration = sendNarration;
	 * this.receivedAt = receivedAt; this.recieveName = recieveName;
	 * this.rcvbranchName = rcvbranchName; this.rcvsendNarration = rcvsendNarration;
	 * this.isReturn = isReturn; this.returnAt = returnAt; this.returnName =
	 * returnName; this.returnNarration = returnNarration; this.rtrn_rcvName =
	 * rtrn_rcvName; this.returnReceivedNarration = returnReceivedNarration; }
	 */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getNocLetterReceivedOn() {
		return nocLetterReceivedOn;
	}

	public void setNocLetterReceivedOn(Date nocLetterReceivedOn) {
		this.nocLetterReceivedOn = nocLetterReceivedOn;
	}

	public Date getSendAt() {
		return sendAt;
	}

	public void setSendAt(Date sendAt) {
		this.sendAt = sendAt;
	}

	public String getCreatedName() {
		return createdName;
	}

	public void setCreatedName(String createdName) {
		this.createdName = createdName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getSendNarration() {
		return sendNarration;
	}

	public void setSendNarration(String sendNarration) {
		this.sendNarration = sendNarration;
	}

	public Date getReceivedAt() {
		return receivedAt;
	}

	public void setReceivedAt(Date receivedAt) {
		this.receivedAt = receivedAt;
	}

	public String getRecieveName() {
		return recieveName;
	}

	public void setRecieveName(String recieveName) {
		this.recieveName = recieveName;
	}

	public String getRcvbranchName() {
		return rcvbranchName;
	}

	public void setRcvbranchName(String rcvbranchName) {
		this.rcvbranchName = rcvbranchName;
	}

	public String getRcvsendNarration() {
		return rcvsendNarration;
	}

	public void setRcvsendNarration(String rcvsendNarration) {
		this.rcvsendNarration = rcvsendNarration;
	}

	public Integer getIsReturn() {
		return isReturn;
	}

	public void setIsReturn(Integer isReturn) {
		this.isReturn = isReturn;
	}

	public Date getReturnAt() {
		return returnAt;
	}

	public void setReturnAt(Date returnAt) {
		this.returnAt = returnAt;
	}

	public String getReturnName() {
		return returnName;
	}

	public void setReturnName(String returnName) {
		this.returnName = returnName;
	}

	public String getReturnNarration() {
		return returnNarration;
	}

	public void setReturnNarration(String returnNarration) {
		this.returnNarration = returnNarration;
	}

	public String getRtrn_rcvName() {
		return rtrn_rcvName;
	}

	public void setRtrn_rcvName(String rtrn_rcvName) {
		this.rtrn_rcvName = rtrn_rcvName;
	}

	public String getReturnReceivedNarration() {
		return returnReceivedNarration;
	}

	public void setReturnReceivedNarration(String returnReceivedNarration) {
		this.returnReceivedNarration = returnReceivedNarration;
	}

	public String getNocNotMadeDueTo() {
		return nocNotMadeDueTo;
	}

	public void setNocNotMadeDueTo(String nocNotMadeDueTo) {
		this.nocNotMadeDueTo = nocNotMadeDueTo;
	}

	public String getNocHoldDueTo() {
		return nocHoldDueTo;
	}

	public void setNocHoldDueTo(String nocHoldDueTo) {
		this.nocHoldDueTo = nocHoldDueTo;
	}

	public Integer getIsDispatchToCustomer() {
		return isDispatchToCustomer;
	}

	public void setIsDispatchToCustomer(Integer isDispatchToCustomer) {
		this.isDispatchToCustomer = isDispatchToCustomer;
	}

	public String getDispatchNarration() {
		return dispatchNarration;
	}

	public void setDispatchNarration(String dispatchNarration) {
		this.dispatchNarration = dispatchNarration;
	}

	public Date getDispatchAt() {
		return dispatchAt;
	}

	public void setDispatchAt(Date dispatchAt) {
		this.dispatchAt = dispatchAt;
	}

	public Integer getDispatchById() {
		return dispatchById;
	}

	public void setDispatchById(Integer dispatchById) {
		this.dispatchById = dispatchById;
	}

	public String getDispatchName() {
		return dispatchName;
	}

	public void setDispatchName(String dispatchName) {
		this.dispatchName = dispatchName;
	}

	public Integer getReturnReceivedId() {
		return returnReceivedId;
	}

	public void setReturnReceivedId(Integer returnReceivedId) {
		this.returnReceivedId = returnReceivedId;
	}

	public Integer getReturnReceivedIdName() {
		return returnReceivedIdName;
	}

	public void setReturnReceivedIdName(Integer returnReceivedIdName) {
		this.returnReceivedIdName = returnReceivedIdName;
	}
}
