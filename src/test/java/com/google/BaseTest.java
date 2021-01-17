package com.google;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public WebDriver driver;

    @BeforeTest
    public void launchBrowser() throws MalformedURLException {

        String executeOn = "Local";
        if (executeOn.equals("Grid")) {
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setBrowserName("chrome");
            dc.setPlatform(Platform.LINUX);
            driver = new RemoteWebDriver(new URL("http://192.168.1.13:4444/wd/hub"), dc);
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }


    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }


}
