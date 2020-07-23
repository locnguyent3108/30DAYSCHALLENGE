package pageObjects.wordpress;

import commons.AbstractPage;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import pageUI.wordpress.DashboardPageUI;
import pageUI.wordpress.LoginPageUI;

public class LoginPageObject extends AbstractPage {

    public LoginPageObject(WebDriver driver) {
        super(driver);
    }

    public void inputToEmailTextBox(String value) {
        sendKey(LoginPageUI.EMAIL_TEXTBOX, value);
    }

    public void openLoginPage(String url) {
        openUrl(url);
    }

    public String getErrorMessage() {
       waitForElementVisible(LoginPageUI.ERROR_MESSAGE);
       return getElementText(LoginPageUI.ERROR_MESSAGE);
    }

    public void clickToLogin() {
        waitForElementClickable(LoginPageUI.CONTINUE_OR_LOGIN_BUTTON);
        clickElement(LoginPageUI.CONTINUE_OR_LOGIN_BUTTON);
    }

    public void inputToPassword(String s) {
        waitForElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
        sendKey(LoginPageUI.PASSWORD_TEXTBOX, s);
    }
}