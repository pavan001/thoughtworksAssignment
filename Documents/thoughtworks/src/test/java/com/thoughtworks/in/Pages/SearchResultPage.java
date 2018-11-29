package com.thoughtworks.in.Pages;


import com.thoughtworks.in.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends BasePage {


    @FindBy(id = "some_item")
    public WebElement item;

    @FindBy(id = "some_cart_id")
    public WebElement addtocart;


    public GoToCartPage clickOntheItem() {
        item.click();
        addtocart.click();
        return (GoToCartPage) openPage(GoToCartPage.class);


    }


    @Override
    public ExpectedCondition getPageLoadCondition() {
        return ExpectedConditions.visibilityOf(item);
    }
}
