package pageObjects.wordpress;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.wordpress.DashboardPageUI;

public class DashboardPageObject extends AbstractPage {

    @Override
    public boolean isPageLoaded(String pageUrl) {
        return false;
    }

    public DashboardPageObject(WebDriver driver) {
        super(driver);
    }

    public void isDashboardDisplay() {
        waitForElementVisible(DashboardPageUI.HEADER_TEXT);
        isElementDisplayed(DashboardPageUI.HEADER_TEXT);
    }
}
