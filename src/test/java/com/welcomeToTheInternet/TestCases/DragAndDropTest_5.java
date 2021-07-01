package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.DragAndDropPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest_5 extends BaseClass {

    @Test
    public void DragAndDropTest() {
        driver.get(baseURL);
        DragAndDropPage dragAndDrop = new DragAndDropPage(driver);

        dragAndDrop.clickDragAndDropLink();
        dragAndDrop.dragColumnBToColumnA();
        if (dragAndDrop.getTextA().equals("A")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(false);
        }

        dragAndDrop.dragColumnAToColumnB();
        dragAndDrop.dragColumnBToColumnA();
        if (dragAndDrop.getTextA().equals("A")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(false);
        }
    }
}
