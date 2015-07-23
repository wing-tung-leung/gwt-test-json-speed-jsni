package com.mySampleApplication.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
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

    public void onModuleLoad() {
        final Button button = new Button("Click me");
        final Label label = new Label();
        final TextArea textArea1 = new TextArea();

        final ChecklistFactory f = GWT.create(ChecklistFactory.class);

        final ChecklistCodec clCodec = GWT.create(ChecklistCodec.class);

        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                /*
                if (label.getText().equals("")) {
                    MySampleApplicationService.App.getInstance().getMessage("Hello, World!", new MyAsyncCallback(label));
                } else {
                    label.setText("");
                }
                */

                long durationAutoBean = runAutoBeanTest();
                long durationResty = runRestyTest();

                label.setText(Long.toString(durationAutoBean));

                StringBuilder out = new StringBuilder();

                out.append("autobean duration  = " + durationAutoBean).append("\n");
                out.append("resty duration  = " + durationResty);

                textArea1.setText(out.toString());
            }

            private long runAutoBeanTest() {
                AutoBean<Checklist> checklistBean = f.checklist();
                Checklist checklist = checklistBean.as();

                checklist.setAdvisor("advisor");
                checklist.setTechnician("technician");
                checklist.setDealer("10030");
                checklist.setNsc("MMD");
                checklist.setCheckResults(new ArrayList<CheckResult>(1000));
                List<CheckResult> crs = checklist.getCheckResults();
                for (int i = 0 ; i < 1000 ; ++i) {
                    CheckResult cr = f.checkResult().as();
                    cr.setStatus("OK" + i);
                    cr.setComment("comment" + i);
                    cr.setAmount(new BigDecimal(Integer.toString(i) + ".125"));
                    crs.add(cr);
                }

                long start = System.currentTimeMillis();
                AutoBean<Checklist> clBean = AutoBeanUtils.getAutoBean(checklist);
                String rawJson = AutoBeanCodex.encode(clBean).getPayload();
                long duration = System.currentTimeMillis() - start;
                GWT.log(rawJson);
                GWT.log(checklistBean.toString());
                GWT.log(clBean.toString());
                return duration;
            }

            private long runRestyTest() {
                ChecklistTo checklist = new ChecklistTo();

                checklist.setAdvisor("advisor");
                checklist.setTechnician("technician");
                checklist.setDealer("10030");
                checklist.setNsc("MMD");
                checklist.setCheckResults(new ArrayList<CheckResultTo>(1000));
                List<CheckResultTo> crs = checklist.getCheckResults();
                for (int i = 0 ; i < 1000 ; ++i) {
                    CheckResultTo cr = new CheckResultTo();
                    cr.setStatus("OK" + i);
                    cr.setComment("comment" + i);
                    cr.setAmount(new BigDecimal(Integer.toString(i) + ".125"));
                    crs.add(cr);
                }

                long start = System.currentTimeMillis();

                String rawJson = clCodec.encode(checklist).toString();
                long duration = System.currentTimeMillis() - start;
                GWT.log(rawJson);
                return duration;
            }
        });

        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        //
        RootPanel.get("slot1").add(button);
        RootPanel.get("slot2").add(label);
        RootPanel.get("out1").add(textArea1);
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
}
