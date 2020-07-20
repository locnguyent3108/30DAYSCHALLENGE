package pageObjects.wordpress;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.wordpress.LoginPageUI;

public class LoginPageObject extends AbstractPage {

    @Override
    public boolean isPageLoaded(String pageUrl) {
        return false;
    }

    public LoginPageObject(WebDriver driver) {
        super(driver);
    }

    public void inputToEmailTextBox(String value) {
        sendKey(LoginPageUI.EMAIL_TEXTBOX, value);
    }

    public void openLoginPage(String url) {
        openUrl(url);
    }

    public void clickLoginButton() {
        clickElement(LoginPageUI.CONTINUE_OR_LOGIN_BUTTON);
    }

    public String getErrorMessage() {
       waitForElementVisible(LoginPageUI.ERROR_MESSAGE);
       return getElementText(LoginPageUI.ERROR_MESSAGE);
    }

    public void inputToPassword(String s) {
        waitForElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
        sendKey(LoginPageUI.PASSWORD_TEXTBOX, "automationfc");
    }
}