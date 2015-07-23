package com.mySampleApplication.client;

import java.math.BigDecimal;

/**
 * Created by tung on 23/07/15.
 */
public class CheckResultTo implements CheckResult {

    private ResultStatus status;
    private String comment;
    private BigDecimal amount;

    public ResultStatus getStatus() {
        return status;
    }

    public void setStatus(ResultStatus status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
