package com.wordpress.login;

import browserFactory.BrowserFactory;
import browserFactory.DriverManager;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.wordpress.*;

public class Login_06_WebDriver_Life_Cycle {
    WebDriver driver;
    DriverManager driverBrowser;
    LoginPageObject loginPage;
    DashboardPageObject dashboardPage;
    PostPageObject postPage;
    MediaPageObject mediaPage;
    PageObjects pagePage;
    //automationeditor : automationfc
    //apply page factory
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driverBrowser = BrowserFactory.getInstance(browserName);
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
        postPage = (PostPageObject) dashboardPage.navigateToPage("Posts");
        mediaPage.navigateToPage("Media");
        dashboardPage.navigateToPage("Pages");
    }

    @AfterClass
    public void afterMethod() {
        driver.quit();
    }

    private int random() {
        return (int)System.currentTimeMillis();
    }

}
