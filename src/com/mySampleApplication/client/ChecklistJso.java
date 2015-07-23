package com.mySampleApplication.client;

import com.google.gwt.core.client.JavaScriptObject;

import java.util.List;

/**
 * Created by tung on 23/07/15.
 */
public class ChecklistJso extends JavaScriptObject implements Checklist {

    protected ChecklistJso() { }

    public static native ChecklistJso create(String advisor, String technician) /*-{
        return {advisor: advisor, technician: technician};
    }-*/;

    public final native String getTechnician() /*-{
        return this.technician;
    }-*/;

    public final native void setTechnician(String technician) /*-{
        this.technician =  technician;
    }-*/;

    public final native List<CheckResult> getCheckResults() /*-{
        return this.checkResults;
    }-*/;

    public final native void setCheckResults(List<CheckResult> checkResults) /*-{
        this.checkResults = checkResults;
    }-*/;

    public final native String getAdvisor() /*-{
        return this.advisor;
    }-*/;

    public final native void setAdvisor(String advisor) /*-{
        this.advisor =  advisor;
    }-*/;


    public final native Long getId() /*-{
        return this.id;
    }-*/;

    public final native String getNsc() /*-{
        return this.nsc;
    }-*/;

    public final native void setNsc(String nsc) /*-{
        this.nsc =  nsc;
    }-*/;


    public final native String getDealer() /*-{
        return this.dealer;
    }-*/;

    public final native void setDealer(String dealer) /*-{
        this.dealer =  dealer;
    }-*/;


    public final native String getJson() /*-{
        return JSON.stringify(this);
    }-*/;

}
