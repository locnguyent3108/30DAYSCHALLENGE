package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AbstractTest {
    WebDriver driver;
//    public WebDriver getBrowserDriver(String browserName) {
//        if (browserName.equals("Chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        } else if(browserName.equals("Firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        } else {
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        }
//        return driver;
//    }


}
