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
    private WebElement PracticeTextOption;
    private static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

    @FindBy(xpath = "//span[normalize-space()='Remove All Qs']")
    public WebElement RemoveAllQs;
    @FindBy(xpath = "//span[normalize-space()='Add Option']")
    public WebElement AddOptionButton;
    @FindBy(xpath = "//span[normalize-space()='Remove Question']")
    public WebElement RemoveQuestionButton;
    @FindBy(xpath = "//input[@id='input-107']")
    public WebElement Question1;
    @FindBy(xpath = "//input[@id='input-112']")
    public WebElement Option1;
    @FindBy(xpath = "//input[@id='input-118']")
    public WebElement Option2;
    @FindBy(xpath = "//input[@id='input-124']")
    public WebElement Option3;
    @FindBy(xpath = "//input[@id='input-130']")
    public WebElement Option4;
    public static final String prefix = "//input[@id='";
    public static final String suffix = "']";

    public CommonSelectorAdd(WebDriver driver) {
        this.driver = driver;


        PageFactory.initElements(driver, this);
    }

    public static void setPracticeName(WebDriver driver, String practiceName) {


        String practiceXpath = generatePracticeXpath(    "practice-name");
        System.out.println(practiceXpath);

        driver.findElement(By.xpath(practiceXpath)).sendKeys(practiceName);


    }
    //input[@id='practice-desc']
    public static void setPracticeDescription(WebDriver driver, String practiceDescription) {
        String practiceXpath = generatePracticeXpath("practice-desc");
        driver.findElement(By.xpath(practiceXpath)).sendKeys(practiceDescription);
    }
    //input[@id='editor-note']
    public static void setEditorNote(WebDriver driver, float editorNote) {
        String practiceXpath = generatePracticeXpath("editor-note");
        driver.findElement(By.xpath(practiceXpath)).sendKeys(editorNote + "");

    }


    public static void setPracticeTextOption(WebDriver driver, String practiceTextOption) {
        driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys(practiceTextOption);

    }

    public static String generatePracticeXpath(String Value) {
        return prefix + Value + suffix;
    }


}
