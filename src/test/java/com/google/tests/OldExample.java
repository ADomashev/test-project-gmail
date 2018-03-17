package com.google.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class OldExample {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        this.driver = new ChromeDriver();
    }

    @Test
    public void testMail() {

        driver.get("https://accounts.google.com/ServiceLogin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false&flowName=GlifWebSignIn&flowEntry=AddSession");
        WebElement loginInput = driver.findElement(By.xpath("//input[@id='identifierId']"));
        loginInput.sendKeys("AlexTest1312903");

        WebElement nextButton = driver.findElement(By.xpath("//div[@id='identifierNext']"));
        nextButton.click();
        sleep(2000);

        WebElement passInput = driver.findElement(By.xpath("//div[@id='password']//input"));
        passInput.sendKeys("fk3hbf3fk3hbf3");

        WebElement pswdNextButton = driver.findElement(By.xpath("//div[@id='passwordNext']"));
        pswdNextButton.click();
        sleep(6000);

        WebElement writeMailButton = driver.findElement(By.xpath("//div[@style='user-select: none;']//div[@role='button']"));
        writeMailButton.click();
        sleep(3000);

        WebElement whoWriteMail = driver.findElement(By.xpath("//form[@enctype='multipart/form-data']//textarea[@role='combobox']"));
        whoWriteMail.click();
        whoWriteMail.sendKeys("AlexTest1643800@gmail.com");

        Actions skip = new Actions(driver);
        skip.sendKeys(Keys.ENTER).perform();
        sleep(2000);

        WebElement headerField = driver.findElement(By.xpath("//form[@enctype='multipart/form-data']//input[@name='subjectbox']"));
        headerField.click();
        headerField.sendKeys("Topic");
        sleep(2000);


        WebElement bodyMailField = driver.findElement(By.xpath("//table[@id='undefined']//div[@role='textbox']"));
        bodyMailField.click();
        bodyMailField.sendKeys("Mail");
        sleep(2000);

        clickAction(driver);
        sleep(5000);

        WebElement logOutList = driver.findElement(By.xpath("//div[@role='banner']//div[@style='min-width: 150px;']//a[@role='button']//span"));
        logOutClick(driver,logOutList);
        sleep(5000);

        WebElement logOutButton = driver.findElement(By.xpath("//div[@role='banner']//div[@style='min-width: 150px;']//div[@style='min-width: 135px;']//a[@target='_top']"));
        driver.get("https://accounts.google.com/Logout?hl=ru&continue=https://mail.google.com/mail&service=mail&timeStmp=1520667650&secTok=.AG5fkS_vBwV1XqZTW31UGDHRs_8Q1lMlkA");
        logOutClickTwo(driver,logOutButton);
        sleep(5000);

        WebElement chooseAccount= driver.findElement(By.xpath("//div[@role='presentation']//div[@role='button']"));
        chooseAccount.click();
        sleep(2000);

        WebElement changeAccount = driver.findElement(By.xpath("//form[@role='presentation']//div[@id='identifierLink']//p"));
        logOutClick(driver,changeAccount);
        sleep(2000);



        sleep(2000);
        WebElement loginInputUser2 = driver.findElement(By.xpath("//input[@id='identifierId']"));
        loginInputUser2.sendKeys("AlexTest1643800");
        sleep(3000);

        WebElement nextButtonUser2 = driver.findElement(By.xpath("//div[@id='identifierNext']"));
        nextButtonUser2.click();
        sleep(2000);

        WebElement passInputUser2 = driver.findElement(By.xpath("//div[@id='password']//input"));
        passInputUser2.sendKeys("fk3hbf3fk3hbf3");

        WebElement pswdNextButtonUser2 = driver.findElement(By.xpath("//div[@id='passwordNext']"));
        pswdNextButtonUser2.click();
        sleep(6000);

        List<WebElement> elementList =driver.findElements(By.xpath("//div[@role='main']//div[@role='tabpanel']//table//tbody/tr"));
        sleep(5000);

        // for (int i = 0; i <elementList.size() ; i++) {
        WebElement element = elementList.get(0);

        WebElement childWebElement = element.findElement(By.xpath("//td[4]/div[2]/span"));
        String strMail = childWebElement.getAttribute("email");
        System.out.println(childWebElement.getAttribute("email"));
        if ("alextest1312903@gmail.com".equals(strMail)) {
            deleteMail(childWebElement);
        } else {
            nothing();
        }
        //}

        WebElement deleteEmail = driver.findElement(By.xpath("//div[@style='margin-right: 0px;']/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]"));
        logOutClick(driver,deleteEmail);
        sleep(5000);

        WebElement logOutListTwo = driver.findElement(By.xpath("//div[@role='banner']//div[@style='min-width: 150px;']//a[@role='button']//span"));
        logOutClick(driver,logOutListTwo);
        sleep(5000);

        WebElement logOutButtonTwo = driver.findElement(By.xpath("//div[@role='banner']//div[@style='min-width: 150px;']//div[@style='min-width: 135px;']//a[@target='_top']"));
        driver.get("https://accounts.google.com/Logout?hl=ru&continue=https://mail.google.com/mail&service=mail&timeStmp=1520667650&secTok=.AG5fkS_vBwV1XqZTW31UGDHRs_8Q1lMlkA");
        logOutClickTwo(driver,logOutButtonTwo);
        sleep(5000);

    }

    private void nothing() {

    }

    private void deleteMail(WebElement element) {
        WebElement checkBox = element.findElement(By.xpath("//div[@role='checkbox']"));
        checkBox.click();  //td[2]/div[1]/
        sleep(5000);
    }

    @AfterTest
    public void teardown(){
        driver.close();
    }

    private void clickAction(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ENTER).keyUp(Keys.CONTROL);
        actions.perform();
    }

    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void logOutClick(WebDriver driver,WebElement element){
        Actions actions = new Actions(driver);
        actions.click(element);
        actions.perform();
    }

    private void logOutClickTwo(WebDriver driver,WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click(element).build();
        actions.perform();
    }
}
