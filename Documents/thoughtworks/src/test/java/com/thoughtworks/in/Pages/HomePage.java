package com.thoughtworks.in.Pages;

import com.thoughtworks.in.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {


    @FindBy(id = "some_id")
    public WebElement searchbox;


    @FindBy(xpath = "some_id1")
    public WebElement searchbutton;

    @FindBy(id = "Someid")
    public WebElement loginstatus;

    public SearchResultPage searchForProduct() {
        searchbox.click();
        searchbox.sendKeys("laptop");
        searchbutton.click();
        return (SearchResultPage) openPage(SearchResultPage.class);

    }

    public LoginPage clickOnLogin() {
        loginstatus.click();
        return (LoginPage) openPage(LoginPage.class);

    }


    public HomePage open() {
        return (HomePage) openPage(HomePage.class);

    }


    @Override
    public ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(searchbutton);
    }
}
