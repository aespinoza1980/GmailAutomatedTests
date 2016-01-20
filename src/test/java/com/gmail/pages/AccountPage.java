package com.gmail.pages;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.gmail.properties.PropertyClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.util.UUID;
/**

/**
 * Created by Alexis Espinoza on 11/13/15.
 */
public class AccountPage {
    private WebDriver driver;
    public AccountPage(WebDriver driver){
        this.driver=driver;
    }
    private String generateRandomLetters(int size, int option){
        char[] chars;
        if(option==1)
            chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        else
             chars = "123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public void createAccount(String []propertyValues) throws InterruptedException{
        String firstNameID="FirstName";
        String lastNameID="LastName";
        String gmailAddressID="GmailAddress";
        String passwdID="Passwd";
        String passwdAgainID="PasswdAgain";
        String birthDayID="BirthDay";
        String birthYearID="BirthYear";
        String sexID=":d";
        String recoveryEmailAddressID="RecoveryEmailAddress";
        String skipCaptchaID="SkipCaptcha";
        String termsOfServiceID="TermsOfService";
        String submitbuttonID="submitbutton";
        String signupidvinputID="signupidvinput";
        String nextButtonID="next-button";
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("wrapper")));
        assertEquals(propertyValues[1],this.driver.getCurrentUrl());
        /********************/
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(firstNameID)));
        WebElement webElement=driver.findElement(By.id(firstNameID));
        webElement.click();
        webElement.clear();
        webElement.sendKeys("Tom "+UUID.randomUUID().toString().substring(0, 7));
        Thread.sleep(1000);
        webElement=driver.findElement(By.id(lastNameID));
        webElement.click();
        webElement.clear();
        webElement.sendKeys("Automated "+UUID.randomUUID().toString().substring(0, 7));
        Thread.sleep(1000);
        webElement=driver.findElement(By.id(gmailAddressID));
        webElement.click();
        webElement.clear();
        webElement.sendKeys(this.generateRandomLetters(20,1));
        Thread.sleep(1000);
        webElement=driver.findElement(By.id(passwdID));
        webElement.click();
        webElement.clear();
        webElement.sendKeys(propertyValues[6]);
        Thread.sleep(1000);
        webElement=driver.findElement(By.id(passwdAgainID));
        webElement.click();
        webElement.clear();
        webElement.sendKeys(propertyValues[6]);

        Thread.sleep(1000);
        webElement=driver.findElement(By.cssSelector("#month-label"));
        WebElement webElement1=webElement.findElement(By.cssSelector("#BirthMonth"));
        WebElement webElement2=webElement1.findElement(By.cssSelector("#BirthMonth > div.goog-inline-block.goog-flat-menu-button.jfk-select"));
        WebElement webElement3=webElement2.findElement(By.id(":0"));
        webElement3.click();
        webElement1=webElement.findElement(By.cssSelector("#BirthMonth > div.goog-inline-block.goog-flat-menu-button.jfk-select"));
        webElement1.click();
        Thread.sleep(1000);
        webElement=driver.findElement(By.id(birthDayID));
        webElement.click();
        webElement.clear();
        webElement.sendKeys("12");
        Thread.sleep(1000);
        webElement=driver.findElement(By.id(birthYearID));
        webElement.click();
        webElement.clear();
        webElement.sendKeys("1980");
        Thread.sleep(1000);
        webElement=driver.findElement(By.cssSelector("#Gender"));
        webElement1=webElement.findElement(By.cssSelector("#Gender > div.goog-inline-block.goog-flat-menu-button.jfk-select"));
        webElement2=webElement1.findElement(By.id(sexID));

        webElement2.click();
        webElement1=webElement.findElement(By.cssSelector("#Gender > div.goog-inline-block.goog-flat-menu-button.jfk-select"));
        webElement1.click();
        Thread.sleep(1000);
        webElement=driver.findElement(By.id(recoveryEmailAddressID));
        webElement.click();
        webElement.clear();
        webElement.sendKeys(propertyValues[4]);
        Thread.sleep(1000);
        webElement=driver.findElement(By.id(skipCaptchaID));
        webElement.click();
        Thread.sleep(1000);
        webElement=driver.findElement(By.id(termsOfServiceID));
        webElement.click();
        Thread.sleep(1000);
        webElement=driver.findElement(By.id(submitbuttonID));
        webElement.click();
        Thread.sleep(1000);
        /******************************************************/
        /*********PHONE NUMBER *******************************/
        /******************************************************/

        wait.until(ExpectedConditions.elementToBeClickable(By.id(signupidvinputID)));
        assertEquals(propertyValues[2], this.driver.getCurrentUrl());
        webElement=driver.findElement(By.id(signupidvinputID));
        webElement.click();
        webElement.clear();
        webElement.sendKeys(propertyValues[3]);
        Thread.sleep(1000);

        webElement=driver.findElement(By.id(nextButtonID));
        webElement.click();
        Thread.sleep(1000);

        /*SINCE THE PAGE IS THE SAME, WUE MAKE SURE WE REACH THE POINT OF MAKING THE INPUT POSSIBLE */
        wait.until(ExpectedConditions.elementToBeClickable(By.id("verify-phone-input")));
        assertEquals(propertyValues[2], this.driver.getCurrentUrl());
        Thread.sleep(1000);
        /******************************************************/
        /*********PHONE NUMBER *******************************/
        /******************************************************/


        /*******************/

    }
}
