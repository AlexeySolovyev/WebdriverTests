package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.DragAndDropPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class DragAndDropTest_5 extends BaseClass {

    @Test
    public void DragAndDropTest() throws IOException, InterruptedException {
        driver.get(baseURL);
        DragAndDropPage dragAndDrop = new DragAndDropPage(driver);

        dragAndDrop.clickDragAndDropLink();
        dragAndDrop.makeDragAndDrop();

        // need assertion
    }
}
