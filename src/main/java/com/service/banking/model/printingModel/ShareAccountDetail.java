package com.service.banking.model.printingModel;

import java.util.Date;

public class ShareAccountDetail {

    Integer id;
    String name;
    String accountNumber;
    Long shares;
    Date createdAt;
    Integer certificateNo;

    public ShareAccountDetail() {
    }

    public ShareAccountDetail(Integer id, String name, String accountNumber, Long shares, Date createdAt) {
        this.id = id;
        this.name = name;
        this.accountNumber = accountNumber;
        this.shares = shares;
        this.createdAt = createdAt;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setShares(Long shares) {
        this.shares = shares;
    }

    public Integer getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(Integer certificateNo) {
        this.certificateNo = certificateNo;
    }

    public Long getShares() {
        return shares;
    }


}
