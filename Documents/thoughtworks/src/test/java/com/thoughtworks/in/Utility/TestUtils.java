package com.thoughtworks.in.Utility;

import com.thoughtworks.in.base.TestSetUp;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestUtils extends TestSetUp {

    public static String screenshotPath;
    public static String screenshotName;

    /*
     * @description: Method to take capture screenshot
     */
    public static void captureScreenshot() throws IOException {

        screenshotPath = "./Screenshots/";
        File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

        Date d = new Date();
        screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";


        FileUtils.copyFile(scrFile,
                new File(screenshotPath + screenshotName));


    }
}