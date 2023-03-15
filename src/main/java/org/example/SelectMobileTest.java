package org.example;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SelectMobileTest extends Main{

    @Test
    @Parameters({"url"})
    public void test3(String url){
        webdriver.get(url);
    }
}
