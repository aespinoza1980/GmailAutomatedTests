package com.gmail.pages;

import com.gmail.properties.PropertyClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alexis Espinoza on 11/13/15.
 */
public class BasePage {
    protected WebDriver driver;

    protected String linkAssertion1=null;
    protected String linkAssertion2=null;
    protected String linkAssertion3=null;
    protected String linkAssertion4=null;
    protected String account1=null;
    protected String account2=null;
    protected String passwordAccounts=null;
    protected String phoneNumber=null;
    protected  String host = null;
    protected void setUp(String browser)throws IOException {
        String[] propertyValues;
        PropertyClass properties = new PropertyClass();
        propertyValues = properties.getPropValues().split(",");
        String IEDriver= propertyValues[8];
        if(browser.equals("IE")) {
            System.setProperty("webdriver.ie.driver", IEDriver);

            // Launch InternetExplorerDriver
            driver = new InternetExplorerDriver();

        }else if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");//"/usr/bin/google-chrome"
            System.out.println(System.getProperty("webdriver.chrome.driver"));
            driver = new ChromeDriver();
        }else{
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        linkAssertion1 = propertyValues[0];
        linkAssertion2 = propertyValues[1];
        linkAssertion3 = propertyValues[2];
        phoneNumber = propertyValues[3];
        account1 = propertyValues[4];
        account2= propertyValues[5];
        passwordAccounts= propertyValues[6];
        linkAssertion4= propertyValues[7];
         host = "imap.gmail.com";
    }
    protected Properties returnProtocolConnection(int protocolType){
        Properties props = new Properties();
        switch(protocolType){

            case 1:props.setProperty("mail.store.protocol", "imaps");
                   props.put("mail.smtp.host", "smtp.gmail.com");
                   props.put("mail.smtp.port", "465");
                   props.put("mail.smtp.socketFactory.port", "465");
                   props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                   props.put("mail.smtp.auth", "true");
                   break;
            case 2:
                props.put("mail.store.protocol", "pop3");
                props.put("mail.pop3s.host", "imap.gmail.com");
                props.put("mail.pop3s.port", "995");
                props.put("mail.pop3.starttls.enable", "true");
                break;
        }

        return props;
    }

    @AfterTest
    public void close(){
        //Shutdown the browser
        driver.quit();
    }
}
