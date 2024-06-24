package org.dfn.qa.test;

import dfn.base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class NewOrderBuyTest extends BaseClass {

    Logger logger = Logger.getLogger(String.valueOf(NewOrderBuyTest.class));
    @Test(priority = 1)
    public void testSuccessfulNewOrderLimitBuyWithDayAs_TIF_Type() throws InterruptedException {

        loginPage.loadPage(loginurl);
        loginPage.setUsername(userName);
        loginPage.setPassword(password);
        loginPage.clickAcceptTermsBtn();
        loginPage.clickRememberMeBtn();
        loginPage.clickLogin();
        newOrderBuyPage.clickTradeWidget();
        if (!newOrderBuyPage.checkOrderBuyOrSell().equals("Buy")){
            newOrderBuyPage.clickOrderToggle();
            logger.info("User is change the order to the Buy");
        }
        else{
            Assert.assertEquals(newOrderBuyPage.checkOrderBuyOrSell(),"Buy" , "");
            logger.info("User is ready to place the Buy order");
        }
        newOrderBuyPage.clearSymbolSearchField();
        newOrderBuyPage.setSearchSymbol();
        newOrderBuyPage.searchSymbol();
        newOrderBuyPage.clickOrderType();
        newOrderBuyPage.setOrderTypeAsLimit();
        newOrderBuyPage.setQtyValue();
        newOrderBuyPage.clearPrice();
        newOrderBuyPage.setPriceValue();
        newOrderBuyPage.clickTIF_TypeBtn();
        newOrderBuyPage.setTIFTypeAs_Day();
        newOrderBuyPage.setDisclosedQty();
        newOrderBuyPage.setMinimumFillValue();
        newOrderBuyPage.clickAllOrNoneBtn();
        newOrderBuyPage.clickBuyBtn();
        newOrderBuyPage.clickConfirmBtn();
        logoutPage.clickLogout();

    }

    @Test(priority = 2)
    public void testSuccessfulNewOrderLimitBuyWith_IOC_As_TIF_Type() throws InterruptedException {

        loginPage.loadPage(loginurl);
        loginPage.setUsername(userName);
        loginPage.setPassword(password);
        loginPage.clickAcceptTermsBtn();
        loginPage.clickRememberMeBtn();
        loginPage.clickLogin();
        newOrderBuyPage.clickTradeWidget();
        if (!newOrderBuyPage.checkOrderBuyOrSell().equals("Buy")){
            newOrderBuyPage.clickOrderToggle();
            logger.info("User is change the order to the Buy");
        }
        else{
            Assert.assertEquals(newOrderBuyPage.checkOrderBuyOrSell(),"Buy" , "");
            logger.info("User is ready to place the Buy order");
        }
        newOrderBuyPage.clearSymbolSearchField();
        newOrderBuyPage.setSearchSymbol();
        newOrderBuyPage.searchSymbol();
        newOrderBuyPage.clickOrderType();
        newOrderBuyPage.setOrderTypeAsLimit();
        newOrderBuyPage.setQtyValue();
        newOrderBuyPage.clearPrice();
        newOrderBuyPage.setPriceValue();
        newOrderBuyPage.clickTIF_TypeBtn();
        newOrderBuyPage.setTIFTypeAs_IOC();
        newOrderBuyPage.setDisclosedQty();
        newOrderBuyPage.setMinimumFillValue();
        newOrderBuyPage.clickAllOrNoneBtn();
        newOrderBuyPage.clickBuyBtn();
        newOrderBuyPage.clickConfirmBtn();
        logoutPage.clickLogout();

    }

}
