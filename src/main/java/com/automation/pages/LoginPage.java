package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.automation.utilities.WaitUtil;

public class LoginPage {
    private WebDriver driver;
    
    // Locators
    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.id("submit");
    private By errorMessageLocator = By.className("post-title");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WaitUtil.waitForElementVisibility(driver, usernameLocator, 15).sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordField = WaitUtil.waitForElementVisibility(driver, passwordLocator, 15);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = WaitUtil.waitForElementToBeClickable(driver, loginButtonLocator, 15);
        loginButton.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
