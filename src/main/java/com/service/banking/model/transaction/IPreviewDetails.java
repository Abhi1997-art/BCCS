package com.service.banking.model.transaction;

import java.util.Date;

public interface IPreviewDetails {

    public Integer getId();
    public String getType();
    public String getName();
    public String getAmount();
    public Date getLastPremiumDate();
    public Integer getDuePremiums();
    public String getAccountNumber();
    public String getModeOfOperation();
    public Integer getPaidPremiums();
    public Integer getTotalPremiums();
    public Date getCreated_At();
    public String getPre_Mature_Interests();
}
