package test.java.testScripts;

import main.java.customListeners.Retry;
import main.java.testBase.TestBase;
import main.java.testUtills.Utills;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePage  extends TestBase {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws IOException {
       super.setUp();
    }

    @Test(retryAnalyzer = Retry.class)
    public void login() throws IOException {
    Utills.takeScreenshot("homepage");

    }

    @AfterClass
    public void tearDown() {
         super.tearDown();
    }

}
