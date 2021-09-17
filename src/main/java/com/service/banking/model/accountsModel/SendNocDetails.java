package com.service.banking.model.accountsModel;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.service.banking.utils.DateFormater;

public class SendNocDetails {


    Integer id;
    String accountNumber;
    String name;
    String fatherName;
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    Date nocLetterReceivedOn;
    String toBranch;
    Date sendAt;
    String sendNarration;
    Integer isDispatchToCustomer;
    Integer isReturn;
    private Byte isNocNotMade;
    private String nocNotMadeDueTo;
    private Byte isNocHold;
    private String nocHoldDueTo;
    private String dispatchNarration;
    private Integer toBranchId;
    private Integer accountsId;
    private Integer fromBranchId;
    private Integer loginId;
    private String createdBy;
    private Integer accountId;

    DateFormater dateFormater = new DateFormater();

    public SendNocDetails() {
        super();
    }

    public SendNocDetails(Integer id, String accountNumber, String name, String fatherNamme, Date nocLetterReceivedOn,
                          String toBranch, Date sendAt, String sendNarration, Integer isDispatchToCustomer, Integer isReturn,
                          String createdBy, Integer accountId, Integer toBranchId) {
        super();
        this.id = id;
        this.accountNumber = accountNumber;
        this.name = name;
        this.fatherName = fatherNamme;
        this.nocLetterReceivedOn = nocLetterReceivedOn;
        this.toBranch = toBranch;
        this.sendAt = sendAt;
        this.sendNarration = sendNarration;
        this.isDispatchToCustomer = isDispatchToCustomer;
        this.isReturn = isReturn;
        this.createdBy=createdBy;
        this.accountId=accountId;
        this.toBranchId=toBranchId;
    }


    public SendNocDetails(Integer id, String accountNumber, String name, String fatherNamme, Date nocLetterReceivedOn,
                          String toBranch, Date sendAt, String sendNarration, Integer isDispatchToCustomer, Integer isReturn,
                          Byte isNocNotMade, String nocNotMadeDueTo, Byte isNocHold, String nocHoldDueTo, String dispatchNarration,
                          Integer toBranchId, Integer accountsId) {
        super();
        this.id = id;
        this.accountNumber = accountNumber;
        this.name = name;
        this.fatherName = fatherNamme;
        this.nocLetterReceivedOn = nocLetterReceivedOn;
        this.toBranch = toBranch;
        this.sendAt = sendAt;
        this.sendNarration = sendNarration;
        this.isDispatchToCustomer = isDispatchToCustomer;
        this.isReturn = isReturn;
        this.isNocNotMade = isNocNotMade;
        this.nocNotMadeDueTo = nocNotMadeDueTo;
        this.isNocHold = isNocHold;
        this.nocHoldDueTo = nocHoldDueTo;
        this.dispatchNarration = dispatchNarration;
        this.toBranchId = toBranchId;
        this.accountsId = accountsId;
    }

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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Date getNocLetterReceivedOn() {
        return nocLetterReceivedOn;
    }

    public void setNocLetterReceivedOn(Date nocLetterReceivedOn) {
        this.nocLetterReceivedOn = nocLetterReceivedOn;
    }

    public String getToBranch() {
        return toBranch;
    }

    public void setToBranch(String toBranch) {
        this.toBranch = toBranch;
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

    public int getIsDispatchToCustomer() {
        return isDispatchToCustomer;
    }

    public void setIsDispatchToCustomer(int isDispatchToCustomer) {
        this.isDispatchToCustomer = isDispatchToCustomer;
    }

    public int getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(int isReturn) {
        this.isReturn = isReturn;
    }

    public Byte getIsNocNotMade() {
        return isNocNotMade;
    }

    public void setIsNocNotMade(Byte isNocNotMade) {
        this.isNocNotMade = isNocNotMade;
    }

    public String getNocNotMadeDueTo() {
        return nocNotMadeDueTo;
    }

    public void setNocNotMadeDueTo(String nocNotMadeDueTo) {
        this.nocNotMadeDueTo = nocNotMadeDueTo;
    }

    public Byte getIsNocHold() {
        return isNocHold;
    }

    public void setIsNocHold(Byte isNocHold) {
        this.isNocHold = isNocHold;
    }

    public String getNocHoldDueTo() {
        return nocHoldDueTo;
    }

    public void setNocHoldDueTo(String nocHoldDueTo) {
        this.nocHoldDueTo = nocHoldDueTo;
    }

    public String getDispatchNarration() {
        return dispatchNarration;
    }

    public void setDispatchNarration(String dispatchNarration) {
        this.dispatchNarration = dispatchNarration;
    }

    public Integer getToBranchId() {
        return toBranchId;
    }

    public void setToBranchId(Integer toBranchId) {
        this.toBranchId = toBranchId;
    }

    public Integer getAccountsId() {
        return accountsId;
    }

    public void setAccountsId(Integer accountsId) {
        this.accountsId = accountsId;
    }

    public DateFormater getDateFormater() {
        return dateFormater;
    }

    public void setDateFormater(DateFormater dateFormater) {
        this.dateFormater = dateFormater;
    }

    public void setIsDispatchToCustomer(Integer isDispatchToCustomer) {
        this.isDispatchToCustomer = isDispatchToCustomer;
    }

    public void setIsReturn(Integer isReturn) {
        this.isReturn = isReturn;
    }

	public Integer getFromBranchId() {
		return fromBranchId;
	}

	public void setFromBranchId(Integer fromBranchId) {
		this.fromBranchId = fromBranchId;
	}

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
