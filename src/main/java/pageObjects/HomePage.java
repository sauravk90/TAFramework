package main.java.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Log In')]")
    public WebElement loginText;

    @FindBy(xpath = "//input[@class='_2zrpKA']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@class='_2zrpKA _3v41xv']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@class='_2AkmmA _1LctnI _7UHT_c']")
    public WebElement loginButton;

}
