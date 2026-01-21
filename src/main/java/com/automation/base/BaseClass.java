package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.automation.utilities.ScreenshotUtil;
import com.automation.utilities.LogUtil;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    protected WebDriver driver;
    protected ConfigFileReader configFileReader;
    protected ScreenshotUtil screenshotUtil;
    protected LogUtil logUtil;

    @BeforeMethod
    public void setUp() {
        configFileReader = new ConfigFileReader();
        logUtil = new LogUtil();
        screenshotUtil = new ScreenshotUtil();
        
        String browser = configFileReader.getBrowser();
        String url = configFileReader.getApplicationUrl();
        int timeout = configFileReader.getExplicitWaitTimeout();
        
        driver = DriverFactory.getDriver(browser);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        
        logUtil.info("Browser launched with URL: " + url);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logUtil.info("Browser closed successfully");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
