package com.google;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchTest extends BaseTest {

    @Test
    public void launchGoogle() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.name("q")).sendKeys("Macbook Air");
        driver.findElement(By.name("btnK")).click();
        Thread.sleep(5000);
        System.out.println("Test Case Finished...");
    }

}
