package com.gmail.tests;

import com.gmail.pages.BasePage;
import com.gmail.pages.HomePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * Created by Alexis Espinoza on 11/16/15.
 */
public class LoginLogOutTest extends BasePage {
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
    public void loginLogOut()throws InterruptedException{
        HomePage homePage =new HomePage(driver,true);
        homePage.logIn(linkAssertion1,account,this.password);
        homePage.logOut(linkAssertion4);
        close();
    }

}
