package com.accesshq.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideItem {
    WebDriver driver;
    public SideItem(WebDriver driver){
        this.driver = driver;
    }
    public String getName(){
        return driver.findElement(By.className("name")).getText();
    }

    public String getKJ(){
        return driver.findElement(By.className("kj")).getText();
    }

    public void selectSideItem(String itemName) {
        for (WebElement sideItem : driver.findElements(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)"))) {
           if ((sideItem.getText().contains("Chunky Chips and Aioli")) &&
                   (sideItem.getText().contains("3273")) &&
                   (sideItem.getText().contains("9.99")))
            break;

        }

    }

}
