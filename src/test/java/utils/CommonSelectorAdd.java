package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonSelectorAdd {

    private static WebDriver driver;


    @FindBy(xpath = "//div[@class='ql-editor ql-blank']")
    private WebElement practiceTextOptions;
    private static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

    @FindBy(xpath = "//span[normalize-space()='Remove All Qs']")
    public WebElement RemoveAllQs;
    @FindBy(xpath = "//span[normalize-space()='Add Option']")
    public WebElement AddOptionButton;
    @FindBy(xpath = "//span[normalize-space()='Remove Question']")
    public WebElement RemoveQuestionButton;

    public static final String prefix = "//input[@id='";
    public static final String suffix = "']";

    public CommonSelectorAdd(WebDriver driver) {
        this.driver = driver;


        PageFactory.initElements(driver, this);
    }

    public  void setPracticeName(WebDriver driver, String practiceName) {

        String practiceXpath = generatePracticeXpath(    "practice-name");
        System.out.println(practiceName);

        driver.findElement(By.xpath(practiceXpath)).sendKeys(practiceName);


    }
    //input[@id='practice-desc']
    public  void setPracticeDescription(WebDriver driver, String practiceDescription) {
        String practiceXpath = generatePracticeXpath("practice-desc");
        driver.findElement(By.xpath(practiceXpath)).sendKeys(practiceDescription);
    }
    //input[@id='editor-note']
    public  void setEditorNote(WebDriver driver, String editorNote) {
        String practiceXpath = generatePracticeXpath("editor-note");
        driver.findElement(By.xpath(practiceXpath)).sendKeys(editorNote + "");

    }


    public  void setPracticeTextOption(WebDriver driver, String practiceText) {
//        driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys(practiceTextOption);
        practiceTextOptions.sendKeys(practiceText);

    }

    public static String generatePracticeXpath(String PracticeXpathValue) {
        return prefix + PracticeXpathValue + suffix;
    }


}
