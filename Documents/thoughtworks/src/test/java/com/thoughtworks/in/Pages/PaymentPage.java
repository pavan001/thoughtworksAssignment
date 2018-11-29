package com.thoughtworks.in.Pages;


import com.thoughtworks.in.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentPage extends BasePage {

    @FindBy(id = "Some_id")
    public WebElement continuebuttontoPaymentPage;

    public PaymentPage clickonContinue() {
        continuebuttontoPaymentPage.click();
        return this;
    }

    public ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(continuebuttontoPaymentPage);

    }
}
