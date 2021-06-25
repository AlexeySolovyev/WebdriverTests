package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.DropdownPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class DropdownTest_6 extends BaseClass{

    @Test
    public void DropdownTest() throws IOException {
        driver.get(baseURL);
        DropdownPage dropdown = new DropdownPage(driver);

        dropdown.clickDropdownLink();

        dropdown.clickDropDownList();
        dropdown.waitForList(driver);
        dropdown.selectElement1();
        // assertion

        dropdown.clickDropDownList();
        dropdown.waitForList(driver);
        dropdown.selectElement2();
        //assertion
    }
}
