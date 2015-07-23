package com.mySampleApplication.client;

import java.math.BigDecimal;

/**
 * Created by tung on 23/07/15.
 */
public class CheckResultTo implements CheckResult {

    private String status;
    private String comment;
    private BigDecimal amount;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
