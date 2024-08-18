package PreepDataAdd;

import Prepp_Login.LevelCreate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonSelectorAdd;
import utils.FindCorrectLines;
import utils.QuestionAdd;

import java.util.List;

public class ReadingAdd {

    LevelCreate levelCreate;

    public ReadingAdd(WebDriver driver,int version,String ReadingTextFilePath) throws InterruptedException {
        levelCreate = new LevelCreate(driver, 4);
        Thread.sleep(1000); // 1 saniye bekle

        CommonSelectorAdd.setPracticeName(driver,"Reading");
        CommonSelectorAdd.setPracticeDescription(driver,"Reading Description");
        CommonSelectorAdd.setEditorNote(driver,version);


        List<String> lines = FindCorrectLines.getSpecificLines(ReadingTextFilePath,2,3);
        driver.findElement(By.xpath("//button[@class='ql-bold']//*[name()='svg']\n")).click();

        CommonSelectorAdd.setPracticeTextOption(driver,lines.get(0)+"\n");
        driver.findElement(By.xpath("//button[@class='ql-bold ql-active']//*[name()='svg']\n")).click();



        driver.findElement(By.xpath("//div[@class='ql-editor']")).sendKeys(lines.get(1));
//        WebElement wordElement = driver.findElement(By.xpath("//*[contains(text(),'profound')]"));
//        wordElement.click();
//        driver.findElement(By.xpath("//button[@class='ql-bold']//*[name()='svg']\n")).click();


//
//        CommonSelectorAdd.setPracticeTextOption(driver,lines.get(1));

        FindCorrectLines.addBlockNumbersToText(ReadingTextFilePath,4);

        int count=(FindCorrectLines.countLines(ReadingTextFilePath)+3)/6;
        System.out.println(count);

        for (int i = 1; i < count; i++) {
            QuestionAdd.clickAddQuestionButton(driver);

        }
        for (int i = 1; i < count; i++) {

            String Questions = QuestionAdd.QuestionAndOptionTextAfterPart(ReadingTextFilePath,i,".");

            String optionA = QuestionAdd.QuestionAndOptionTextAfterPart(ReadingTextFilePath,i,"A)");
            String optionB = QuestionAdd.QuestionAndOptionTextAfterPart(ReadingTextFilePath,i,"B)");
            String optionC = QuestionAdd.QuestionAndOptionTextAfterPart(ReadingTextFilePath,i,"C)");
            String optionD = QuestionAdd.QuestionAndOptionTextAfterPart(ReadingTextFilePath,i,"D)");

            QuestionAdd.SetQuestionAdd(driver, Questions,i);
//input[@id='q-2-option-1']

            QuestionAdd.setQuestionOption(driver, optionA,i,1);
            QuestionAdd.setQuestionOption(driver, optionB,i,2);
            QuestionAdd.setQuestionOption(driver, optionC,i,3);
            QuestionAdd.setQuestionOption(driver, optionD,i,4);
            String answer = FindCorrectLines.getAnswerFromLineNumber(FindCorrectLines.findCorrectLine(ReadingTextFilePath, i)-2);
            QuestionAdd.SetQuestionAnswer(driver,i,answer);


        }


        PageFactory.initElements(driver, this);
    }
}
