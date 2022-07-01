package com.accesshq.web;

import com.accesshq.model.SideItem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestWebUIElements {

    private WebDriver driver;
    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\source\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://d2tjwct0w5ff76.cloudfront.net/#/");
        driver.manage().window().maximize();
    }
   @Test
    public void validateContactMenuForeNameErrorMessage()  {
        driver.findElement(By.cssSelector("a[aria-label='contact'] span[class='v-btn__content']")).click();
        driver.findElement(By.cssSelector("a[aria-label='submit'] span[class='v-btn__content']")).click();
        String foreNameErrorMsg = driver.findElement(By.cssSelector("#forename-err")).getText();
        Assertions.assertEquals("Forename is required", foreNameErrorMsg);
    }
   @Test
    public void validateContactMenuEMailErrorMessage() {

        driver.findElement(By.cssSelector("a[aria-label='contact'] span[class='v-btn__content']")).click();
        driver.findElement(By.cssSelector("a[aria-label='submit'] span[class='v-btn__content']")).click();
        String eMailErrorMsg = driver.findElement(By.cssSelector("#email-err")).getText();
        Assertions.assertEquals("Email is required", eMailErrorMsg);
    }

   @Test
    public void validateContactMenuMessageErrorMessage() {

        driver.findElement(By.cssSelector("a[aria-label='contact'] span[class='v-btn__content']")).click();
        driver.findElement(By.cssSelector("a[aria-label='submit'] span[class='v-btn__content']")).click();
        String eMailErrorMsg = driver.findElement(By.cssSelector("#message-err")).getText();
        Assertions.assertEquals("Message is required", eMailErrorMsg);
    }
    @Test
    public void validateSidesMenu()  {

        driver.findElement(By.cssSelector("a[aria-label='menu'] span[class='v-btn__content']")).click();
        driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > i:nth-child(1)")).click();
      SideItem sideItem = new SideItem(driver);
        sideItem.selectSideItem("Chunky Chips and Aioli");
        Assertions.assertEquals("9.99", "9.99");

    }

   @Test
    public void validateEntries()  {

        driver.findElement(By.cssSelector("a[aria-label='contact'] span[class='v-btn__content']")).click();
        driver.findElement(By.cssSelector("#forename")).sendKeys("Dan");
        driver.findElement(By.cssSelector("#email")).sendKeys("dan@abc.com");
        driver.findElement(By.cssSelector("#message")).sendKeys("Nice Pizza");
        driver.findElement(By.cssSelector("a[aria-label='submit'] span[class='v-btn__content']")).click();
      Assertions.assertEquals("", "");
    }


   @AfterEach
    public void tearDown(){
        driver.close();
    }

}