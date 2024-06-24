package org.dfn.qa.test;

import dfn.base.BaseClass;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class NewOrderSellTest extends BaseClass {
    Logger logger = Logger.getLogger(String.valueOf(NewOrderSellTest.class));

    @Test(priority = 1)
    public void testSuccessfulNewOrderLimitBuyWithDayAs_TIF_Type() throws InterruptedException {

        loginPage.loadPage(loginurl);
        loginPage.setUsername(userName);
        loginPage.setPassword(password);
        loginPage.clickAcceptTermsBtn();
        loginPage.clickRememberMeBtn();
        loginPage.clickLogin();
        newOrderSellPage.clickTradeWidget();
        newOrderSellPage.clickToggle();
        newOrderSellPage.clearSymbolSearchField();
        newOrderSellPage.setSearchSymbol();
        newOrderSellPage.searchSymbol();
        newOrderSellPage.clickOrderType();
        newOrderSellPage.setOrderTypeAsLimit();
        newOrderSellPage.setQtyValue();
        newOrderSellPage.setPriceValue();
        newOrderSellPage.clickTIF_TypeBtn();
        newOrderSellPage.setTIFTypeAs_Day();
        newOrderSellPage.setDisclosedQty();
        newOrderSellPage.setMinimumFillValue();
        newOrderSellPage.clickAllOrNoneBtn();
        newOrderSellPage.clickSellBtn();
        newOrderSellPage.clickConfirmBtn();
        logoutPage.clickLogout();

    }

    @Test(priority = 2)
    public void testSuccessfulNewOrderMarketBuyWithDayAs_TIF_Type() throws InterruptedException {

        loginPage.loadPage(loginurl);
        loginPage.setUsername(userName);
        loginPage.setPassword(password);
        loginPage.clickAcceptTermsBtn();
        loginPage.clickRememberMeBtn();
        loginPage.clickLogin();
        newOrderSellPage.clickTradeWidget();
        newOrderSellPage.clickToggle();
        newOrderSellPage.clearSymbolSearchField();
        newOrderSellPage.setSearchSymbol();
        newOrderSellPage.searchSymbol();
        newOrderSellPage.clickOrderType();
        newOrderSellPage.setOrderTypeAs_Market();
        newOrderSellPage.setQtyValue();
        newOrderSellPage.setPriceValue();
        newOrderSellPage.clickTIF_TypeBtn();
        newOrderSellPage.setTIFTypeAs_Day();
        newOrderSellPage.setDisclosedQty();
        newOrderSellPage.setMinimumFillValue();
        newOrderSellPage.clickAllOrNoneBtn();
        newOrderSellPage.clickSellBtn();
        newOrderSellPage.clickConfirmBtn();
        logoutPage.clickLogout();

    }
}
