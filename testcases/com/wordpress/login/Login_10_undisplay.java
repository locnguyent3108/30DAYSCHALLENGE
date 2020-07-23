package com.wordpress.login;

import browserFactory.BrowserFactory;
import browserFactory.DriverManager;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.wordpress.*;

public class Login_10_undisplay {
    WebDriver driver;
    DriverManager driverBrowser;
    LoginPageObject loginPage;
    DashboardPageObject dashboardPage;
    PostPageObject postPage;
    MediaPageObject mediaPage;
    PageObjects pagePage;
    @BeforeClass
    public void beforeClass() {
        driverBrowser = BrowserFactory.getInstance("CHROME");
        driver = driverBrowser.getDriver();
        loginPage = PageGenerator.getLoginPageInstance(driver);
        loginPage.openLoginPage("https://automationfc.wordpress.com/wp-admin");
    }

    @Test
    public void TC_01_Element_In_DOM() {
        loginPage.inputToEmailTextBox("automationeditor");
        loginPage.clickToLogin();
        loginPage.inputToPassword("automationfc");
        loginPage.clickToLogin();

        dashboardPage = (DashboardPageObject) loginPage.navigateToPage("Dashboard");

        dashboardPage.clickToScreenOption();
        System.out.println("START check activity displayed:" + dashboardPage.getDateTimeNow());
        Assert.assertTrue(dashboardPage.isActivityCheckboxDisplayed());
        System.out.println("END check activity displayed:" + dashboardPage.getDateTimeNow());

        dashboardPage.clickToScreenOption();

    }

    @Test
    public void TC_02_Element_Not_In_DOM() {
        loginPage.inputToEmailTextBox("automationeditor");
        loginPage.clickToLogin();
        loginPage.inputToPassword("automationfc");
        loginPage.clickToLogin();

        dashboardPage = (DashboardPageObject) loginPage.navigateToPage("Dashboard");
        System.out.println("START:-----" + dashboardPage.getDateTimeNow() + "-----");
        Assert.assertFalse(dashboardPage.isPlansMenuDisplayed());
        System.out.println("START:-----" + dashboardPage.getDateTimeNow() + "-----");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
