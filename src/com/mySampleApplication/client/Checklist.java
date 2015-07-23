package com.mySampleApplication.client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tung on 23/07/15.
 */
public interface Checklist {

    long getId();

    String getNsc();
    void setNsc(String nsc);

    String getDealer();
    void setDealer(String dealer);

    String getAdvisor();
    void setAdvisor(String advisor);

    String getTechnician();
    void setTechnician(String technician);

    List<CheckResult> getCheckResults();

    void setCheckResults(List<CheckResult> checkResults);
}
