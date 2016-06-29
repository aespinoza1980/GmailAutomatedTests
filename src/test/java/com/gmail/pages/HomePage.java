package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.mail.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 * Created by Alexis Espinoza on 11/13/15.
 */
public class HomePage {
    private WebDriver driver;
    public HomePage(){

    }
    public HomePage(WebDriver driver, boolean navigate){
        this.driver=driver;
        if(navigate)
            this.driver.navigate().to("http://mail.google.com");
    }
    public void signUp(String []propertyValues){
        String linkSignupID="link-signup";
        WebDriverWait wait = new WebDriverWait(driver, 10);
        assertEquals(driver.getCurrentUrl(), propertyValues[0]);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(linkSignupID)));
        driver.findElement(By.id(linkSignupID)).click();
    }
    public void logIn(String trueLink,String email, String password)throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String emailID="Email";
        String nextID="next";
        String passwdID="Passwd";
        String signInID="signIn";
        wait.until(ExpectedConditions.elementToBeClickable(By.id(emailID)));
        assertEquals(trueLink,driver.getCurrentUrl());
        WebElement webElement=driver.findElement(By.id(emailID));
        webElement.click();
        webElement.clear();
        webElement.sendKeys(email);
        Thread.sleep(1000);

        webElement=driver.findElement(By.id(nextID));
        webElement.click();
        Thread.sleep(1000);

        webElement=driver.findElement(By.id(passwdID));
        webElement.click();
        webElement.clear();
        webElement.sendKeys(password);
        Thread.sleep(1000);

        webElement=driver.findElement(By.id(signInID));
        webElement.click();
        Thread.sleep(1000);

        /****************************/
        /****home*****************?
         *
         */

    }
    public void landingPage()throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String cssPath1="#gb > div.gb_qd.gb_le > div.gb_La.gb_le.gb_R.gb_ke.gb_T > div.gb_Pb.gb_le.gb_R > div.gb_Ta.gb_Rb.gb_le.gb_R";
        String cssPath2="#gb > div.gb_qd.gb_le > div.gb_La.gb_le.gb_R.gb_ke.gb_T > div.gb_Pb.gb_le.gb_R > div.gb_Ta.gb_Rb.gb_le.gb_R > div.gb_2b.gb_Va.gb_le.gb_R";
        String cssPath3="#gb > div.gb_qd.gb_le > div.gb_La.gb_le.gb_R.gb_ke.gb_T > div.gb_Pb.gb_le.gb_R > div.gb_Ta.gb_Rb.gb_le.gb_R > div.gb_2b.gb_Va.gb_le.gb_R > a";
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssPath1)));
        assertEquals("https://mail.google.com/mail/#inbox",driver.getCurrentUrl());
        WebElement webElement1=driver.findElement(By.cssSelector(cssPath1));
        WebElement webElement2=webElement1.findElement(By.cssSelector(cssPath2));
        WebElement webElement3=webElement2.findElement(By.cssSelector(cssPath3));
        webElement3.click();
        Thread.sleep(1000);
        webElement3.click();
        Thread.sleep(1000);
    }
    public void logOut(String linkAssertion4)throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //*[@id="gb"]/div[1]/div[1]/div[2]/div[4]/div[1]/a/span
        driver.findElement(By.xpath("//*[@id='gb']/div[1]/div[1]/div/div[4]/div[1]/a")).click();
        driver.findElement(By.id("gb_71")).click();
        /*String cssPath1="#gb > div.gb_Jd.gb_Ce > div.gb_7a.gb_Ce.gb_R.gb_Be.gb_T";
        String cssPath2="#gb > div.gb_Jd.gb_Ce > div.gb_7a.gb_Ce.gb_R.gb_Be.gb_T > div.gb_4b.gb_Ce.gb_R";
        String cssPath3="#gb > div.gb_Jd.gb_Ce > div.gb_7a.gb_Ce.gb_R.gb_Be.gb_T > div.gb_4b.gb_Ce.gb_R > div.gb_4a.gb_Mc.gb_Ce.gb_R";

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssPath1)));
        assertEquals(linkAssertion4,driver.getCurrentUrl());
        WebElement webElement1=driver.findElement(By.cssSelector(cssPath1));
        WebElement webElement2=webElement1.findElement(By.cssSelector(cssPath2));
        WebElement webElement3=webElement2.findElement(By.cssSelector(cssPath3));
        webElement3.click();
        Thread.sleep(1000);

        cssPath1="#gb > div.gb_Jd.gb_Ce > div.gb_7a.gb_Ce.gb_R.gb_Be.gb_T > div.gb_4b.gb_Ce.gb_R > div.gb_4a.gb_Mc.gb_Ce.gb_R.gb_g > div.gb_ab.gb_ea.gb_g";
        cssPath2="#gb > div.gb_Jd.gb_Ce > div.gb_7a.gb_Ce.gb_R.gb_Be.gb_T > div.gb_4b.gb_Ce.gb_R > div.gb_4a.gb_Mc.gb_Ce.gb_R.gb_g > div.gb_ab.gb_ea.gb_g > div.gb_mb";
        cssPath3="#gb > div.gb_Jd.gb_Ce > div.gb_7a.gb_Ce.gb_R.gb_Be.gb_T > div.gb_4b.gb_Ce.gb_R > div.gb_4a.gb_Mc.gb_Ce.gb_R.gb_g > div.gb_ab.gb_ea.gb_g > div.gb_mb > div:nth-child(2)";
        String cssPath4="#gb_71";
        webElement1=driver.findElement(By.cssSelector(cssPath1));
        webElement2 = webElement1.findElement(By.cssSelector(cssPath2));
        webElement3=webElement2.findElement(By.cssSelector(cssPath3));
        WebElement webElement4=webElement3.findElement(By.cssSelector(cssPath4));
        webElement4.click();
        */Thread.sleep(3000);
        String cssPath1="body > div.wrapper > div.main.content.clearfix";
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssPath1)));
        assertEquals("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1",driver.getCurrentUrl());
        Thread.sleep(2000);
    }
    public  void writeEmail(String emailTo, String subject, String message) throws InterruptedException{
        driver.findElement(By.xpath("//div[@class='z0']/div")).click();

/* Enter email details */

        Thread.sleep(1000);
        driver.findElement(By.xpath("//td//img[2]")).click();
        driver.findElement(By.className("vO")).sendKeys(emailTo);
        //driver.findElement(By.xpath("//div[@class='aoD az6']//input[@class='aoT']")).sendKeys(subject);
        //driver.findElement(By.className("aoT")).sendKeys(subject);//*[@id=':a8']
        driver.findElement(By.className("aoT")).sendKeys(subject);
        driver.findElement(By.xpath("//div[@class='Ar Au']/div[@class='Am Al editable LW-avf']")).click();
        WebElement printBody = driver.switchTo().activeElement();
        printBody.sendKeys(message);

        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//div[text()='Send']")).click();

/* Go to Sent Items and verify */
       // driver.findElement(By.xpath("//a[@title='Sent Mail']")).click();// recent UI changes make this reuqest invalid


        /*if (driver.findElement(By.xpath("//div[@class='y6']//b[text()='"+subject+"']")) != null)
        {
            System.out.println("Wowww.. Email sent sucessfully!!!");
        }
        else
        {
            System.out.println("Failed to send email !!!");
        }*/

        //driver.quit();


        /****************************************************/

        /*WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":4r")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("z0"))).click();
        Thread.sleep(1000);
/* Enter email details */
        /*Thread.sleep(1000);
        driver.findElement(By.xpath("//td//img[2]")).click();
        driver.findElement(By.className("vO")).sendKeys(emailTo);
        driver.findElement(By.className("aoT")).sendKeys(subject);//*[@id=':a8']
        driver.findElement(By.xpath("//*[@id=\":a8\"]")).click();
        WebElement printbody = driver.switchTo().activeElement();
        printbody.sendKeys(message);
        driver.switchTo().defaultContent();*/
        /****************************************************/



        //driver.findElement(By.xpath("//div[@role='button']/b")).click();
        //driver.findElement(By.tagName("body")).getText().contains("Your message has been sent");

        //driver.findElement(By.xpath("//div[contains(text(),'Send')]")).click();
        /*WebElement webElement=driver.findElement(By.id(":6p"));
        webElement.click();
        webElement.clear();
        webElement.sendKeys(message);
        Thread.sleep(1000);
        driver.findElement(By.id(":8r")).click();//Send*/
    }
    public void readEmail(Properties props,String host,String emailLogIn, String emailTo,String subject,String message, String password){

        String email=null;
        try {

            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect(host, emailLogIn, password);
            //System.out.println(store);
            Folder[] f = store.getDefaultFolder().list();
            Folder inbox = store.getFolder("[Gmail]/Sent Mail");
            inbox.open(Folder.READ_ONLY);
            Message msg = inbox.getMessage(inbox.getMessageCount());
            Address[] in = msg.getFrom();
            Address[] in2=msg.getAllRecipients();
            for (Address address : in2) {
                System.out.println("Asserting  "+emailTo+ " and "+address.toString()+" to be equal");
                Assert.assertEquals(emailTo,address.toString(), "Asserting  "+emailTo+ " and "+address.toString()+" to be equal");

            }
            for (Address address : in) {
                //System.out.println("FROM:" + address.toString());
                email=address.toString().split("<")[1].replace('>',' ').replaceAll("\\s+","");
                System.out.println("Asserting  "+email+ " and "+emailLogIn+" to be equal");
                Assert.assertEquals(email, emailLogIn, "Asserting  " + email+ " and "+emailLogIn+" to be equal");
            }

            Multipart mp = (Multipart) msg.getContent();
            BodyPart bp = mp.getBodyPart(0);
            /*System.out.println("SENT DATE:" + msg.getSentDate());
            System.out.println("CONTENT:" + bp.getContent());*/
            System.out.println("Asserting "+subject+" and  "+msg.getSubject()+" to be equal");
            Assert.assertEquals(subject, msg.getSubject(), "Asserting "+subject+" and  "+msg.getSubject()+" to be equal");
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }
    public void verifyUnreadEmails()throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //String cssPath1="#gb > div.gb_qd.gb_le > div.gb_La.gb_le.gb_R.gb_ke.gb_T > div.gb_Pb.gb_le.gb_R > div.gb_Ta.gb_Rb.gb_le.gb_R";

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssPath1)));
        //assertEquals("https://mail.google.com/mail/#inbox",driver.getCurrentUrl());

        String id1=":5";
        String cssPath1="#\\3a 5 > div";
        String cssPath2="#\\3a 5 > div > div.nH.aqK";
        String cssPath3="#\\3a 5 > div > div.nH.aqK > div.Cr.aqJ";
        String cssPath4="#\\3a 5 > div > div.nH.aqK > div.Cr.aqJ > div.ar5.J-J5-Ji";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id1)));
        WebElement webElementId1=driver.findElement(By.id(id1));
        WebElement webElement1=webElementId1.findElement(By.cssSelector(cssPath1));
        WebElement webElement2=webElement1.findElement(By.cssSelector(cssPath2));
        WebElement webElement3=webElement2.findElement(By.cssSelector(cssPath3));
        WebElement webElement4=webElement3.findElement(By.cssSelector(cssPath4));
        String []splitArray=webElement4.getText().split(" ");
        int limit=splitArray.length-1;

        System.out.println("Total emails " + splitArray[limit]);

        cssPath1="body > div:nth-child(16) > div.nH > div > div:nth-child(2) > div.no";
        cssPath2="body > div:nth-child(16) > div.nH > div > div:nth-child(2) > div.no > div.nH.oy8Mbf.nn.aeN";
        cssPath3="body > div:nth-child(16) > div.nH > div > div:nth-child(2) > div.no > div.nH.oy8Mbf.nn.aeN > div.Ls77Lb.aZ6";
        cssPath4="body > div:nth-child(16) > div.nH > div > div:nth-child(2) > div.no > div.nH.oy8Mbf.nn.aeN > div.Ls77Lb.aZ6 > div.aj9.pp";
        String cssPath5="#\\3a 4s";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssPath1)));

        webElement1=driver.findElement(By.cssSelector(cssPath1));
        webElement2=webElement1.findElement(By.cssSelector(cssPath2));
        webElement3=webElement2.findElement(By.cssSelector(cssPath3));
        webElement4=webElement3.findElement(By.cssSelector(cssPath4));

        splitArray=webElement4.getText().split(" ");
        limit=splitArray.length-1;
        System.out.println("Unread e-mails: " + splitArray[1].substring(1, 2));

    }
    public void deleteEmail(Properties properties,String host,String user,
                            String password, String deleteEmailFrom)throws InterruptedException{
        try
        {

            // emailSession.setDebug(true);
            Session emailSession = Session.getDefaultInstance(properties);
            // create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            store.connect(host, user, password);

            // create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_WRITE);
            Message[] messages = emailFolder.getMessages();
            String from=null;
            String subject =null;
            int emailFound=0;
            int numberOfEmails=0;
            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                from=message.getFrom()[0].toString().split("<")[1].replace('>',' ').replaceAll("\\s+", "");
                subject = message.getSubject();
                numberOfEmails++;
                if (deleteEmailFrom.equals(from)){
                    // set the DELETE flag to true
                    emailFound++;
                    message.setFlag(Flags.Flag.DELETED, true);
                    System.out.println("Marked DELETE for message: " + subject+ " FROM "+from );
                }
            }
            if(emailFound>0) {
                System.out.println(emailFound + " emails from " + deleteEmailFrom + " deleted");
                Thread.sleep(2000);
            }
            else {
                System.out.println("No emails from " + deleteEmailFrom + " were deleted");
            }
            // expunges the folder to remove messages which are marked deleted
            //emailFolder.expunge();

            emailFolder.close(true);

            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
