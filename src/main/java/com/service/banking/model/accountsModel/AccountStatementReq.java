package com.service.banking.model.accountsModel;

public class AccountStatementReq {

    Integer id;            // memeberId for member request
    String toDate;
    String fromDate;


    public AccountStatementReq() {
        super();
    }


    public AccountStatementReq(Integer id, String toDate, String fromDate) {
        super();
        this.id = id;
        this.toDate = toDate;
        this.fromDate = fromDate;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getToDate() {
        return toDate;
    }


    public void setToDate(String toDate) {
        this.toDate = toDate;
    }


    public String getFromDate() {
        return fromDate;
    }


    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }


}