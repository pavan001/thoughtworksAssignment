package com.thoughtworks.in.Pages;

import com.thoughtworks.in.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoToCartPage extends BasePage {

    @FindBy(id = "place_order_id")
    public WebElement placeorderbutton;

    @FindBy(id = "if_user_loggedin")
    public WebElement loginstatus;


    public Object placeOrder() {

        if (loginstatus.getText().equalsIgnoreCase("Login & Signup")) {
            placeorderbutton.click();
            return openPage(LoginPage.class);

        }
        placeorderbutton.click();
        return openPage(PaymentPage.class);

    }


    @Override
    public ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(placeorderbutton);
    }


}




