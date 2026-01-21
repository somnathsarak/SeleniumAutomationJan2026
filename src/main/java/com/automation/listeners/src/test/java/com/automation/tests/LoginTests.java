package com.automation.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.automation.base.BaseClass;
import com.automation.pages.LoginPage;

public class LoginTests extends BaseClass {
    private LoginPage loginPage;

    @Test(priority = 1, description = "Valid login test")
    public void validLoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.login("student", "Password123");
    }

    @Test(priority = 2, description = "Empty username test")
    public void emptyUsernameTest() {
        loginPage = new LoginPage(driver);
        loginPage.login("", "Password123");
    }

    @Test(priority = 3, description = "Empty password test")
    public void emptyPasswordTest() {
        loginPage = new LoginPage(driver);
        loginPage.login("student", "");
    }

    @Test(priority = 4, description = "Invalid credentials test")
    public void invalidCredentialsTest() {
        loginPage = new LoginPage(driver);
        loginPage.login("invalid", "invalid");
    }

    @Test(priority = 5, description = "Special characters in password test")
    public void specialCharactersTest() {
        loginPage = new LoginPage(driver);
        loginPage.login("student", "P@ss!@#123");
    }
}
