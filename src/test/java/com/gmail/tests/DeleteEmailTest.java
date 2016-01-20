package com.gmail.tests;
import com.gmail.pages.BasePage;
import com.gmail.pages.HomePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Alexis Espinoza on 1/5/16.
 */
public class DeleteEmailTest extends BasePage {
    private String accountLogin;
    private String password;
    @Parameters({ "email", "password", "browser" })
    @BeforeTest
    public void setUpLocal(@Optional("-1")String email,@Optional("")String password,@Optional("firefox") String browser)throws IOException {
        this.setUp(browser);

        if(email.equals("-1")) {
            accountLogin = account2;
            this.password =passwordAccounts;
        }
        else {
            accountLogin = email;
            this.password=password;
        }

    }
    @Test
    public void  deleteEmail()throws InterruptedException{
        HomePage homePage =new HomePage();
        //Delete email from TOM
        Properties properties=returnProtocolConnection(2);
        homePage.deleteEmail(properties,host,accountLogin, password,account1);
        Thread.sleep(2000);

    }
    @Test
    public void runVerifyUnreadEmailsTest()throws InterruptedException{
        HomePage homePage =new HomePage(driver,true);
        homePage.logIn(linkAssertion1,accountLogin,this.password);
        homePage.verifyUnreadEmails();
        homePage.logOut(linkAssertion4);
        close();
    }
}
