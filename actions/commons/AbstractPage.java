package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public abstract class AbstractPage {
    public abstract boolean isPageLoaded(String pageUrl);

    WebDriverWait explicitWait;
    WebDriver driver;
    Select select;
    JavascriptExecutor jsExec;
    Actions act;
    long longTimeout = 30;
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl(String urlValue) {
        driver.get(urlValue);
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
    public String getPageTitle() {
        return driver.getTitle();
    }

    public void back(){
        driver.navigate().back();
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void forward() {
        driver.navigate().forward();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void cancelAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void sendkeyToAlert(String value) {
        driver.switchTo().alert().sendKeys(value);
    }

    public String getTextInAlert() {
        return driver.switchTo().alert().getText();
    }

    public void waitAlertPresence() {
        explicitWait = new WebDriverWait(driver, 15);
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void switchWindowByID(String parentID) {
        Set<String> allWindows = driver.getWindowHandles();

        for(String runWindow: allWindows) {
            if(runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for(String runWindow: allWindows) {
            driver.switchTo().window(runWindow);
            String currentWinTitle = driver.getTitle();
            if(currentWinTitle.equals(title)) {
                break;
            }
        }
    }

    public boolean areAllWindowClosedWithoutParent(String parentWindow) {
        Set<String> allWindow = driver.getWindowHandles();
        for(String runWindows: allWindow) {
            if(runWindows.equals(parentWindow)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
        if(driver.getWindowHandles().size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public By byXpath(String locator) {
        return By.xpath(locator);
    }

    public WebElement findElement(String locator) {
        return driver.findElement(byXpath(locator));
    }

    public List<WebElement> findListElement(String locator) {
        return driver.findElements(byXpath(locator));
    }

    public int countElementNumber(String locator) {
        List<WebElement> elements = findListElement(locator);
        return elements.size();
    }

    public void clickToCheckbox(String locator) {
        WebElement e = findElement(locator);
        if(!e.isDisplayed()) {
            e.click();
        }
    }

    public void unselectCheckBox(String locator) {
        WebElement e = findElement(locator);
        if(e.isDisplayed()) {
            e.click();
        }
    }

    public void clickElement(String locator) {
        findElement(locator).click();
    }

    public void sendKey(String locator, String value) {
        WebElement e = findElement(locator);
        e.sendKeys(value);
    }

    public String getElementText(String locator) {
        return findElement(locator).getText();
    }

    public String getElementAttribute(String locator, String attributeName) {
        return findElement(locator).getAttribute(attributeName);
    }
    public void selectValueInDropdown(WebDriver driver, String locator, String value) {
        select = new Select(findElement(locator));
        select.selectByVisibleText(value);
    }

    public String getSelectedItemInDropdown(String locator) {
        select = new Select(findElement(locator));
        return select.getFirstSelectedOption().getText();
    }

    public void selectItemInCustomDropdown(String parentXPath, String allItemXpath, String expectedValueItem) throws InterruptedException {
        WebElement parentNode = findElement(parentXPath);
        jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].click", parentNode);

        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(allItemXpath)));
        List<WebElement> allItems = findListElement(allItemXpath);

        for(WebElement childElement : allItems) {
            if (childElement.getText().equals(expectedValueItem)) {
                childElement.click();
            } else {
                jsExec.executeScript("arguments[0].scrollToView(true)", childElement);
                jsExec.executeScript("arguments[0].click()", childElement);
            }
            break;
        }
    }

    public boolean isElementDisplayed(String locator) {
        return findElement(locator).isDisplayed();
    }

    public boolean isElementEnabled(String locator) {
        return findElement(locator).isEnabled();
    }

    public boolean isElementSelected(String locator) {
        return findElement(locator).isSelected();
    }

    public void switchToIFrame(String locator) {
        driver.switchTo().frame(findElement(locator));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void hoverMouseToElement(String locator) {
        act = new Actions(driver);
        act.moveToElement(findElement(locator))
            .perform();
    }

    public void doubleClick(String locator) {
        act = new Actions(driver);
        act.doubleClick(findElement(locator))
                .perform();
    }

    public void rightClick(String locator) {
        act = new Actions(driver);
        act.contextClick(findElement(locator))
                .perform();
    }

    public void sendKeyToElement(String locator, Keys key) {
        act = new Actions(driver);
        act.sendKeys(findElement(locator), key)
                .perform();
    }


    //JAVASCRIPT EXECUTOR
    public Object executeForBrowser(String js) {
        jsExec = (JavascriptExecutor) driver;
        return jsExec.executeScript(js);
    }

    public boolean verifyTextInInnerText(String expectedText) {
        jsExec = (JavascriptExecutor) driver;
        String actualText = (String) jsExec.executeScript("return " +
                "document.documentElement.innerText.match('" + expectedText + "')");
        return actualText.equals(expectedText);
    }

    public void scrollToBottomPage() {
        jsExec.executeScript("window.scrollBy(0,document.bodt.scrollHeight)");
    }

    public void clickByJs(String locator) {
        jsExec = (JavascriptExecutor) driver;
        WebElement e = findElement(locator);
        jsExec.executeScript("arguments[0].click();", e);
    }

    public void sendKeyByJs(String locator, String value) {
        jsExec = (JavascriptExecutor) driver;
        WebElement e = findElement(locator);
        jsExec.executeScript("arguments[0].setAttribute('value', '" + value + "');", e);
    }

    public void scrollToElement(String locator) {
        jsExec = (JavascriptExecutor) driver;
        WebElement e = findElement(locator);
        jsExec.executeScript("arguments[0].scrollIntoView(true):", e);
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        jsExec = (JavascriptExecutor) driver;
        WebElement e = findElement(locator);
        jsExec.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", e);
    }

    public boolean isImageLoaded(String locator) {
        jsExec = (JavascriptExecutor) driver;
        WebElement e = findElement(locator);
        boolean status = (Boolean) jsExec.executeScript
                ("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != \"undefined\" " +
                        "&& arguments[0].naturalWidth > 0", e);
        Boolean result = (status)? true: false;
        return result;
    }

    //WAIT
    public void waitForElementVisible(String locator) {
        explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitForElementInvisible(String locator) {
        explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitForElementClickable(String locator) {

    }






}
