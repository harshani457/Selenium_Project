package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class SelectMobileTest extends Main {

    @Test(priority = 1)
    @Parameters({"url"})
    //navigate to URL
    public void navigateToUrl(String url) {
        webdriver.get(url);
    }

    @Test(priority = 2)
    @Parameters({"url"})
    //very  URL
    public void verifyUrl(String url) {
        Assert.assertEquals(webdriver.getCurrentUrl(), url);
        System.out.println("URL is Verified");
    }


    //Select Category using dropdown menu
    @Test(priority = 3)
    public void selectCategory() {
        WebElement categoryDropdown = webdriver.findElement(By.id("gh-cat"));
        Select select = new Select(categoryDropdown);
        select.selectByVisibleText("Cell Phones & Accessories");
    }

    //Click the search button
    @Test(priority = 4)
    public void searchMobile() {
        WebElement searchBox = webdriver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("Mobile phone");
        webdriver.findElement(By.id("gh-btn")).click();
    }

    //Select apple mobile using apple check box
    @Test(priority = 5)
    public void selectApple() {
        WebElement appleCheckBox = webdriver.findElement(By.xpath("//*[@id=\"x-refine__group_1__0\"]/ul/li[1]/div/a/div/span/input"));
        appleCheckBox.click();
    }


    //Select first Item from the apple phones list
    @Test(priority = 6)
    public void selectFirstItem() {
        WebElement firstItem = webdriver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[1]/div/a/div"));
        firstItem.click();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (String winHandle : webdriver.getWindowHandles()) {
            webdriver.switchTo().window(winHandle);
        }
    }
}

