package pageObjects.wordpress;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.wordpress.MediaPageUI;

public class MediaPageObject extends AbstractPage {
    public MediaPageObject(WebDriver driver) {
        super(driver);
    }

    public void clickAddNew() {
        waitForElementClickable(MediaPageUI.ADD_NEW_BUTTON);
        clickElement(MediaPageUI.ADD_NEW_BUTTON);
    }
}


