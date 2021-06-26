package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.IFramePage;
import org.testng.annotations.Test;

public class IFramePageTest_13 extends BaseClass {

    @Test
    public void IFramePageTest() throws InterruptedException {
        driver.get(baseURL);
        IFramePage iFramePage = new IFramePage(driver);

        iFramePage.clickFramePageLink();
        iFramePage.clickIFramesPage();
        iFramePage.closeAlert();
        iFramePage.editText();
        iFramePage.checkText();
    }
}
