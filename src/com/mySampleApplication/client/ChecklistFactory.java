package com.mySampleApplication.client;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;

/**
 * Created by tung on 23/07/15.
 */
public interface ChecklistFactory extends AutoBeanFactory {
    AutoBean<Checklist> checklist();
    AutoBean<CheckResult> checkResult();
}
