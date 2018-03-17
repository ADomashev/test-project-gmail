package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountChangeOrExitPage extends BasePage {

    @FindBy(xpath = "//div[@role='banner']//div[@style='min-width: 150px;']//div[@style='min-width: 135px;']//a[@target='_top']")
    private WebElement exitAccount;

    public AccountChangeOrExitPage(WebDriver driver) {
        super(driver);
    }

    public ChooseAccountPage clickExitButton() {
//        driver.get("https://accounts.google.com/Logout?hl=ru&continue=https://mail.google.com/mail&service=mail&timeStmp=1520667650&secTok=.AG5fkS_vBwV1XqZTW31UGDHRs_8Q1lMlkA");
        driver.get("https://accounts.google.com/ServiceLogin/signinchooser?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        clickAction(driver);
        return new ChooseAccountPage(driver);
    }

    private void clickAction(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ENTER).keyUp(Keys.CONTROL);
        actions.perform();
    }

}
