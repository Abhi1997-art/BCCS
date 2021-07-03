package com.service.banking.model.accountsModel;

import java.util.Date;

public class PendingLoanDetails {

	private Integer id;
	private int accountsId;
	private int createdById;
	private int fromBranchId;
	private Integer toBranchId;
	private Integer receivedById;
	private int returnReceivedById;
	private Date nocLetterReceivedOn;
	private Date sendAt;
	private String sendNarration;
	private Date receivedAt;
	private String receivedNarration;
	private int isDispatchToCustomer;
	private String dispatchNarration;
	private Date dispatchAt;
	private int isReturn;
	private Date returnAt;
	private String returnReceivedNarration;
	private int dispatchById;
	private String returnNarration;
	private int returnById;
	private byte isNocNotMade;
	private String nocNotMadeDueTo;
	private byte isNocHold;
	private String nocHoldDueTo;
	
	
	
	public PendingLoanDetails() {
		super();
	}
	public PendingLoanDetails(Integer id, int accountsId, int createdById, int fromBranchId, Integer toBranchId,
			Integer receivedById, int returnReceivedById, Date nocLetterReceivedOn, Date sendAt, String sendNarration,
			Date receivedAt, String receivedNarration, int isDispatchToCustomer, String dispatchNarration,
			Date dispatchAt, int isReturn, Date returnAt, String returnReceivedNarration, int dispatchById,
			String returnNarration, int returnById, byte isNocNotMade, String nocNotMadeDueTo, byte isNocHold,
			String nocHoldDueTo) {
		super();
		this.id = id;
		this.accountsId = accountsId;
		this.createdById = createdById;
		this.fromBranchId = fromBranchId;
		this.toBranchId = toBranchId;
		this.receivedById = receivedById;
		this.returnReceivedById = returnReceivedById;
		this.nocLetterReceivedOn = nocLetterReceivedOn;
		this.sendAt = sendAt;
		this.sendNarration = sendNarration;
		this.receivedAt = receivedAt;
		this.receivedNarration = receivedNarration;
		this.isDispatchToCustomer = isDispatchToCustomer;
		this.dispatchNarration = dispatchNarration;
		this.dispatchAt = dispatchAt;
		this.isReturn = isReturn;
		this.returnAt = returnAt;
		this.returnReceivedNarration = returnReceivedNarration;
		this.dispatchById = dispatchById;
		this.returnNarration = returnNarration;
		this.returnById = returnById;
		this.isNocNotMade = isNocNotMade;
		this.nocNotMadeDueTo = nocNotMadeDueTo;
		this.isNocHold = isNocHold;
		this.nocHoldDueTo = nocHoldDueTo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getAccountsId() {
		return accountsId;
	}
	public void setAccountsId(int accountsId) {
		this.accountsId = accountsId;
	}
	public int getCreatedById() {
		return createdById;
	}
	public void setCreatedById(int createdById) {
		this.createdById = createdById;
	}
	public int getFromBranchId() {
		return fromBranchId;
	}
	public void setFromBranchId(int fromBranchId) {
		this.fromBranchId = fromBranchId;
	}
	public Integer getToBranchId() {
		return toBranchId;
	}
	public void setToBranchId(Integer toBranchId) {
		this.toBranchId = toBranchId;
	}
	public Integer getReceivedById() {
		return receivedById;
	}
	public void setReceivedById(Integer receivedById) {
		this.receivedById = receivedById;
	}
	public int getReturnReceivedById() {
		return returnReceivedById;
	}
	public void setReturnReceivedById(int returnReceivedById) {
		this.returnReceivedById = returnReceivedById;
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
	public String getReceivedNarration() {
		return receivedNarration;
	}
	public void setReceivedNarration(String receivedNarration) {
		this.receivedNarration = receivedNarration;
	}
	public int getIsDispatchToCustomer() {
		return isDispatchToCustomer;
	}
	public void setIsDispatchToCustomer(int isDispatchToCustomer) {
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
	public int getIsReturn() {
		return isReturn;
	}
	public void setIsReturn(int isReturn) {
		this.isReturn = isReturn;
	}
	public Date getReturnAt() {
		return returnAt;
	}
	public void setReturnAt(Date returnAt) {
		this.returnAt = returnAt;
	}
	public String getReturnReceivedNarration() {
		return returnReceivedNarration;
	}
	public void setReturnReceivedNarration(String returnReceivedNarration) {
		this.returnReceivedNarration = returnReceivedNarration;
	}
	public int getDispatchById() {
		return dispatchById;
	}
	public void setDispatchById(int dispatchById) {
		this.dispatchById = dispatchById;
	}
	public String getReturnNarration() {
		return returnNarration;
	}
	public void setReturnNarration(String returnNarration) {
		this.returnNarration = returnNarration;
	}
	public int getReturnById() {
		return returnById;
	}
	public void setReturnById(int returnById) {
		this.returnById = returnById;
	}
	public byte getIsNocNotMade() {
		return isNocNotMade;
	}
	public void setIsNocNotMade(byte isNocNotMade) {
		this.isNocNotMade = isNocNotMade;
	}
	public String getNocNotMadeDueTo() {
		return nocNotMadeDueTo;
	}
	public void setNocNotMadeDueTo(String nocNotMadeDueTo) {
		this.nocNotMadeDueTo = nocNotMadeDueTo;
	}
	public byte getIsNocHold() {
		return isNocHold;
	}
	public void setIsNocHold(byte isNocHold) {
		this.isNocHold = isNocHold;
	}
	public String getNocHoldDueTo() {
		return nocHoldDueTo;
	}
	public void setNocHoldDueTo(String nocHoldDueTo) {
		this.nocHoldDueTo = nocHoldDueTo;
	}

	
}
