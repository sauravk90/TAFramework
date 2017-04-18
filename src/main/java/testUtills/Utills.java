package main.java.testUtills;
import main.java.testBase.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import static main.java.testBase.TestBase.driver;

public class Utills extends TestBase {

    public static void takeScreenshot(String fileName) throws IOException {
        String userDirectory = System.getProperty("user.dir");
        String customeLocation = "//src//test//java//screenshots//";
        String failureImageFileName = userDirectory + customeLocation
                + new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + "-" + fileName
                + ".png";

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(failureImageFileName));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
