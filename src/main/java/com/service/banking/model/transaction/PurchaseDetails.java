package com.service.banking.model.transaction;

import java.util.List;

public class PurchaseDetails {

    private Integer supplierId;
    private Integer invoiceNo;
    private String narration;
    private Double tdsAmount;
    private Integer branchId;
    private Integer staffId;
    private Integer transactionTypeId;
    private List<PurchaseItemDetail> items;

    public PurchaseDetails() {

    }

    public PurchaseDetails(Integer supplierId, Integer invoiceNo, String narration, Double tdsAmount, Integer branchId, Integer staffId, Integer transactionTypeId, List<PurchaseItemDetail> items) {
        this.supplierId = supplierId;
        this.invoiceNo = invoiceNo;
        this.narration = narration;
        this.tdsAmount = tdsAmount;
        this.branchId = branchId;
        this.staffId = staffId;
        this.transactionTypeId = transactionTypeId;
        this.items = items;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(Integer invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public Double getTdsAmount() {
        return tdsAmount;
    }

    public void setTdsAmount(Double tdsAmount) {
        this.tdsAmount = tdsAmount;
    }

    public List<PurchaseItemDetail> getItems() {
        return items;
    }

    public void setItems(List<PurchaseItemDetail> items) {
        this.items = items;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Integer transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }
}
