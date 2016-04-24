package com.outsource.qa.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;

/**
 * Created by user on 4/20/2016.
 */
public class PageBase {
    protected RemoteWebDriver driver;

    public PageBase(RemoteWebDriver driver) {
        this.driver = driver;
    }

    protected void initializeElements(BasicPage sourcePage) {
        //new FrameworkProperties();
        new LinkedHashMap();
        String strDefault = "";
        String strFindBy = "";
        String strValue = "";
        Field[] arr$ = sourcePage.getClass().getDeclaredFields();
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Field field = arr$[i$];
            String name = field.getName();
            System.out.println(name);
            System.out.println(sourcePage.getClass().getPackage().getName().toString());
            System.out.println(sourcePage.getClass().getSimpleName());
        }

    }

    public void test_step_initiation() {
        //Reporter.log("<pre>" + Thread.currentThread().getStackTrace()[2].getMethodName() + "</pre>");
    }
}
