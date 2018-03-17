package com.google.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Singleton;

import java.util.concurrent.TimeUnit;

public class BaseTest {

   protected static WebDriver driver ;

    @BeforeTest
    public void setUp(){
        driver = Singleton.WEB_INSTANCE.getWebDriverInstance();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
