//package com.wordpress.login;
//
//import browserFactory.BrowserFactory;
//import browserFactory.DriverManager;
//import commons.AbstractTest;
//import commons.PageGenerator;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.*;
//import pageObjects.wordpress.DashboardPageObject;
//import pageObjects.wordpress.LoginPageObject;
//
//public class Login_02_Apply_AbstractPage extends AbstractTest {
//    WebDriver driver;
//    DriverManager driverBrowser;
//    LoginPageObject loginPage;
//    DashboardPageObject dashboardPage;
//    //automationeditor : automationfc
//    //apply page factory
//    @Parameters("browser")
//    @BeforeClass
//    public void beforeClass(String browserName) {
//        driverBrowser = BrowserFactory.getInstance(browserName);
//        driver = driverBrowser.getDriver();
//        loginPage = PageGenerator.getLoginPageInstance(driver);
//        dashboardPage = (DashboardPageObject) PageGenerator.getDestinationPageInstionce(driver,"Dashboard");
//    }
//
//    @BeforeMethod
//    public void beforeMethod() {
//        loginPage = new LoginPageObject(driver);
//        loginPage.openLoginPage("https://automationfc.wordpress.com/wp-admin");
//    }
//
//    @Test
//    public void validate_01_EmptyEmail() throws InterruptedException {
//        loginPage.inputToEmailTextBox("");
//        loginPage.openDashboard();
//        Assert.assertEquals(loginPage.getErrorMessage(),
//                "Please enter a username or email address.");
//
//    }
//
//    @Test
//    public void validate_02_InvalidEmail() throws InterruptedException {
//        loginPage.inputToEmailTextBox("123@123.com");
//        loginPage.openDashboard();
//        Assert.assertEquals(loginPage.getErrorMessage(),
//                "Please log in using your WordPress.com username instead of your email address.");
//    }
//
//    @Test
//    public void validate_03_EmailNotExist() throws InterruptedException {
//        loginPage.inputToEmailTextBox("automation123@gmail.com");
//        loginPage.openDashboard();
//        Assert.assertEquals(loginPage.getErrorMessage(),
//                "User does not exist. Would you like to create a new account?");
//    }
////
//    @Test
//    public void validate_04_EmptyPassword() throws InterruptedException {
//        loginPage.inputToEmailTextBox("automationeditor");
//        loginPage.openDashboard();
//        loginPage.inputToPassword("");
//        loginPage.openDashboard();
//    }
////
//    @Test
//    public void validate_05_PasswordLessThan6Chars() {
//        loginPage.inputToEmailTextBox("automationeditor");
//        loginPage.openDashboard();
//        loginPage.inputToPassword("onfc");
//        loginPage.openDashboard();
//    }
//
//    @Test
//    public void validate_06_ValidPassword() {
//        loginPage.inputToEmailTextBox("automationeditor");
//        loginPage.openDashboard();
//        loginPage.inputToPassword("automationfc");
//        loginPage.openDashboard();
//
//        dashboardPage = new DashboardPageObject(driver);
//        dashboardPage.isDashboardDisplay();
//    }
//
//    @AfterClass
//    public void afterMethod() {
//        driver.quit();
//    }
//
//    private int random() {
//        return (int)System.currentTimeMillis();
//    }
//}
