package com.service.banking.model.accountsModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import springfox.documentation.spring.web.json.Json;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OtherValues {

    public String jointMember[];
    public String documentFeeded[];
    public Integer loanFromAccountId;
    public Double smAmount;
    public Integer otherAccountId;
    public Double accountCrAmount;

    private String policyNumber;
    private String ownerChequeNo;
    private String stamp;
    private String gaurantorStamp;
    private String keyNo;
    private String vehicleNo;
    private String recoveryStatus;
    private String legalCaseStatus;
    private String chassisNo;
    private String engineNo;
    private String loanChequePaidDetail;
    private String gaurantoeChaqueNo;
    private String fiStatus;
    private String phoneFollowUp;
    private String welcomeCall;
    private String nocStatus;
    private String notice;
    private String visitCharge;
    private String remark;
    private String bikeSurrender;
    private String legalCaseSubmitted;
    private String invastigationJanch;
    private String prasangGhyan;
    private String summons;
    private String bailableWarrantJamantiWarrant;
    private String arrestWarrant;
    private String allegationAarop;
    private String evidenceGawah;
    private String debateBahas;
    private String order;
    private String bikeLocation;
    private String loanSecurity;
    private String accountPendency;
    private String model;
    private String legalBikeStatus;
    private String arbitrationStage;
    private String arbitrationVisitStatus;
    private String loanRemark;
    private String taxReceipt;
    private String accountDontGiveToRo;
    private String rrTrackingNumber;


    public OtherValues() {
    }

    public OtherValues(String[] jointMember, String[] documentFeeded, Integer loanFromAccountId, Double smAmount, Integer otherAccountId, Double accountCrAmount, String policyNumber, String ownerChequeNo, String stamp, String gaurantorStamp, String keyNo, String vehicleNo, String recoveryStatus, String legalCaseStatus, String chassisNo, String engineNo, String loanChequePaidDetail, String gaurantoeChaqueNo, String fiStatus, String phoneFollowUp, String welcomeCall, String nocStatus, String notice, String visitCharge, String remark, String bikeSurrender, String legalCaseSubmitted, String invastigationJanch, String prasangGhyan, String summons, String bailableWarrantJamantiWarrant, String arrestWarrant, String allegationAarop, String evidenceGawah, String debateBahas, String order, String bikeLocation, String loanSecurity, String accountPendency, String model, String legalBikeStatus, String arbitrationStage, String arbitrationVisitStatus, String loanRemark, String taxReceipt, String accountDontGiveToRo, String rrTrackingNumber) {
        this.jointMember = jointMember;
        this.documentFeeded = documentFeeded;
        this.loanFromAccountId = loanFromAccountId;
        this.smAmount = smAmount;
        this.otherAccountId = otherAccountId;
        this.accountCrAmount = accountCrAmount;
        this.policyNumber = policyNumber;
        this.ownerChequeNo = ownerChequeNo;
        this.stamp = stamp;
        this.gaurantorStamp = gaurantorStamp;
        this.keyNo = keyNo;
        this.vehicleNo = vehicleNo;
        this.recoveryStatus = recoveryStatus;
        this.legalCaseStatus = legalCaseStatus;
        this.chassisNo = chassisNo;
        this.engineNo = engineNo;
        this.loanChequePaidDetail = loanChequePaidDetail;
        this.gaurantoeChaqueNo = gaurantoeChaqueNo;
        this.fiStatus = fiStatus;
        this.phoneFollowUp = phoneFollowUp;
        this.welcomeCall = welcomeCall;
        this.nocStatus = nocStatus;
        this.notice = notice;
        this.visitCharge = visitCharge;
        this.remark = remark;
        this.bikeSurrender = bikeSurrender;
        this.legalCaseSubmitted = legalCaseSubmitted;
        this.invastigationJanch = invastigationJanch;
        this.prasangGhyan = prasangGhyan;
        this.summons = summons;
        this.bailableWarrantJamantiWarrant = bailableWarrantJamantiWarrant;
        this.arrestWarrant = arrestWarrant;
        this.allegationAarop = allegationAarop;
        this.evidenceGawah = evidenceGawah;
        this.debateBahas = debateBahas;
        this.order = order;
        this.bikeLocation = bikeLocation;
        this.loanSecurity = loanSecurity;
        this.accountPendency = accountPendency;
        this.model = model;
        this.legalBikeStatus = legalBikeStatus;
        this.arbitrationStage = arbitrationStage;
        this.arbitrationVisitStatus = arbitrationVisitStatus;
        this.loanRemark = loanRemark;
        this.taxReceipt = taxReceipt;
        this.accountDontGiveToRo = accountDontGiveToRo;
        this.rrTrackingNumber = rrTrackingNumber;
    }

    public String[] getJointMember() {
        return jointMember;
    }

    public void setJointMember(String[] jointMember) {
        this.jointMember = jointMember;
    }

    public String[] getDocumentFeeded() {
        return documentFeeded;
    }

    public void setDocumentFeeded(String[] documentFeeded) {
        this.documentFeeded = documentFeeded;
    }

    public Integer getLoanFromAccountId() {
        return loanFromAccountId;
    }

    public void setLoanFromAccountId(Integer loanFromAccountId) {
        this.loanFromAccountId = loanFromAccountId;
    }

    public Double getSmAmount() {
        return smAmount;
    }

    public void setSmAmount(Double smAmount) {
        this.smAmount = smAmount;
    }

    public Integer getOtherAccountId() {
        return otherAccountId;
    }

    public void setOtherAccountId(Integer otherAccountId) {
        this.otherAccountId = otherAccountId;
    }

    public Double getAccountCrAmount() {
        return accountCrAmount;
    }

    public void setAccountCrAmount(Double accountCrAmount) {
        this.accountCrAmount = accountCrAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getOwnerChequeNo() {
        return ownerChequeNo;
    }

    public void setOwnerChequeNo(String ownerChequeNo) {
        this.ownerChequeNo = ownerChequeNo;
    }

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    public String getGaurantorStamp() {
        return gaurantorStamp;
    }

    public void setGaurantorStamp(String gaurantorStamp) {
        this.gaurantorStamp = gaurantorStamp;
    }

    public String getKeyNo() {
        return keyNo;
    }

    public void setKeyNo(String keyNo) {
        this.keyNo = keyNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getRecoveryStatus() {
        return recoveryStatus;
    }

    public void setRecoveryStatus(String recoveryStatus) {
        this.recoveryStatus = recoveryStatus;
    }

    public String getLegalCaseStatus() {
        return legalCaseStatus;
    }

    public void setLegalCaseStatus(String legalCaseStatus) {
        this.legalCaseStatus = legalCaseStatus;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getLoanChequePaidDetail() {
        return loanChequePaidDetail;
    }

    public void setLoanChequePaidDetail(String loanChequePaidDetail) {
        this.loanChequePaidDetail = loanChequePaidDetail;
    }

    public String getGaurantoeChaqueNo() {
        return gaurantoeChaqueNo;
    }

    public void setGaurantoeChaqueNo(String gaurantoeChaqueNo) {
        this.gaurantoeChaqueNo = gaurantoeChaqueNo;
    }

    public String getFiStatus() {
        return fiStatus;
    }

    public void setFiStatus(String fiStatus) {
        this.fiStatus = fiStatus;
    }

    public String getPhoneFollowUp() {
        return phoneFollowUp;
    }

    public void setPhoneFollowUp(String phoneFollowUp) {
        this.phoneFollowUp = phoneFollowUp;
    }

    public String getWelcomeCall() {
        return welcomeCall;
    }

    public void setWelcomeCall(String welcomeCall) {
        this.welcomeCall = welcomeCall;
    }

    public String getNocStatus() {
        return nocStatus;
    }

    public void setNocStatus(String nocStatus) {
        this.nocStatus = nocStatus;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getVisitCharge() {
        return visitCharge;
    }

    public void setVisitCharge(String visitCharge) {
        this.visitCharge = visitCharge;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBikeSurrender() {
        return bikeSurrender;
    }

    public void setBikeSurrender(String bikeSurrender) {
        this.bikeSurrender = bikeSurrender;
    }

    public String getLegalCaseSubmitted() {
        return legalCaseSubmitted;
    }

    public void setLegalCaseSubmitted(String legalCaseSubmitted) {
        this.legalCaseSubmitted = legalCaseSubmitted;
    }

    public String getInvastigationJanch() {
        return invastigationJanch;
    }

    public void setInvastigationJanch(String invastigationJanch) {
        this.invastigationJanch = invastigationJanch;
    }

    public String getPrasangGhyan() {
        return prasangGhyan;
    }

    public void setPrasangGhyan(String prasangGhyan) {
        this.prasangGhyan = prasangGhyan;
    }

    public String getSummons() {
        return summons;
    }

    public void setSummons(String summons) {
        this.summons = summons;
    }

    public String getBailableWarrantJamantiWarrant() {
        return bailableWarrantJamantiWarrant;
    }

    public void setBailableWarrantJamantiWarrant(String bailableWarrantJamantiWarrant) {
        this.bailableWarrantJamantiWarrant = bailableWarrantJamantiWarrant;
    }

    public String getArrestWarrant() {
        return arrestWarrant;
    }

    public void setArrestWarrant(String arrestWarrant) {
        this.arrestWarrant = arrestWarrant;
    }

    public String getAllegationAarop() {
        return allegationAarop;
    }

    public void setAllegationAarop(String allegationAarop) {
        this.allegationAarop = allegationAarop;
    }

    public String getEvidenceGawah() {
        return evidenceGawah;
    }

    public void setEvidenceGawah(String evidenceGawah) {
        this.evidenceGawah = evidenceGawah;
    }

    public String getDebateBahas() {
        return debateBahas;
    }

    public void setDebateBahas(String debateBahas) {
        this.debateBahas = debateBahas;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getBikeLocation() {
        return bikeLocation;
    }

    public void setBikeLocation(String bikeLocation) {
        this.bikeLocation = bikeLocation;
    }

    public String getLoanSecurity() {
        return loanSecurity;
    }

    public void setLoanSecurity(String loanSecurity) {
        this.loanSecurity = loanSecurity;
    }

    public String getAccountPendency() {
        return accountPendency;
    }

    public void setAccountPendency(String accountPendency) {
        this.accountPendency = accountPendency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLegalBikeStatus() {
        return legalBikeStatus;
    }

    public void setLegalBikeStatus(String legalBikeStatus) {
        this.legalBikeStatus = legalBikeStatus;
    }

    public String getArbitrationStage() {
        return arbitrationStage;
    }

    public void setArbitrationStage(String arbitrationStage) {
        this.arbitrationStage = arbitrationStage;
    }

    public String getArbitrationVisitStatus() {
        return arbitrationVisitStatus;
    }

    public void setArbitrationVisitStatus(String arbitrationVisitStatus) {
        this.arbitrationVisitStatus = arbitrationVisitStatus;
    }

    public String getLoanRemark() {
        return loanRemark;
    }

    public void setLoanRemark(String loanRemark) {
        this.loanRemark = loanRemark;
    }

    public String getTaxReceipt() {
        return taxReceipt;
    }

    public void setTaxReceipt(String taxReceipt) {
        this.taxReceipt = taxReceipt;
    }

    public String getAccountDontGiveToRo() {
        return accountDontGiveToRo;
    }

    public void setAccountDontGiveToRo(String accountDontGiveToRo) {
        this.accountDontGiveToRo = accountDontGiveToRo;
    }

    public String getRrTrackingNumber() {
        return rrTrackingNumber;
    }

    public void setRrTrackingNumber(String rrTrackingNumber) {
        this.rrTrackingNumber = rrTrackingNumber;
    }
}
