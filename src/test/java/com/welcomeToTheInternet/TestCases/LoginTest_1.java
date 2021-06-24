package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class LoginTest_1 extends BaseClass{

    @Test
    public void LoginTest() throws IOException {
        driver.get(baseURL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginLink();
        loginPage.setUserName(username);
        loginPage.setUserPassword(password);
        loginPage.clickSubmit();

        boolean isLoggedOn = driver.getPageSource().contains("You logged into a secure area!");
        if (isLoggedOn) {
            Assert.assertTrue(true);
        } else {
            captureScreen(driver, "Success login procedure");
            Assert.fail();
        }
    }
}
