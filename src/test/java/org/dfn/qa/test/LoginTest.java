package org.dfn.qa.test;

import dfn.base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class LoginTest extends BaseClass {

    Logger logger = Logger.getLogger(String.valueOf(LoginTest.class));

    @Test(priority = 1)
    public void testSuccessfulLogin() throws InterruptedException {
        loginPage.loadPage(loginurl);
        loginPage.setUsername(userName);
        loginPage.setPassword(password);
        loginPage.clickAcceptTermsBtn();
        loginPage.clickRememberMeBtn();
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.checkLoadingImage(), "Home page is not loaded");
        logoutPage.clickLogout();
        logger.info("testSuccessfulLogin is Passed");
    }

    @Test(priority = 2)
    public void testUnsuccessfulLoginWithIncorrectUserName() throws InterruptedException {
        loginPage.loadPage(loginurl);
        loginPage.setUsername("123");
        loginPage.setPassword(password);
        loginPage.clickAcceptTermsBtn();
        loginPage.clickRememberMeBtn();
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.checkIncorrectUserNameOrPasswordErrorMsg(), "User name or password incorrect", "User name or password incorrect message is not displayed");
        logger.info("testUnsuccessfulLoginWithIncorrectUserName is Passed");
    }

    @Test(priority = 3)
    public void testUnsuccessfulLoginWithIncorrectPassword() throws InterruptedException {
        loginPage.loadPage(loginurl);
        loginPage.setUsername(userName);
        loginPage.setPassword("abc");
        loginPage.clickAcceptTermsBtn();
        loginPage.clickRememberMeBtn();
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.checkIncorrectUserNameOrPasswordErrorMsg(), "User name or password incorrect", "User name or password incorrect message is not displayed");
        logger.info("testUnsuccessfulLoginWithIncorrectPassword is Passed");
    }
}

