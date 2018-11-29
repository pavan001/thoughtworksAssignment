package com.thoughtworks.in.TestCase;

import com.thoughtworks.in.Pages.*;
import com.thoughtworks.in.base.TestSetUp;
import org.testng.annotations.Test;

public class EndToEndFlow extends TestSetUp {


    @Test
    public void flowOne() {

        HomePage page = new HomePage().open();

        SearchResultPage resultpage = page.searchForProduct();
        GoToCartPage cartpage = resultpage.clickOntheItem();
        Object object = cartpage.placeOrder();
        if (object instanceof LoginPage) {
            ((LoginPage) object).dologin("name", "pwd");
            PaymentPage paymentPage = new PaymentPage();
            paymentPage.clickonContinue();
            //Assertion pending
        }

    }


    @Test
    public void flowTwo() {

        HomePage page = new HomePage().open();
        LoginPage loginpage = page.clickOnLogin();
        Object obj = loginpage.dologin("name", "pwd");
        if (obj instanceof HomePage) {
            SearchResultPage resultPage = ((HomePage) obj).searchForProduct();
            GoToCartPage cartPage = resultPage.clickOntheItem();
            cartPage.placeOrder();
            PaymentPage paymentPage = new PaymentPage();
            paymentPage.clickonContinue();
            //Assertion pending


        }

    }

}
