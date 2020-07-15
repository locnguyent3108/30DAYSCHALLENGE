package com.wordpress.login;

import commons.AbstractPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Login_02_Apply_AbstractPage extends AbstractPage{
    WebDriver driver;
    AbstractPage abstractPage;
    String emailTextboxBy = "//input[@id='usernameOrEmail']";
    String passwordTextboxBy = "//input[@id='password']";
    String loginButtonBy = "//div[@class='login__form-action']/button";
    String emailErrorMessageBy = "//div[@class='form-input-validation is-error']/span";
    String passwordErrorMessageBy = "//div[@class='form-input-validation is-error']/span";

    public Login_02_Apply_AbstractPage(WebDriver driver) {
        super(driver);
    }
    //automationeditor : automationfc

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod() {

        driver.get("https://automationfc.wordpress.com/wp-admin");
    }

    @Test
    public void validate_01_EmptyEmail() throws InterruptedException {
        abstractPage = new AbstractPage(driver);
        abstractPage.findElement(emailTextboxBy).sendKeys("");
        abstractPage.findElement(loginButtonBy).click();
        String errorMsg = abstractPage.findElement(emailErrorMessageBy).getText().trim();
        Thread.sleep(1000);
        assertThat(errorMsg, is("Please enter a username or email address."));
    }

    @Test
    public void validate_02_InvalidEmail() throws InterruptedException {
        abstractPage.findElement(emailTextboxBy).sendKeys("123@123");
        abstractPage.findElement(loginButtonBy).click();
        String errorMsg = abstractPage.findElement(emailErrorMessageBy).getText().trim();
        Thread.sleep(1000);
        assertThat(errorMsg, is("Please log in using your WordPress"));
    }

    @Test
    public void validate_03_EmailNotExist() throws InterruptedException {
        // "User does not exist.\n Would you ike to \n create a new account\n";
        abstractPage.findElement(emailTextboxBy).sendKeys("locAuto" + random() + "@gmail.com");
        abstractPage.findElement(loginButtonBy).click();
        String errorMsg = abstractPage.findElement(emailErrorMessageBy).getText().trim();
        Thread.sleep(1000);

        assertThat(errorMsg, is("User does not exist. Would you like to create a new account?"));
    }

    @Test
    public void validate_04_EmailNotExist() throws InterruptedException {
        abstractPage.findElement(emailTextboxBy).sendKeys("automationeditor");
        abstractPage.findElement(loginButtonBy).click();
        abstractPage.findElement(passwordTextboxBy).sendKeys("");
        abstractPage.findElement(loginButtonBy).click();

        String errorMsg = abstractPage.findElement(passwordErrorMessageBy).getText().trim();
        Thread.sleep(1000);

        assertThat(errorMsg, is("Don't forget to enter your password."));
    }

    @Test
    public void validate_05_PasswordLessThan6Chars() {
        abstractPage.findElement(emailTextboxBy).sendKeys("automationeditor");
        abstractPage.findElement(loginButtonBy).click();
        abstractPage.findElement(passwordTextboxBy).sendKeys("123");
        abstractPage.findElement(loginButtonBy).click();

        String errorMsg = abstractPage.findElement(passwordErrorMessageBy).getText().trim();
        assertThat(errorMsg, is("Oops, that's not the right password. Please try again!"));
    }

    @Test
    public void validate_06_ValidPassword() {
        abstractPage.findElement(emailTextboxBy).sendKeys("automationeditor");
        abstractPage.findElement(loginButtonBy).click();
        abstractPage.findElement(passwordTextboxBy).sendKeys("automationfc");
        abstractPage.findElement(loginButtonBy).click();

        Assert.assertTrue(abstractPage.findElement("//h1[text()='Dashboard']").isDisplayed());
    }

    @AfterClass
    public void afterMethod() {

    }

    private int random() {
        return (int)System.currentTimeMillis();
    }
}
