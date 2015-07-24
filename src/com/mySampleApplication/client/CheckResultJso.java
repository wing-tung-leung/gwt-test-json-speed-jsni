package com.mySampleApplication.client;

import com.google.gwt.core.client.JavaScriptObject;

import java.math.BigDecimal;

public class CheckResultJso extends JavaScriptObject implements CheckResult {

    protected CheckResultJso() {
    }

    public static final native CheckResultJso create(ResultStatus status) /*-{
        return {status: status};
    }-*/;

    public final ResultStatus getStatus() {
        return ResultStatus.valueOf(getStatusRaw());
    }

    public final void setStatus(ResultStatus status) {
        setStatusRaw(status.name());
    }

    public final native String getStatusRaw() /*-{
        return status;
    }-*/;

    public final native  void setStatusRaw(String status) /*-{
        this.status = status;
    }-*/;

    public final native  String getComment() /*-{
        return comment;
    }-*/;

    public final native  void setComment(String comment) /*-{
        this.comment = comment;
    }-*/;

    public final BigDecimal getAmount() {
        return new BigDecimal(getAmountRaw());
    }

    public final void setAmount(BigDecimal amount) {
        setAmountRaw(amount.floatValue());
        // float conversion is rather slow, maybe we need something else
        // OK for rounding ???
    }

    public final native float getAmountRaw() /*-{
        return amount;
    }-*/;

    public final native void setAmountRaw(float amount) /*-{
        this.amount = amount;
    }-*/;
}
