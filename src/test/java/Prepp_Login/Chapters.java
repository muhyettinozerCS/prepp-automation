package Prepp_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Chapters {

    private WebDriver driver;

    @FindBy(xpath = " //a[@href='/chapter']")
    private WebElement chapterID;

    public Chapters(WebDriver driver) {
        System.out.println("Chapters constructor running");
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }


    public void chapterClick() {
        chapterID.click();
    }
}
