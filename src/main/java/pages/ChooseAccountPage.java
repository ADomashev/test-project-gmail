package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChooseAccountPage extends BasePage {

    @FindBy(xpath = "//div[@role='presentation']//div[@role='button']")
    private WebElement replaceAccountButton;

    public ChooseAccountPage(WebDriver driver) {
        super(driver);
    }

    public ChangeAccountPage clickReplaceAcccountButton(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.replaceAccountButton.click();
        return new ChangeAccountPage(driver);
    }
}
