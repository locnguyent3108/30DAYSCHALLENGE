package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.wordpress.LoginPageObject;
import pageObjects.wordpress.DashboardPageObject;

public class PageGenerator {

    public static LoginPageObject getLoginPageInstance(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static DashboardPageObject getDashboardPageInstance(WebDriver driver) {
        return new DashboardPageObject(driver);
    }
}
