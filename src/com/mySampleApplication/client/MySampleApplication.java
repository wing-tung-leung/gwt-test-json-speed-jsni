package com.mySampleApplication.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MySampleApplication implements EntryPoint {

    public static final int CHECK_RESULT_COUNT = 4000;

    public void onModuleLoad() {
        final Button button = new Button("Start JSON encoding tests");
        final Label label = new Label();
        final TextArea textArea1 = new TextArea();
        textArea1.setHeight("290px");
        textArea1.setWidth("500px");

        final ChecklistFactory f = GWT.create(ChecklistFactory.class);

        final ChecklistCodec clCodec = GWT.create(ChecklistCodec.class);

        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {

                long durationAutoBean = runAutoBeanTest();
                long durationResty = runRestyTest();
                long durationJsni = runJsniTest();

                StringBuilder out = new StringBuilder();

                out.append("autobean duration  = " + durationAutoBean).append("\n");
                out.append("resty duration  = " + durationResty).append("\n");
                out.append("jsni duration  = " + durationJsni).append("\n");

                textArea1.setText(out.toString());
            }

            private long runAutoBeanTest() {
                long setupStart = System.currentTimeMillis();
                AutoBean<Checklist> checklistBean = f.checklist();
                Checklist checklist = checklistBean.as();

                setChecklistAttributes(checklist);

                checklist.setCheckResults(new ArrayList<CheckResult>(CHECK_RESULT_COUNT));
                List<CheckResult> crs = checklist.getCheckResults();
                for (int i = 0; i < CHECK_RESULT_COUNT; ++i) {
                    CheckResult cr = f.checkResult().as();
                    setCheckResultAttributes(cr, i);
                    crs.add(cr);
                }
                long setupDuration = System.currentTimeMillis() - setupStart;
                GWT.log("autobean setup = " + setupDuration);

                long start = System.currentTimeMillis();
                AutoBean<Checklist> clBean = AutoBeanUtils.getAutoBean(checklist);
                String rawJson = AutoBeanCodex.encode(clBean).getPayload();
                long duration = System.currentTimeMillis() - start;

                GWT.log("autobean json length = " + rawJson.length());
//                GWT.log(checklistBean.toString());
//                GWT.log(clBean.toString());
                return duration;
            }

            private void setChecklistAttributes(Checklist checklist) {
                checklist.setAdvisor("advisor");
                checklist.setTechnician("technician");
                checklist.setDealer("10030");
                checklist.setNsc("MMD");
            }

            private void setCheckResultAttributes(CheckResult cr, int i) {
                cr.setStatus(i % 2 ==0 ? ResultStatus.OK : ResultStatus.NOK);
                cr.setComment("comment " + i);
                cr.setAmount(new BigDecimal("10." + i).setScale(4));
            }

            /** Superfast serialization, only conversion of BigDecimal bit slow. */
            private long runRestyTest() {
                long setupStart = System.currentTimeMillis();
                ChecklistTo checklist = new ChecklistTo();

                checklist.setAdvisor("advisor");
                checklist.setTechnician("technician");
                checklist.setDealer("10030");
                checklist.setNsc("MMD");
                //setChecklistAttributes(checklist);

                checklist.setCheckResults(new ArrayList<CheckResultTo>(CHECK_RESULT_COUNT));
                List<CheckResultTo> crs = checklist.getCheckResults();
                for (int i = 0; i < CHECK_RESULT_COUNT; ++i) {
                    CheckResultTo cr = new CheckResultTo();
                    setCheckResultAttributes(cr, i);
                    crs.add(cr);
                }

                long setupDuration = System.currentTimeMillis() - setupStart;
                GWT.log("resty setup = " + setupDuration);

                long start = System.currentTimeMillis();
                String rawJson = clCodec.encode(checklist).toString();
                long duration = System.currentTimeMillis() - start;

                //GWT.log("resty json = " + rawJson);
                GWT.log("resty json length = " + rawJson.length());
                return duration;
            }

            private long runJsniTest() {
                long setupStart = System.currentTimeMillis();

                ChecklistJso checklist = ChecklistJso.create("advisor", "technician");
                setChecklistAttributes(checklist);
                List<CheckResult> crs = new ArrayList<>(CHECK_RESULT_COUNT);
                //JsArray array = (JsArray) CheckResultJso.createArray(CHECK_RESULT_COUNT);
                for (int i = 0; i < CHECK_RESULT_COUNT; ++i) {
                    CheckResultJso cr = CheckResultJso.create(ResultStatus.UNCHECKED);
                    setCheckResultAttributes(cr, i);
                    crs.add(cr);
                }
                checklist.setCheckResults(crs);

                long setupDuration = System.currentTimeMillis() - setupStart;
                GWT.log("jsni setup = " + setupDuration);

                long start = System.currentTimeMillis();

//                GWT.log("toSource = " + checklist.toSource());
//                GWT.log("toString = " + checklist.toString());
                //GWT.log("jsni json = " + checklist.getJson());
                GWT.log("jsni json length = " + checklist.getJson().length());

                long duration = System.currentTimeMillis() - start;
                return duration;

            }
        });

        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        //
        RootPanel.get("slot1").

        add(button);

        RootPanel.get("slot2").

        add(label);

        RootPanel.get("out1").

        add(textArea1);

    }
}
