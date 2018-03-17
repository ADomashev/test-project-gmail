package com.google.tests;

import org.testng.annotations.Test;
import pages.*;

import java.util.Arrays;
import java.util.List;

public class TestGoogleMailService extends BaseTest {

    @Test
    public void testSomething(){
        driver.get("https://accounts.google.com/ServiceLogin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false&flowName=GlifWebSignIn&flowEntry=AddSession");

        LoginInputPage loginInputPage = new LoginInputPage(driver);
        loginInputPage.enterLogin("AlexTest1312903");
        PasswordInputPage passwordInputPage = loginInputPage.submit();
        passwordInputPage.enterPassword("fk3hbf3fk3hbf3");
        MainPage mainPage = passwordInputPage.clickButtonNext();

        WriteMailPage writeMailPage = mainPage.clickWriteMail();
        writeMailPage.writingMailWhoSend("AlexTest1643800@gmail.com");
        writeMailPage.writingTheme("Theme");
        writeMailPage.writingContentMail("Trarararara");
        MainPage mainPage1 = writeMailPage.submit();
        AccountChangeOrExitPage accountChangeOrExitPage=mainPage1.clickOnAccountExitOrChangeButton();
        ChooseAccountPage chooseAccountPage = accountChangeOrExitPage.clickExitButton();
        ChangeAccountPage changeAccountPage= chooseAccountPage.clickReplaceAcccountButton();
        LoginInputPage loginInputPage1 = changeAccountPage.clickChangeAccount();
        loginInputPage1.enterLogin("AlexTest1643800");
        PasswordInputPage passwordInputPage1 = loginInputPage1.submit();
        passwordInputPage1.enterPassword("fk3hbf3fk3hbf3");
        MainPage mainPage2 = passwordInputPage.clickButtonNext();
        mainPage2.deleteMailSelectedUser("alextest1312903@gmail.com");
        AccountChangeOrExitPage accountChangeOrExitPage1 = mainPage2.clickOnAccountExitOrChangeButton();
        accountChangeOrExitPage1.clickExitButton();

        List<String> aa = Arrays.asList("dasd", "dasda");
        aa.forEach(x -> x.trim());
    }
}
