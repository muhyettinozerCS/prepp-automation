package Prepp_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Practise {

    private WebDriver driver;

    @FindBy(id = "v-list-group--id-Practise")
    private WebElement practiseId;

    @FindBy(xpath = "//a[@href='/list-practice']")
    private WebElement listId;

    @FindBy(xpath = "//a[@href='/create-practice']")
    private WebElement createId;

    public Practise(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setPractise() {
        practiseClick();
        System.out.println("Practise section accessed");
        createClick();
    }

    private void practiseClick() {
        practiseId.click();
    }

    private void createClick() {
        createId.click();
    }

    public void listClick() {
        listId.click();
    }
}