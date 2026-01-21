package com.automation.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;

    public ConfigFileReader() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            System.out.println("Config file not found: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getApplicationUrl() {
        return properties.getProperty("app.url", "https://practicetestautomation.com/practice-test-login/");
    }

    public String getBrowser() {
        return properties.getProperty("browser", "chrome");
    }

    public int getExplicitWaitTimeout() {
        String timeout = properties.getProperty("explicit.wait.timeout", "15");
        return Integer.parseInt(timeout);
    }

    public boolean getHeadlessMode() {
        String headless = properties.getProperty("headless.mode", "false");
        return Boolean.parseBoolean(headless);
    }

    public String getScreenshotPath() {
        return properties.getProperty("screenshot.path", "./reports/screenshots/");
    }

    public String getLogLevel() {
        return properties.getProperty("log.level", "INFO");
    }
}
