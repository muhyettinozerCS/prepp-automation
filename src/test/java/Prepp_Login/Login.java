package Prepp_Login;

import Test.PreppPractiseCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Config;

import java.util.List;

public class Login {

    private WebDriver driver;
    public static final String MAIL = Config.getMail();
    public static final String PASSWORD = Config.getMailPassword();
    public static final String FilePathWords = Config.getFilePath();
    public static List<String> Keywords = Config.getKeyword();
    private static final Logger logger = LogManager.getLogger(Login.class);


    @FindBy(xpath = "//input[@id='input-0']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='input-2']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public Login(WebDriver driver) {
        logger.info("Testing Data Configuration...");

        this.driver = driver;
        String searchUrl = "https://test-prepp-admin.vercel.app/login";
        driver.get(searchUrl);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
        System.out.println("Login constructor running");
        performLogin();
    }

    private void performLogin() {
        emailInput.sendKeys(MAIL);
        passwordInput.sendKeys(PASSWORD);
        loginButton.click();
    }
}