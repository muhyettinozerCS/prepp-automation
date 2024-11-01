package Prepp_Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ExcelReader;

import java.time.Duration;


import static Test.PreppPractiseCreator.filePathExcel;


public class LevelCreate {
    private WebDriver driver;


    public static int LevelType = 4;
    public static int ChapterType = 2;

    @FindBy(xpath = "(//div[@class='v-field__input'])[1]")
    private WebElement selectLevelId;
    @FindBy(xpath = "(//div[@class='v-field__input'])[2]")
    private WebElement selectChapterId;
    @FindBy(xpath = "(//div[@class='v-field__input'])[3]")
    private WebElement selectPracticeId;

    public LevelCreate(WebDriver driver, int level) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        selectOptions(level);
    }

    private void selectOptions(int level) throws InterruptedException {
        selectAndClick(selectLevelId, getXpath(LevelType, 0));
        selectAndClick(selectChapterId, getXpath(ChapterType, 1));
        selectAndClick(selectPracticeId, getXpath(level, 2));
    }

    private void selectAndClick(WebElement element, String xpath) throws InterruptedException {
        element.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        Thread.sleep(500);
        driver.findElement(By.xpath(xpath)).click();
    }

    private String getXpath(int row, int col) {
        return "//div[contains(text(),'" + getValueFromExcel(row, col) + "')]";
    }

    public static String getName(int row, int col) {
        return getValueFromExcel(row, col);
    }

    private static String getValueFromExcel(int row, int col) {
        ExcelReader excelReader = new ExcelReader();
        return excelReader.getCellValue(filePathExcel, 0, row, col);
    }


}