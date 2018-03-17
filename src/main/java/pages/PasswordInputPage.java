package pages;

import utils.waiters.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordInputPage extends BasePage {

    @FindBy(xpath = "//div[@id='password']//input")
    private WebElement passName;

    @FindBy(xpath = "//div[@id='passwordNext']")
    private WebElement buttonNext;

    public PasswordInputPage(WebDriver driver) {
        super(driver);
    }
    public void enterPassword(String passName){
        Waiters.waitLoadPage(driver,this.passName);
        this.passName.sendKeys(passName);
    }

    public MainPage clickButtonNext(){
        this.buttonNext.click();
        return new MainPage(driver);
    }
}
