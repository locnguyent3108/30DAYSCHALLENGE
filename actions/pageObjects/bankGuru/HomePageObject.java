package pageObjects.bankGuru;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends AbstractPage {
    public HomePageObject(WebDriver driver) {
        super(driver);
        System.out.println("Driver at home page: " + driver.toString());
    }


}
