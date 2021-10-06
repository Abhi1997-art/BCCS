package com.service.banking.model.transaction;

public class PurchaseItemDetail {

    private Integer purchaseAccountId;
    private Double taxAmount;
    private Double tax;
    private Double taxIncludedAmount;
    private Double taxExcludedAmount;
    private String taxType;

    public PurchaseItemDetail() {
    }

    public PurchaseItemDetail(Integer purchaseAccountId, Double taxAmount, Double tax, Double taxIncludedAmount, Double taxExcludedAmount, String taxType) {
        this.purchaseAccountId = purchaseAccountId;
        this.taxAmount = taxAmount;
        this.tax = tax;
        this.taxIncludedAmount = taxIncludedAmount;
        this.taxExcludedAmount = taxExcludedAmount;
        this.taxType = taxType;
    }

    public Integer getPurchaseAccountId() {
        return purchaseAccountId;
    }

    public void setPurchaseAccountId(Integer purchaseAccountId) {
        this.purchaseAccountId = purchaseAccountId;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getTaxIncludedAmount() {
        return taxIncludedAmount;
    }

    public void setTaxIncludedAmount(Double taxIncludedAmount) {
        this.taxIncludedAmount = taxIncludedAmount;
    }

    public Double getTaxExcludedAmount() {
        return taxExcludedAmount;
    }

    public void setTaxExcludedAmount(Double taxExcludedAmount) {
        this.taxExcludedAmount = taxExcludedAmount;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }
}

