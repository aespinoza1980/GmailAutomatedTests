package com.gmail.tests;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.gmail.properties.PropertyClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import com.gmail.pages.HomePage;
import com.gmail.pages.AccountPage;

/**
 * Created by Alexis Espinoza on 11/13/15.
 */
public class CreateAccountTest {
    //The 'browser' itself
    private WebDriver driver;
    private String[] propertyValues;
    @BeforeTest
    public void setupSelenium()throws IOException {
        //Start the browser (firefox for now)
        driver = new FirefoxDriver();
        //This adds implicit timeouts to the driver (instead of clickAndWait())
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PropertyClass properties = new PropertyClass();
        propertyValues = properties.getPropValues().split(",");

    }

    @Test
    public void createAccount()throws InterruptedException{
        HomePage homePage =new HomePage(driver,true);
        homePage.signUp(propertyValues);
        Thread.sleep(2000);
        AccountPage accountPage=new AccountPage(driver);
        accountPage.createAccount(propertyValues);
        Thread.sleep(2000);
    }


    @AfterTest
    public void closeSelenium(){
        //Shutdown the browser
        driver.quit();
    }
}
