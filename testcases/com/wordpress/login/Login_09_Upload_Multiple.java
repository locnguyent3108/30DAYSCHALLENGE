package com.wordpress.login;

import browserFactory.BrowserFactory;
import browserFactory.DriverManager;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.wordpress.*;

public class Login_09_Upload_Multiple {
    WebDriver driver;
    DriverManager driverBrowser;
    LoginPageObject loginPage;
    DashboardPageObject dashboardPage;
    PostPageObject postPage;
    MediaPageObject mediaPage;
    PageObjects pagePage;
    //automationeditor : automationfc
    //apply page factory
//    @Parameters("browser")
    @BeforeClass
    public void beforeClass() {
        driverBrowser = BrowserFactory.getInstance("CHROME");
        driver = driverBrowser.getDriver();
        loginPage = PageGenerator.getLoginPageInstance(driver);
        loginPage.openLoginPage("https://automationfc.wordpress.com/wp-admin");
    }

    @Test
    public void TC_01_LoginToSystem() {
        loginPage.inputToEmailTextBox("automationeditor");
        loginPage.clickToLogin();
        loginPage.inputToPassword("automationfc");
        loginPage.clickToLogin();

        dashboardPage = (DashboardPageObject) loginPage.navigateToPage("Dashboard");
        dashboardPage.isDashboardDisplay();
    }

    @Test
    public void TC_02_NavigateToPage() {
        mediaPage = (MediaPageObject) dashboardPage.navigateToPage("Media");
        mediaPage.clickAddNew();
        mediaPage.uploadMultipleFiles();
    }

    @AfterClass
    public void afterMethod() {
        driver.quit();
    }

    private int random() {
        return (int)System.currentTimeMillis();
    }
}
