package com.mySampleApplication.client;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.math.BigDecimal;

/**
 * Created by tung on 23/07/15.
 */
//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.WRAPPER_OBJECT, property = "class", defaultImpl = CheckResultTo.class)
public interface CheckResult {

    ResultStatus getStatus();
    void setStatus(ResultStatus status);

    String getComment();
    void setComment(String comment);

    BigDecimal getAmount();
    void setAmount(BigDecimal amount);
}
