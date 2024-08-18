package Prepp_Login;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Practise {

    public WebDriver driver;

    @FindBy(id = "v-list-group--id-Practise")
    private WebElement practiseId;
    @FindBy(xpath = "//a[@href='/list-practice']")
   private WebElement listId;
    @FindBy(xpath = "//a[@href='/create-practice']")
    private WebElement createId;


    public Practise(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        practiseClick();
        System.out.println("practise constructor running");

//        PageFactory.initElements(driver, this);
//        listClick();
//        System.out.println("list constructor running");
        PageFactory.initElements(driver, this);
        createClick();
        PageFactory.initElements(driver, this);



    }


    public void practiseClick() {
        practiseId.click();
    }
    public void createClick() {
        createId.click();
    }
    public void listClick() {
        listId.click();
    }



}
