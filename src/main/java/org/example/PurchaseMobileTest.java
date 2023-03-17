package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class PurchaseMobileTest extends Main {

    private String itemTitle;
    private String itemPrice;
    private String itemQuantity;
    private String condition;


    @Test(priority = 6)
    public void dropDownSelections() {
        try {
            List<WebElement> dropdowns = webdriver.findElements(By.tagName("select"));

            for (int k = 0; k < ((List<?>) dropdowns).size(); k++) {
                WebElement dropdown = dropdowns.get(k);

                if (!dropdown.getAttribute("id").equals("gh-cat")) {
                    if (dropdown.isDisplayed()) {
                        dropdown.click();
                    }
                    Select select = new Select(dropdown);
                    List<WebElement> options = select.getOptions();

                    for (WebElement option : options) {
                        if ((option.getAttribute("disabled") == null) && !(option.getAttribute("value").equals("-1"))) {
                            select.selectByValue(option.getCssValue("value"));
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {

        }
    }







    //Select Model of the phone
    @Test(priority = 7)
    public void selectModel() {
        try {
            WebElement selectBox = webdriver.findElement(By.cssSelector("#x-msku__select-box-1000"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Model dropdown not found");
        }
    }


    //Select Carrier of the phone
    @Test(priority = 8)
    public void selectCarrier() {
        try {
            WebElement selectBox = webdriver.findElement(By.cssSelector("#x-msku__select-box-1001"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Carrier dropdown not found");
        }
    }


    //Select StorageCapacity of the phone
    @Test(priority = 9)
    public void selectStorageCapacity() {
        try {
            WebElement selectBox = webdriver.findElement(By.cssSelector("#x-msku__select-box-1002"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Storage Capacity dropdown not found");
        }
    }



    //Select Color of the phone
    @Test(priority = 10)
    public void selectColor() {
        try {
            WebElement selectBox = webdriver.findElement(By.cssSelector("#x-msku__select-box-1003"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Color dropdown not found");
        }
    }

    //Select Cosmetic of the phone
    @Test(priority = 11)
    public void selectCosmetic() {
        try {
            WebElement selectBox = webdriver.findElement(By.cssSelector("#x-msku__select-box-1004"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Cosmetic dropdown not found");
        }
    }

    //Print Item Name
    @Test(priority = 12)
    public void getItemName() {
        itemTitle = webdriver.findElement(By.cssSelector("#LeftSummaryPanel > div.vi-swc-lsp > div:nth-child(1) > div > h1 > span")).getText().trim();
        System.out.println("Item Name : " + itemTitle);
    }

    //Print Item Price
    @Test(priority = 13)
    public void getItemPrice() {
        itemPrice = webdriver.findElement(By.cssSelector("#mainContent > form > div.vim-buybox-wrapper > div > div.x-buybox__section > div.x-buybox__price-section > div > div.x-bin-price__content > div > span:nth-child(1) > span")).getText().trim();
        System.out.println("Item Price : " + itemPrice);
    }

    //Print Item Condition
    @Test(priority = 14)
    public void getItemCondition() {
        condition = webdriver.findElement(By.cssSelector("#mainContent > form > div.nonActPanel > div:nth-child(1) > div > div.x-item-condition-value > div.x-item-condition-text > div > span > span:nth-child(1) > span")).getText().trim();
        System.out.println("Item Condition : " + condition);
    }


    //Print Item Quantity
    @Test(priority = 15)
    public void getItemQuantity() {
        itemQuantity = webdriver.findElement(By.id("qtyTextBox")).getAttribute("value");
        System.out.println("Item Quantity : " + itemQuantity);
    }


    //Item add to cart
    @Test(priority = 16)
    public void addToCart() {
        WebElement addItemToCartBtn = webdriver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div[2]/div/div[1]/div[2]/ul/li[2]/div/a"));
        addItemToCartBtn.click();
    }


    //Check item name is correct or not
   @Test(priority = 17)
    public void assertItemTitle() {
        WebElement name = webdriver.findElement(By.cssSelector(".item-title > span:nth-child(1) > a:nth-child(1) > span:nth-child(1) > span:nth-child(1) > label:nth-child(1)"));
        Assert.assertEquals(itemTitle, name.getText());
        System.out.println("Name is correct.");
    }

    //Check item price is correct or not
    @Test(priority = 18)
    public void assertPrice() {
        WebElement price = webdriver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[3]/div[1]/div/ul/li/div[1]/div/div/div[1]/div/div[3]/div/div[1]/div[2]/div/div/span/span/span"));
        Assert.assertEquals(itemPrice, price.getText());
        System.out.println("Price is correct.");
    }

    //Check item quantity is correct or not
    @Test(priority = 19)
    public void assertQuantity() {
        WebElement dropdown = webdriver.findElement(By.xpath("//label[text()='Qty']/following-sibling::span/select"));
        String selectedOption = dropdown.getAttribute("value");
        Assert.assertEquals(itemQuantity, selectedOption);
        System.out.println("Quantity is correct. Quantity is " + selectedOption);
    }

    //Check cart sub total is matching to item price
    @Test(priority = 20)
    public void assertSubTotal() {

        WebElement subTotal = webdriver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[4]/div/div[2]/div[4]/div[2]/span/span/span"));
        Assert.assertEquals(itemPrice, subTotal.getText());
        System.out.println("Sub Total is Equal to price.");
    }

    //Print shipping fee
    @Test(priority = 21)
    public void getShipping() {
        WebElement shipping = webdriver.findElement(By.cssSelector("#mainContent > div > div.right-section > div > div.table > div:nth-child(2) > div.val-col > span > span > span"));
        String shippingValue = shipping.getText().trim();
        System.out.println("Shipping value is : " + shippingValue);
    }



}

