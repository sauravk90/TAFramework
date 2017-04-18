package main.java.testBase;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import main.java.pageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties Repository = new Properties();
    public File file;
    public FileInputStream fileInput;

    public void setUp() throws IOException {
        System.out.println(System.getProperty("user.dir"));
        loadPropertiesFile();
        initializeBrowser(Repository.getProperty("browser"));
        loginToFlipkart();
    }

    public void tearDown() {
        driver.quit();
    }

    public void loginToFlipkart(){
        driver.get(Repository.getProperty("url"));
        HomePage homeObj = new HomePage(driver);
        homeObj.loginText.click();
        homeObj.emailInput.sendKeys(Repository.getProperty("userName"));
        homeObj.passwordInput.sendKeys(Repository.getProperty("password"));
        homeObj.loginButton.click();
    }

    public void loadPropertiesFile() throws IOException {
        file = new File(System.getProperty("user.dir") + "//src//main//java//config//config.properties");
        fileInput = new FileInputStream(file);
        Repository.load(fileInput);
    }

    public void initializeBrowser(String driverType) {
        switch (DriverType.valueOf(driverType.toLowerCase())) {
            case chrome:
                initializeChrome();
                break;

            case firefox:
                initializeFireFox();
                break;

            case internetexplorer:
                initializeIE();
                break;

            default:
                initializeChrome();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private static void initializeChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saurav.kumar\\Desktop\\Site\\Drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("chrome.switches", "--disable-extensions");
        driver = new ChromeDriver(options);
    }

    private static void initializeFireFox() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\saurav.kumar\\Desktop\\Site\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    private static void initializeIE() {
        System.setProperty("webdriver.ie.driver", "C:\\Users\\saurav.kumar\\Desktop\\Site\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    public enum DriverType {
        internetexplorer,
        chrome,
        firefox
    }
}
