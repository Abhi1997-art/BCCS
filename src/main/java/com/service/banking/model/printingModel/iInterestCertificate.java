package com.service.banking.model.printingModel;

import javax.persistence.Column;
import java.math.BigDecimal;

public interface iInterestCertificate {

    public Integer getId();
    public String getAccountNumber();
    public BigDecimal getAmountDr();
    public BigDecimal getAmountCr();
}
