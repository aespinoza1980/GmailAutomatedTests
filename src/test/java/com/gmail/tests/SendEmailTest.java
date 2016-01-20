package com.gmail.tests;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;
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

import static org.testng.Assert.assertEquals;
/**
 * Created by Alexis Espinoza on 11/13/15.
 */
public class SendEmailTest extends BasePage {
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
            account = email;
            this.password=password;
        }

    }
    @Test
    public void runSendEmailTest()throws InterruptedException{
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        HomePage homePage =new HomePage(driver,true);
        homePage.logIn(linkAssertion1,account,this.password);
        //homePage.landingPage();
        String subject="Delete this subject "+UUID.randomUUID().toString().substring(0, 7)+"Time "+df.format(dateobj);
        String message="This is an automated test "+UUID.randomUUID().toString();
        homePage.writeEmail(account2,subject,message);
        Properties properties=returnProtocolConnection(1);
        homePage.readEmail(properties,host,account,account2,subject,message,password);
        homePage.logOut(linkAssertion4);

        close();
    }


}
