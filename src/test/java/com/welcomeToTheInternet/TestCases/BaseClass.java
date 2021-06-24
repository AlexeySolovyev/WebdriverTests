package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.utilties.ReadConfig;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getURL();
    public String username = readConfig.getUsername();
    public String password = readConfig.getUserPassword();
    public static WebDriver driver;
    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String browser) {

        logger = Logger.getLogger("Welcome to the-internet");
        PropertyConfigurator.configure("log4j.properties");

        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
            driver = new ChromeDriver();
        }
        else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
