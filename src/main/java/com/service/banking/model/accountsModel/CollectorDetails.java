package com.service.banking.model.accountsModel;

public class CollectorDetails {

    private Integer collectorId;
    private String collecterName;
    private Integer collecterCodeNo;
    private String collecterCurrentAddress;
    private Integer collectorNo;
    private String collecterLandmark;
    private Boolean collectorDeafulter;

    public CollectorDetails() {
    }

    public CollectorDetails(Integer collectorId, String collecterName, Integer collecterCodeNo, String collecterCurrentAddress, Integer collectorNo, String collecterLandmark, Boolean collectorDeafulter) {
        this.collectorId = collectorId;
        this.collecterName = collecterName;
        this.collecterCodeNo = collecterCodeNo;
        this.collecterCurrentAddress = collecterCurrentAddress;
        this.collectorNo = collectorNo;
        this.collecterLandmark = collecterLandmark;
        this.collectorDeafulter = collectorDeafulter;
    }

    public CollectorDetails(Integer collecterCodeNo, String collecterName, Integer collectorId, String collecterCurrentAddress,  String collecterLandmark) {
        this.collectorId = collectorId;
        this.collecterName = collecterName;
        this.collecterCodeNo = collecterCodeNo;
        this.collecterCurrentAddress = collecterCurrentAddress;
        this.collectorNo = collectorNo;
        this.collecterLandmark = collecterLandmark;
        this.collectorDeafulter = collectorDeafulter;
    }

    public Integer getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(Integer collectorId) {
        this.collectorId = collectorId;
    }

    public String getCollecterName() {
        return collecterName;
    }

    public void setCollecterName(String collecterName) {
        this.collecterName = collecterName;
    }

    public Integer getCollecterCodeNo() {
        return collecterCodeNo;
    }

    public void setCollecterCodeNo(Integer collecterCodeNo) {
        this.collecterCodeNo = collecterCodeNo;
    }

    public String getCollecterCurrentAddress() {
        return collecterCurrentAddress;
    }

    public void setCollecterCurrentAddress(String collecterCurrentAddress) {
        this.collecterCurrentAddress = collecterCurrentAddress;
    }

    public Integer getCollectorNo() {
        return collectorNo;
    }

    public void setCollectorNo(Integer collectorNo) {
        this.collectorNo = collectorNo;
    }

    public String getCollecterLandmark() {
        return collecterLandmark;
    }

    public void setCollecterLandmark(String collecterLandmark) {
        this.collecterLandmark = collecterLandmark;
    }

    public Boolean getCollectorDeafulter() {
        return collectorDeafulter;
    }

    public void setCollectorDeafulter(Boolean collectorDeafulter) {
        this.collectorDeafulter = collectorDeafulter;
    }
}
