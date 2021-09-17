package com.service.banking.model.transaction;

public class MemorandumDetails {

    private Integer id;
    private String memorandumType;
    private Integer memorandumTypeId;
    private Integer accountDr;
    private Integer accountCr;
    private Double tax;
    private Double amount;
    private String narration;
    private Integer branchId;
    private Integer staffId;
    private String narration2;

    public MemorandumDetails() {
    }

    public MemorandumDetails(Integer id, String memorandumType, Integer memorandumTypeId, Integer accountDr, Integer accountCr, Double tax, Double amount, String narration, Integer branchId, Integer staffId) {
        this.id = id;
        this.memorandumType = memorandumType;
        this.memorandumTypeId = memorandumTypeId;
        this.accountDr = accountDr;
        this.accountCr = accountCr;
        this.tax = tax;
        this.amount = amount;
        this.narration = narration;
        this.branchId = branchId;
        this.staffId = staffId;
    }

    public MemorandumDetails(Integer id, String memorandumType, Integer memorandumTypeId, Integer accountDr, Integer accountCr, Double tax, Double amount, String narration, Integer branchId, Integer staffId, String narration2) {
        this.id = id;
        this.memorandumType = memorandumType;
        this.memorandumTypeId = memorandumTypeId;
        this.accountDr = accountDr;
        this.accountCr = accountCr;
        this.tax = tax;
        this.amount = amount;
        this.narration = narration;
        this.branchId = branchId;
        this.staffId = staffId;
        this.narration2=narration2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemorandumType() {
        return memorandumType;
    }

    public void setMemorandumType(String memorandumType) {
        this.memorandumType = memorandumType;
    }

    public Integer getAccountDr() {
        return accountDr;
    }

    public void setAccountDr(Integer accountDr) {
        this.accountDr = accountDr;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
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

    public Integer getAccountCr() {
        return accountCr;
    }

    public void setAccountCr(Integer accountCr) {
        this.accountCr = accountCr;
    }

    public Integer getMemorandumTypeId() {
        return memorandumTypeId;
    }

    public void setMemorandumTypeId(Integer memorandumTypeId) {
        this.memorandumTypeId = memorandumTypeId;
    }

    public String getNarration2() {
        return narration2;
    }

    public void setNarration2(String narration2) {
        this.narration2 = narration2;
    }
}
