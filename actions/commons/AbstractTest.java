package commons;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class AbstractTest {
    WebDriver driver;
//    protected  final Logger log;

    public AbstractTest() {
//        this.log = Logger.log
    }
//    public WebDriver getBrowserDriver(String browserName) {
//        if (browserName.equals("Chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        } else if(browserName.equals("Firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        } else {
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        }
//        return driver;
//    }

    private boolean checkTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;

            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyTrue(boolean condition) {
        return checkTrue(condition);
    }

    private boolean checkFailed(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        return checkFailed(condition);
    }

    private boolean checkEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        return checkEquals(actual, expected);
    }

}
