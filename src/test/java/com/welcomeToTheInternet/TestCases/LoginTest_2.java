package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest_2 extends BaseClass{

    @Test
    public void InvalidLoginTest() throws IOException {
        driver.get(baseURL);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLoginLink();
        loginPage.setUserName(invalidUsername);
        loginPage.setUserPassword(invalidPassword);
        loginPage.clickSubmit();

        boolean isNotLogedOn = driver.getPageSource().contains("Your username is invalid!");
        if (isNotLogedOn) {
            Assert.assertTrue(true);
        } else {
            captureScreen(driver, "Failed login procedure");
            Assert.fail();
        }
    }
}
