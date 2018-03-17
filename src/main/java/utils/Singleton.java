package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public enum Singleton {
    WEB_INSTANCE;

    private WebDriver driver;

    public WebDriver getWebDriverInstance(){
        if (driver == null){
            driver = new ChromeDriver();
        }
        return driver;
    }

}
