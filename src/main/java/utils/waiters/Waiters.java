package utils.waiters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {

    private static final int TIME_OUT = 10;

    public  static void  waitLoadPage(WebDriver webDriver, final WebElement expectedElement){
        (new WebDriverWait(webDriver, TIME_OUT)).until(ExpectedConditions.elementToBeClickable(expectedElement));
//        (new WebDriverWait(webDriver, timeWait)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver driver) {
//                return expectedElement.//expectedEement.isDisplayed();
//            }
//        });
    }
}
