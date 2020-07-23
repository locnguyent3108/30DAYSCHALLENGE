package pageObjects.wordpress;

import commons.AbstractPage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUI.wordpress.PostPageUI;

public class PostPageObject extends AbstractPage {
    public PostPageObject(WebDriver driver) {
        super(driver);
    }

    public void isPageLoaded() {
        waitForElementVisible(PostPageUI.HEADER_TEXT);
        isElementDisplayed(PostPageUI.HEADER_TEXT);
    }
}
