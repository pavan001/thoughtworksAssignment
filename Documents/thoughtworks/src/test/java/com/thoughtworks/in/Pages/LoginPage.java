package com.thoughtworks.in.Pages;

import com.thoughtworks.in.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {


    @FindBy(id = "login_field")
    public WebElement usernamefield;

    @FindBy(id = "password_field")
    public WebElement passwordfield;

    @FindBy(id = "submitbutton")
    public WebElement submitbutton;

    @FindBy(id = "if_user_loggedin")
    public WebElement loginstatus;


    public Object dologin(String username, String password) {
        if (loginstatus.getText().equalsIgnoreCase("Login & Signup")) {
            usernamefield.sendKeys(username);
            passwordfield.sendKeys(password);
            submitbutton.click();
            return openPage(HomePage.class);


        }
        return openPage(PaymentPage.class);


    }

    public ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(submitbutton);

    }
}
