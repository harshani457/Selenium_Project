package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Main {

    protected static WebDriver webdriver;
    protected static WebDriverWait wait;

    @BeforeTest
    @Parameters({"browser"})
    public void setup(String browser) {
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            webdriver = new ChromeDriver(options);
            System.out.println("Correct Browser opened");
        }else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
            webdriver = new FirefoxDriver();
            System.out.println("Correct Browser opened");
        }else {
            throw new IllegalArgumentException("The Browser Type is Undefined");

        }

        wait = new WebDriverWait(webdriver, Duration.ofSeconds(10));
        webdriver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        webdriver.quit();
    }

}