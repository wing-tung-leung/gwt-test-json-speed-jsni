package com.mySampleApplication.client;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tung on 23/07/15.
 */
public interface Checklist {

    Long getId();

    String getNsc();
    void setNsc(String nsc);

    String getDealer();
    void setDealer(String dealer);

    String getAdvisor();
    void setAdvisor(String advisor);

    String getTechnician();
    void setTechnician(String technician);

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.WRAPPER_ARRAY, property = "class", defaultImpl = CheckResultTo.class)
    List<CheckResult> getCheckResults();

    void setCheckResults(List<CheckResult> checkResults);
}
