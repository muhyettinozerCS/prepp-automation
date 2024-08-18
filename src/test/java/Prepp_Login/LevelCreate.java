package Prepp_Login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ExcelReader;




import java.time.Duration;

import static Test.PreparationTest.filePath;

public class LevelCreate {
    private WebDriver driver;


int ChapterType = 0;
int LevelType = 3;



    @FindBy(xpath = "(//div[@class='v-field__input'])[1]")
    private WebElement selectLevelId;
    @FindBy(xpath = "(//div[@class='v-field__input'])[2]")
    private WebElement selectChapterId;
    @FindBy(xpath = "(//div[@class='v-field__input'])[3]")
    private WebElement selectPracticeId;


    public LevelCreate(WebDriver driver, int level) throws InterruptedException {
        System.out.println("LevelCreate constructor running");
        this.driver = driver;
        PageFactory.initElements(driver, this);
        System.out.println("create constructor running");
        selectLevel(level);

    }

    public void selectLevel(int level) throws InterruptedException {
        String levelXpath = levelChoice(LevelType);
        String chapterXpath = chapterChoice(ChapterType);
        String practiceXpath = practiceChoice(level);

        selectLevel(selectLevelId);
        System.out.println(levelXpath);

        selectChapter(selectChapterId);
        System.out.println(chapterXpath);
        PageFactory.initElements(driver, this);

        selectPractice(selectPracticeId, level);

        System.out.println(practiceXpath);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));




    }


    public void selectLevel(WebElement selectLevelId) throws InterruptedException {
        selectLevelId.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        Thread.sleep(500); // 1 saniye bekle


        String levelXpath = levelChoice(LevelType);
        driver.findElement(By.xpath(levelXpath)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

    }

    public void selectChapter(WebElement selectChapterId) throws InterruptedException {

        selectChapterId.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(500); // 3 saniye bekle

        String chapterXpath = chapterChoice(ChapterType);
        driver.findElement(By.xpath(chapterXpath)).click();

    }

    public void selectPractice(WebElement selectPracticeId, int level) throws InterruptedException {

        selectPracticeId.click();
        Thread.sleep(1000); //  saniye bekle
        String practiceXpath = practiceChoice(level);
        driver.findElement(By.xpath(practiceXpath)).click();


    }

    public  static String levelChoice(int LevelType) {
        ExcelReader excelReader = new ExcelReader();

        String searchValue = excelReader.getCellValue(filePath, 0, LevelType, 0); // b2
        String containsLevel = "//div[contains(text(),'";
        String containsLevelAfter = "')]";

        return containsLevel + searchValue + containsLevelAfter;
    }

    public String chapterChoice(int chapterType) {
        ExcelReader excelReader = new ExcelReader();

        String searchValue = excelReader.getCellValue(filePath, 0, chapterType, 1); // simple present
        String containsLevel = "//div[contains(text(),'";
        String containsLevelAfter = "')]";

        return containsLevel + searchValue + containsLevelAfter;
    }

    public String practiceChoice(int practiceType) {
        ExcelReader excelReader = new ExcelReader();

//    @FindBy(xpath = "//div[contains(text(),'Order the Sentence')]")
//    private WebElement OrderTheSentence;

        String searchValue = excelReader.getCellValue(filePath, 0, practiceType, 2); // multiple choices
        String containsLevel = "//div[contains(text(),'";
        String containsLevelAfter = "')]";

        return containsLevel + searchValue + containsLevelAfter;
    }


}
