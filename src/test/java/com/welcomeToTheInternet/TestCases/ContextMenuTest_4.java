package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.ContextMenuPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContextMenuTest_4 extends BaseClass {

    @Test
    public void ContextMenuTest() throws IOException, InterruptedException {
        driver.get(baseURL);
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);

        driver.get(baseURL);
        contextMenuPage.clickContextMenuLink();
        contextMenuPage.clickOnBox();

        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        boolean isAlertMessage = message.contains("You selected a context menu");
        if (isAlertMessage) {
            Assert.assertTrue(true);
        } else {
            captureScreen(driver, "Failed get the alert message");
        }
        alert.accept();
    }
}
