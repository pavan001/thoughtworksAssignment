package com.thoughtworks.in.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.thoughtworks.in.Utility.DriverFactory;
import com.thoughtworks.in.Utility.DriverManager;
import com.thoughtworks.in.Utility.ExtentManager;
import com.thoughtworks.in.Utility.PropertyFileManager;
import com.thoughtworks.in.customAnnotation.TestCaseId;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Properties;


public class TestSetUp {


    public static ExtentReports extent;
    public static ThreadLocal<ExtentTest> classLevelReport = new ThreadLocal<ExtentTest>();
    public static ThreadLocal<ExtentTest> testLevelReport = new ThreadLocal<ExtentTest>();
    protected static Properties configProperty;
    protected WebDriver driver = null;

    @BeforeSuite
    public void setUp() {

        PropertyFileManager.setConfigFilePath(
                System.getProperty("user.dir") + "/src/main/resources/config.properties");
        DriverFactory.setChromeExeFilePath("");
        DriverFactory.setIeExeFilePath("");
        extent = ExtentManager.GetExtent();


    }

    @BeforeTest
    public void beforeTest() {

    }

    @BeforeClass
    public synchronized void beforeClass() {


        System.out.println("before class called");
        ExtentTest parent = extent.createTest(getClass().getSimpleName());
        classLevelReport.set(parent);
        configProperty = PropertyFileManager.createConfigFileProperty();
    }

    @BeforeMethod
    public synchronized void beforeMethod(Method method) {
        System.out.println("before method called");
        TestCaseId testCaseId = method.getAnnotation(TestCaseId.class);
        System.out.println(testCaseId.testCaseId());
        //String browser=getBrowserName(testCaseId.testCaseId())
        WebDriver driver = null;
        System.out.println("executing beforeMethod");
        System.out.println("Driver-->" + driver);
        if (driver == null) {
            //configProperty = PropertyFileManager.createConfigFileProperty();

            driver = DriverFactory.createDriverInstance(configProperty.getProperty("browser"));
            DriverManager.getDriver().navigate().to(configProperty.getProperty("testSiteUrl"));

        }

    }

    @AfterMethod
    public synchronized void afterMethod(ITestResult result) {


        extent.flush();

        DriverManager.getDriver().quit();

    }

    @AfterClass
    public void afterClass() {

    }

    @AfterTest
    public void afterTest() {

    }

    @AfterSuite
    public void tearDown() {
        // extent.flush();
    }

}
