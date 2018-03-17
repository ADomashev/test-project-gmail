package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.waiters.Waiters;

public class LoginInputPage extends BasePage {

    @FindBy(xpath = "//input[@id='identifierId']")
    private WebElement loginName;

    @FindBy(xpath = "//div[@id='identifierNext']")
    private WebElement buttonNext;

    public LoginInputPage(WebDriver driver) {
        super(driver);
    }

    public void enterLogin(String loginName){
        Waiters.waitLoadPage(driver,this.loginName);
        this.loginName.sendKeys(loginName);
    }

    public PasswordInputPage submit(){
        this.buttonNext.click();

        return new PasswordInputPage(driver);
    }


}
