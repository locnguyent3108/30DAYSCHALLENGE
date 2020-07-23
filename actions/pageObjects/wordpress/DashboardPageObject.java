package pageObjects.wordpress;

import commons.AbstractPage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUI.wordpress.DashboardPageUI;

import java.util.Date;

public class DashboardPageObject extends AbstractPage {

    public DashboardPageObject(WebDriver driver) {
        super(driver);
    }

    public void isDashboardDisplay() {
        waitForElementVisible(DashboardPageUI.HEADER_TEXT);
        isElementDisplayed(DashboardPageUI.HEADER_TEXT);
    }


    public void clickToScreenOption() {
        waitForElementVisible(DashboardPageUI.HEADER_TEXT);
        clickElement(DashboardPageUI.SCREEN_OPTION_BUTTON);
    }

    public boolean isActivityCheckboxDisplayed() {
        waitForElementVisible(DashboardPageUI.ACTIVITY_CHECKBOX);
        return isElementDisplayed(DashboardPageUI.ACTIVITY_CHECKBOX);
    }

    public boolean isAllPostsSubMenuDisplayed() {
        waitForElementVisible(DashboardPageUI.ALL_POSTS_SUBMENU);
        return isElementDisplayed(DashboardPageUI.ALL_POSTS_SUBMENU);
    }

    public Date getDateTimeNow() {
        Date date = new Date();
        return date;
    }

    public boolean isPlansMenuDisplayed() {
        return isElementDisplayed(DashboardPageUI.PLANS_LINK);
    }
}

