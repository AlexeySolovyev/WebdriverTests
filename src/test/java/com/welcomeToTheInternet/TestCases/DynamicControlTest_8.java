package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.DynamicControlsPage;
import org.testng.annotations.Test;
import java.io.IOException;

public class DynamicControlTest_8 extends BaseClass{

    @Test
    public void DynamicControlTest() throws IOException {
        driver.get(baseURL);
        DynamicControlsPage dynamicControl = new DynamicControlsPage(driver);

        dynamicControl.clickDynamicControlLink();
        dynamicControl.enableDynamicControlCheckbox();
        dynamicControl.clickDynamicControlRemove();
        dynamicControl.waitForText1();
        dynamicControl.clickDynamicControlEnable();
        dynamicControl.waitForText2();
    }
}
