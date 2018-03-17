package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath ="//div[@style='user-select: none;']//div[@role='button']")
    private WebElement writeMailButton;

    @FindBy(xpath = "//div[@role='banner']//div[@style='min-width: 150px;']//a[@role='button']//span")
    private WebElement accountExitOrChangeButton;

    @FindBy(xpath = "//div[@role='main']//div[@role='tabpanel']//table//tbody/tr")
    private List<WebElement> elementList;

    @FindBy(xpath ="//div[@role='checkbox']" )
    private WebElement checkBox;

    @FindBy(xpath = "//div[@style='margin-right: 0px;']/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]")
    private WebElement deleteEmail;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public WriteMailPage clickWriteMail(){
        this.writeMailButton.click();
        return new WriteMailPage(driver);
    }

    public MainPage deleteMailSelectedUser (String mailUser){
        for (WebElement element : elementList) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement findTagWithAttribute = element.findElement(By.xpath("//td[4]/div[2]/span"));
            String emailName = findTagWithAttribute.getAttribute("email");
            if (emailName.equals(mailUser)) {
                checkBox.click();
               // deleteMail();
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logOutClick(driver,deleteEmail);
            }
        }

        return new MainPage(driver);
    }

    public AccountChangeOrExitPage clickOnAccountExitOrChangeButton(){
        logOutClick(driver, this.accountExitOrChangeButton);
        return new AccountChangeOrExitPage(driver);

    }

    private void logOutClick(WebDriver driver,WebElement element){
        Actions actions = new Actions(driver);
        actions.click(element);
        actions.perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
