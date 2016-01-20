package com.gmail.tests;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.gmail.pages.BasePage;
import com.gmail.pages.HomePage;
import com.gmail.properties.PropertyClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
/**
 * Created by Alexis Espinoza on 11/17/15.
 */
public class VerifyUnreadEmailsTest extends BasePage {
    private String account;
    private String password;
    @Parameters({ "email", "password", "browser" })
    @BeforeTest
    public void setUpLocal(@Optional("-1")String email,@Optional("")String password,@Optional("firefox") String browser)throws IOException {
        this.setUp(browser);

        if(email.equals("-1")) {
            account = account1;
            this.password =passwordAccounts;
        }
        else {
            account1 = email;
            this.password=password;
        }

    }
    @Test
    public void runVerifyUnreadEmailsTest()throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        HomePage homePage =new HomePage(driver,true);
        homePage.logIn(linkAssertion1,account,this.password);
        homePage.verifyUnreadEmails();
        homePage.logOut(linkAssertion4);
        close();
    }


}
