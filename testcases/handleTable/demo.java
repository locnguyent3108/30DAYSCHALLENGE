package handleTable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class demo {
    WebDriver driver;
    jqueryPageObjects dataTable;
//    DriverManager driverBrowser;
//    @Parameters("browser")
    @BeforeClass
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        dataTable = new jqueryPageObjects(driver);
    }

    @Test
    public void demoTest() {
        System.out.printf("hell no");
        dataTable.selectCountryAtRow( 2, "Malaysia");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
