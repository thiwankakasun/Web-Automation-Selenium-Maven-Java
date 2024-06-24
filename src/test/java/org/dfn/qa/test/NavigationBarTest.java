package org.dfn.qa.test;

import dfn.base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.NavigationBarPage;

import java.util.logging.Logger;

public class NavigationBarTest extends BaseClass {

    Logger logger = Logger.getLogger(String.valueOf(NavigationBarTest.class));

    @Test(priority = 1)
    public void testLogin() throws InterruptedException {

        loginPage.loadPage(loginurl);
        loginPage.setUsername(userName);
        loginPage.setPassword(password);
        loginPage.clickAcceptTermsBtn();
        loginPage.clickRememberMeBtn();
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.checkLoadingImage(), "Home page is not loaded");
        navigationBarPage.navigateToMarketTab();
        navigationBarPage.navigateToTradeTab();
        navigationBarPage.navigateToQuoteTab();
        navigationBarPage.navigateToTopStocksTab();
        navigationBarPage.navigateToHeatMapTab();
        navigationBarPage.navigateToNewsTab();
        navigationBarPage.navigateToChartTab();
        logoutPage.clickLogout();

    }
}
