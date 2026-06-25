package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {

        LoginPage login = new LoginPage(page);

        login.openLoginPage();
        login.login(
                ConfigReader.get("email"),
                ConfigReader.get("password")
        );


        Assert.assertTrue(login.isLoginSuccessful(), "Login Failed");

        System.out.println("Login Successful");
    }
}