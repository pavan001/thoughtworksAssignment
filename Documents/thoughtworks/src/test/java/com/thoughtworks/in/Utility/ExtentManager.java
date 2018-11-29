package com.thoughtworks.in.Utility;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {

    private static ExtentReports extent;
    //private static ExtentTest test;
    private static ExtentHtmlReporter htmlReporter;
    private static String filePath = "./extentreport.html";


    public static ExtentReports GetExtent() {
        if (extent != null) {
            return extent;
        } else {
            extent = new ExtentReports();
            extent.attachReporter(getHtmlReporter());
            extent.setSystemInfo("Host Name", "pavan");

            extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
            return extent;
        }
    }

    public static ExtentHtmlReporter getHtmlReporter() {

        htmlReporter = new ExtentHtmlReporter(filePath);


        htmlReporter.setAppendExisting(false);
        htmlReporter.loadXMLConfig("/Users/pavan/Documents/thoughtworks/src/main/resources/ReportsConfig.xml");

        return htmlReporter;
    }
}
