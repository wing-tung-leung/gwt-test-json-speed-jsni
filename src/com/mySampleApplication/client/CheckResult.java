package com.mySampleApplication.client;

import java.math.BigDecimal;

/**
 * Created by tung on 23/07/15.
 */
public interface CheckResult {

    String getStatus();
    void setStatus(String status);

    String getComment();
    void setComment(String comment);

    BigDecimal getAmount();
    void setAmount(BigDecimal amount);
}
