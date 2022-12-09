package ngan.xd.Common;

import io.github.bonigarcia.wdm.WebDriverManager;
import ngan.xd.Listeners.TestListeners;
import ngan.xd.Pages.CommonPage;
import ngan.xd.driver.DriverManager;
import ngan.xd.helpers.CaptureHelpers;
import ngan.xd.helpers.PropertiesHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

@Listeners(TestListeners.class)
public class BaseTest extends CommonPage {

    //    public static WebDriver driver;
    public BaseTest() {
        PropertiesHelper.loadAllFiles();
    }

    @BeforeMethod
    @Parameters({"browser"})
    public static void createDriver(@Optional("chrome") String browser, ITestResult result) throws Exception {
        WebDriver driver = setupDriver(browser);
        DriverManager.setDriver(driver);
        CaptureHelpers.startRecord(result.getName());

    }

    public static WebDriver setupDriver(String browserName) {
        WebDriver driver;
        System.out.println(browserName.trim().toLowerCase());
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    private static WebDriver initChromeDriver() {
        WebDriver driver;
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initEdgeDriver() {
        WebDriver driver;
        System.out.println("Launching Edge browser...");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        WebDriver driver;
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public static void closeDriver(ITestResult result) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
        try {
            CaptureHelpers.stopRecord();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}