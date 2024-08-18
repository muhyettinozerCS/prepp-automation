package Prepp_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Config;

public class Login {

    private WebDriver driver;
    public static final String MAIL = Config.getMail();
    public static final String PASSWORD = Config.getMailPassword();
    @FindBy(xpath = "//input[@id='input-0']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@id='input-2']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;


    public Login(WebDriver driver) {

        System.out.println("HomePage  running");
        String searchUrl = "https://test-prepp-admin.vercel.app/login";
        driver.get(searchUrl);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
        System.out.println("Login constructor running");

        emailInput.sendKeys(MAIL);
        passwordInput.sendKeys(PASSWORD);
        loginButton.click();

        PageFactory.initElements(driver, this);
    }
}
