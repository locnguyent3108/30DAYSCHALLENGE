//package com.wordpress.login;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.*;
//
//import java.util.concurrent.TimeUnit;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//public class TC_01_ValidateLoginForm {
//    WebDriver driver;
//    //automationeditor : automationfc
//
//    @BeforeClass
//    public void beforeClass() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }
//
//    @BeforeMethod
//    public void beforeMethod() {
//        driver.get("https://automationfc.wordpress.com/wp-admin");
//    }
//
//    @Test
//    public void validate_01_EmptyEmail() throws InterruptedException {
//        driver.findElement(emailTextboxBy).sendKeys("");
//        driver.findElement(loginButtonBy).click();
//        String errorMsg = driver.findElement(emailErrorMessageBy).getText().trim();
//        Thread.sleep(1000);
//        assertThat(errorMsg, is("Please enter a username or email address."));
//    }
//
//    @Test
//    public void validate_02_InvalidEmail() throws InterruptedException {
//        driver.findElement(emailTextboxBy).sendKeys("123@123");
//        driver.findElement(loginButtonBy).click();
//        String errorMsg = driver.findElement(emailErrorMessageBy).getText().trim();
//        Thread.sleep(1000);
//        assertThat(errorMsg, is("Please log in using your WordPress"));
//    }
//
//    @Test
//    public void validate_03_EmailNotExist() throws InterruptedException {
//        // "User does not exist.\n Would you ike to \n create a new account\n";
//        driver.findElement(emailTextboxBy).sendKeys("locAuto" + random() + "@gmail.com");
//        driver.findElement(loginButtonBy).click();
//        String errorMsg = driver.findElement(emailErrorMessageBy).getText().trim();
//        Thread.sleep(1000);
//
//        assertThat(errorMsg, is("User does not exist. Would you like to create a new account?"));
//    }
//
//    @Test
//    public void validate_04_EmailNotExist() throws InterruptedException {
//        driver.findElement(emailTextboxBy).sendKeys("automationeditor");
//        driver.findElement(loginButtonBy).click();
//        driver.findElement(passwordTextboxBy).sendKeys("");
//        driver.findElement(loginButtonBy).click();
//
//        String errorMsg = driver.findElement(passwordErrorMessageBy).getText().trim();
//        Thread.sleep(1000);
//
//        assertThat(errorMsg, is("Don't forget to enter your password."));
//    }
//
//    @Test
//    public void validate_05_PasswordLessThan6Chars() {
//        driver.findElement(emailTextboxBy).sendKeys("automationeditor");
//        driver.findElement(loginButtonBy).click();
//        driver.findElement(passwordTextboxBy).sendKeys("123");
//        driver.findElement(loginButtonBy).click();
//
//        String errorMsg = driver.findElement(passwordErrorMessageBy).getText().trim();
//        assertThat(errorMsg, is("Oops, that's not the right password. Please try again!"));
//    }
//
//    @Test
//    public void validate_06_ValidPassword() {
//        driver.findElement(emailTextboxBy).sendKeys("automationeditor");
//        driver.findElement(loginButtonBy).click();
//        driver.findElement(passwordTextboxBy).sendKeys("automationfc");
//        driver.findElement(loginButtonBy).click();
//
//        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Dashboard']")).isDisplayed());
//    }
//
//    @AfterClass
//    public void afterMethod() {
//
//    }
//
//    private int random() {
//        return (int)System.currentTimeMillis();
//    }
//}
