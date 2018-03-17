package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.MainPage;

public class WriteMailPage extends BasePage {

    @FindBy(xpath = "//form[@enctype='multipart/form-data']//textarea[@role='combobox']")
    private WebElement mailWhoSend;

    @FindBy(xpath = "//form[@enctype='multipart/form-data']//input[@name='subjectbox']")
    private WebElement theme;

    @FindBy(xpath = "//table[@id='undefined']//div[@role='textbox']")
    private WebElement contentMail;

    @FindBy(xpath ="//tbody/tr/td/div//div[@role='button']" )
    private WebElement sendMailButton;

    public WriteMailPage(WebDriver driver) {
        super(driver);
    }

    public void writingMailWhoSend(String mailWhoSend){
        this.mailWhoSend.sendKeys(mailWhoSend);
    }

    public void writingTheme (String theme){
        this.theme.sendKeys(theme);
    }

    public void writingContentMail(String contentMail){
        this.contentMail.sendKeys(contentMail);
    }

    public MainPage submit(){
        clickAction(driver);
        return new MainPage(driver);
    }

    private void clickAction(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ENTER).keyUp(Keys.CONTROL);
        actions.perform();
    }

    private void notVisibleClick(WebDriver driver,WebElement element){
        Actions actions = new Actions(driver);
        actions.click(element);
        actions.perform();
    }

}
