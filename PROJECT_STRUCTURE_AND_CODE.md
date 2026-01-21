# Selenium Automation Framework - Jan 2026

## Project Overview
Complete Java Selenium WebDriver test automation framework using Maven and TestNG with Extent Reports, Excel data-driven testing, configuration management, and production-ready patterns.

## Project Structure
```
SeleniumAutomationJan2026/
├── src/
│   ├── main/
│   │   ├── java/com/automation/
│   │   │   ├── base/
│   │   │   │   ├── BaseClass.java
│   │   │   │   ├── ConfigFileReader.java
│   │   │   │   └── DriverFactory.java
│   │   │   ├── utilities/
│   │   │   │   ├── ScreenshotUtil.java
│   │   │   │   ├── WaitUtil.java
│   │   │   │   ├── ExcelFileManager.java
│   │   │   │   └── LogUtil.java
│   │   │   ├── pages/
│   │   │   │   └── LoginPage.java (POM)
│   │   │   ├── listeners/
│   │   │   │   └── ExtentReportListener.java
│   │   │   └── tests/
│   │   │       └── LoginTests.java
│   │   └── resources/
│   │       └── config.properties
│   └── test/
│       └── java/com/automation/tests/
├── reports/
│   └── screenshots/
├── pom.xml
├── testng.xml
└── README.md
```

## Key Features
✓ BaseClass for WebDriver initialization and cleanup
✓ ConfigFileReader for property management
✓ DriverFactory for multi-browser support (Chrome, Firefox, Edge)
✓ Screenshot utility with timestamp
✓ WaitUtil for explicit/implicit waits
✓ ExcelFileManager for data-driven testing
✓ LogUtil for logging
✓ Page Object Model (LoginPage)
✓ ExtentReportListener for enhanced reporting
✓ 5 comprehensive LoginTests with priorities
✓ TestNG XML configuration
✓ Maven build support

## Maven Dependencies
- Selenium WebDriver 4.10.0
- TestNG 7.8.1
- Extent Reports 5.0.9
- Apache POI 5.2.3
- Log4j 1.2.17
- WebDriverManager 5.7.0

## Running Tests
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

## Configuration (config.properties)
- app.url: Application URL
- browser: Chrome (default), Firefox, Edge
- explicit.wait.timeout: 15 seconds
- screenshot.path: ./reports/screenshots/
- log.level: INFO

## Test Cases
1. validLoginTest - Valid credentials
2. emptyUsernameTest - Empty username field
3. emptyPasswordTest - Empty password field
4. invalidCredentialsTest - Invalid credentials
5. specialCharactersTest - Special characters in password

## Reports
Extent Reports are generated in: ./reports/[timestamp]/ExtentReport.html

## Framework Capabilities
- Cross-browser testing support
- Data-driven testing with Excel
- Detailed logging and screenshots
- Priority-based test execution
- Listener-based reporting
- Configuration management
- Reusable utility classes
- Page Object Model pattern
