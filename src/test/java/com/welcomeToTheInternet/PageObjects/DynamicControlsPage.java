package com.welcomeToTheInternet.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicControlsPage {

    WebDriver localDriver;
    public DynamicControlsPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(css = "a[href='/dynamic_controls']")
    @CacheLookup
    WebElement linkDynamicControls;

    @FindBy(css = "input[label='blah']")
    @CacheLookup
    WebElement dynamicControlsCheckbox;

    @FindBy(css = "button[onclick='swapCheckbox()']")
    @CacheLookup
    WebElement dynamicControlsRemoveButton;

    @FindBy(css = "button[onclick='swapInput()']")
    @CacheLookup
    WebElement dynamicControlEnable;

    public void clickDynamicControlLink() {
        linkDynamicControls.click();
    }

    public void enableDynamicControlCheckbox() {
        dynamicControlsCheckbox.click();
    }

    public void clickDynamicControlRemove() {
        dynamicControlsRemoveButton.click();
    }

    public void clickDynamicControlEnable() {
        dynamicControlEnable.click();
    }

    public void waitForText1() {
        WebDriverWait wait = new WebDriverWait(localDriver, 10);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'gone')]")));
        boolean isVisible = element1.isDisplayed();
        if (isVisible) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    public void waitForText2() {
        WebDriverWait wait2 = new WebDriverWait(localDriver, 10);
        WebElement element2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'enabled!')]")));
        boolean isVisible2 = element2.isDisplayed();
        if (isVisible2) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

}
