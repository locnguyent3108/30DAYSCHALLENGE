package browserFactory;

public class BrowserFactory {
    public static DriverManager getInstance(String browserName) {
        DriverManager driverManager;
        switch (browserName) {
            case "CHROME":
                driverManager = new ChromeDriverManager();
                break;
            case "HEADLESS":
                driverManager = new ChromeHeadlessDriver();
                break;
            case "FIREFOX":
                driverManager = new FirefoxDriverManager();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browserName);
        }
        return driverManager;
    }
}
