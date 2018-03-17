package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ChangeAccountPage extends BasePage {

    @FindBy(xpath = "//form[@role='presentation']//div[@id='identifierLink']//p")
    private WebElement changeAccount;

    public ChangeAccountPage(WebDriver driver) {
        super(driver);
    }

    public LoginInputPage clickChangeAccount(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logOutClick(driver,changeAccount);
        return new LoginInputPage(driver);
    }

    private void logOutClick(WebDriver driver,WebElement element){
        Actions actions = new Actions(driver);
        actions.click(element);
        actions.perform();
    }
}
