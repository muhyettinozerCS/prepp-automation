package PreepDataAdd;

import Prepp_Login.LevelCreate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.CommonSelectorAdd;
import utils.FindCorrectLines;
import utils.QuestionAdd;

import java.util.List;


public class ReadingAdd {
    LevelCreate levelCreate;
    QuestionAdd questionAdd;
    CommonSelectorAdd commonSelectorAdd;
    FindCorrectLines findCorrectLines;
    public ReadingAdd(WebDriver driver, String version, String ReadingTextFilePath) throws InterruptedException {
        levelCreate = new LevelCreate(driver, 5);
        questionAdd =new QuestionAdd(driver);

        Thread.sleep(1000); // 1 saniye bekle

        commonSelectorAdd = new CommonSelectorAdd(driver);

        commonSelectorAdd.setPracticeName(driver, "Reading");
        commonSelectorAdd.setPracticeDescription(driver, "Reading Description");
        commonSelectorAdd.setEditorNote(driver, version);
        findCorrectLines = new FindCorrectLines();

        List<String> lines = findCorrectLines.getSpecificLines(ReadingTextFilePath, 2, 3);
        driver.findElement(By.xpath("//button[@class='ql-bold']//*[name()='svg']\n")).click();

        
        commonSelectorAdd.setPracticeTextOption(driver, lines.get(0) + "\n");
        driver.findElement(By.xpath("//button[@class='ql-bold ql-active']//*[name()='svg']\n")).click();

        driver.findElement(By.xpath("//div[@class='ql-editor']")).sendKeys(lines.get(1));

        findCorrectLines.addBlockNumbersToText(ReadingTextFilePath, 4);

        int count = (findCorrectLines.countLines(ReadingTextFilePath) + 3) / 6;
        System.out.println(count);

        for (int i = 1; i < count; i++) {
            QuestionAdd.clickAddQuestionButton(driver);

        }
        for (int i = 1; i < count; i++) {

            String Questions = questionAdd.QuestionAndOptionTextAfterPart(ReadingTextFilePath, i, ".");
            questionAdd.SetQuestionAdd(driver, Questions, i);

            questionAdd.setQuestionOption(driver, questionAdd.QuestionAndOptionTextAfterPart(ReadingTextFilePath, i, "A)"), i, 1);
            questionAdd.setQuestionOption(driver, questionAdd.QuestionAndOptionTextAfterPart(ReadingTextFilePath, i, "B)"), i, 2);
            questionAdd.setQuestionOption(driver, questionAdd.QuestionAndOptionTextAfterPart(ReadingTextFilePath, i, "C)"), i, 3);
            questionAdd.setQuestionOption(driver, questionAdd.QuestionAndOptionTextAfterPart(ReadingTextFilePath, i, "D)"), i, 4);

            String answer = findCorrectLines.getAnswerFromLineNumber(findCorrectLines.findCorrectLine(ReadingTextFilePath, i) - 2);
            questionAdd.SetQuestionAnswer(driver, i, answer);
        }
        PageFactory.initElements(driver, this);
    }
}
