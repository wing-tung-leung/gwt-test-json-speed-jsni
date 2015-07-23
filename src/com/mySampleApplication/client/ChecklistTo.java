package com.mySampleApplication.client;

import java.util.List;

/**
 * Created by tung on 23/07/15.
 */
public class ChecklistTo  {

    private long id;
    private String advisor;
    private String technician;
    private String dealer;
    private String nsc;

    private List<CheckResultTo> checkResults;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getAdvisor() {
        return advisor;
    }


    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }


    public String getTechnician() {
        return technician;
    }


    public void setTechnician(String technician) {
        this.technician = technician;
    }


    public String getDealer() {
        return dealer;
    }


    public void setDealer(String dealer) {
        this.dealer = dealer;
    }


    public String getNsc() {
        return nsc;
    }


    public void setNsc(String nsc) {
        this.nsc = nsc;
    }


    public List<CheckResultTo> getCheckResults() {
        return checkResults;
    }


    public void setCheckResults(List<CheckResultTo> checkResults) {
        this.checkResults = checkResults;
    }
}
