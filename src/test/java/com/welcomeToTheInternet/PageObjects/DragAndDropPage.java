package com.welcomeToTheInternet.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DragAndDropPage {

    WebDriver localDriver;
    public DragAndDropPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(css = "a[href='/drag_and_drop']")
    @CacheLookup
    WebElement linkDragAndDrop;

    @FindBy(id = "column-a")
    @CacheLookup
    WebElement columnA;

    @FindBy(id = "column-b")
    @CacheLookup
    WebElement columnB;

    public void clickDragAndDropLink() {
        linkDragAndDrop.click();
    }

    public String getTextA() {
        return columnA.getText();
    }

    public String getTextB() {
        return columnB.getText();
    }

    public void dragAndDrop(WebElement src, WebElement dest) {
        String scriptFile = System.getProperty("/Users/alexeysolovyev/Documents/GitHub/WebdriverTests/src/test/utilities/JSDragDrop");
        String script = null;
        try {
            script = new String(Files.readAllBytes(Paths.get(scriptFile)));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        JavascriptExecutor jse = (JavascriptExecutor) localDriver;

        script += "\r\n"
                + "JSDragDrop(document.getElementById('"+ src.getAttribute("id")+"'), document.getElementById('"+dest.getAttribute("id")+"'));";
        jse.executeScript(script);
    }

    public void dragColumnAToColumnB() {
        dragAndDrop(columnA, columnB);
    }

    public void dragColumnBToColumnA() {
        dragAndDrop(columnB, columnA);
    }
}
