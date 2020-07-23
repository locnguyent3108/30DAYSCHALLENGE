package handleTable;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class jqueryPageObjects extends AbstractPage {

    public jqueryPageObjects(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openUrl(String urlValue) {
        super.openUrl(urlValue);

    }

    public void selectCountryAtRow(int row, String countryName  ) {
        String locator = String.format(jqueryUI.COUNTRY_SELECT_DYNAMIC, row);
        waitForElementVisible(locator);
        selectValueInDropdown(locator,countryName);
    }
}
