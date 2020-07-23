package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.wordpress.*;

import javax.print.attribute.standard.Media;

public class PageGenerator {

    public static LoginPageObject getLoginPageInstance(WebDriver driver) {
        return new LoginPageObject(driver);
    }
//
//    public static DashboardPageObject getDashboardPageInstance(WebDriver driver) {
//        return new DashboardPageObject(driver);
//    }
//
//    public static PostPageObject getPostPageInstance(WebDriver driver) {
//        return new PostPageObject(driver);
//    }
//
//    public static PageObjects getPageInstance(WebDriver driver) {
//        return new PageObjects(driver);
//    }
//
//    public static MediaPageObject getMediaPageInstance(WebDriver driver) {
//        return new MediaPageObject(driver);
//    }

    public static Object getDestinationPageInstionce(WebDriver driver, String locator) {
        switch (locator) {
            case "Media":
                return new MediaPageObject(driver);
            case "Posts":
                return new PostPageObject(driver);
            case "Pages":
                return new PageObjects(driver);
            case "Dashboard":
                return new DashboardPageObject(driver);
            default:
                return new DashboardPageObject(driver);
        }
    }



}
