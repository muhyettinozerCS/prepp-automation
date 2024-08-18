package PreepDataDel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WritingDel {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='input-99']")
    private WebElement PracticeName;
    @FindBy(xpath = "//input[@id='input-101']")
    private WebElement PracticeDescription;
    @FindBy(xpath = "//input[@id='input-103']")
    private WebElement EditorNote;
    @FindBy(xpath = "//div[@class='ql-editor ql-blank']")
    private WebElement PracticeTextOption;
    @FindBy(xpath = "//span[normalize-space()='Add Question']")
    private WebElement AddQuestionButton;
    @FindBy(xpath = "//span[normalize-space()='Remove All Qs']")
    private WebElement RemoveAllQs;
    @FindBy(xpath = "//span[normalize-space()='Add Option']")
    private WebElement AddOptionButton;
    @FindBy(xpath = "//span[normalize-space()='Remove Question']")
    private WebElement RemoveQuestionButton;
    @FindBy(xpath = "//input[@id='input-107']")
    private WebElement Question1;

    @FindBy(xpath = "//input[@id='input-112']")
    private WebElement Option1;
    @FindBy(xpath = "//input[@id='input-118']")
    private WebElement Option2;
    @FindBy(xpath = "//input[@id='input-124']")
    private WebElement Option3;
    @FindBy(xpath = "//input[@id='input-130']")
    private WebElement Option4;


    public WritingDel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
