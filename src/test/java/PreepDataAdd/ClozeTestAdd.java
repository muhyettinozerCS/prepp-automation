package PreepDataAdd;

import Prepp_Login.LevelCreate;
import org.openqa.selenium.WebDriver;
import utils.CommonSelectorAdd;
import utils.FindCorrectLines;
import utils.QuestionAdd;

import java.util.List;

public class ClozeTestAdd {

    private WebDriver driver;
    LevelCreate levelCreate;

    public ClozeTestAdd(WebDriver driver, int version,String OrderTheSentenceTextFilePath) throws InterruptedException {



        levelCreate = new LevelCreate(driver, 0);

        CommonSelectorAdd.setPracticeName(driver,"Cloze Test");
        CommonSelectorAdd.setPracticeDescription(driver,"Cloze Test Description");
        CommonSelectorAdd.setEditorNote(driver,version);
        List<String> lines = FindCorrectLines.getSpecificLines(OrderTheSentenceTextFilePath,2,3);
        CommonSelectorAdd.setPracticeTextOption(driver,lines.get(0)+"\n");

        FindCorrectLines.addBlockNumbersToText(OrderTheSentenceTextFilePath,5);
        int count=(FindCorrectLines.countLines(OrderTheSentenceTextFilePath)+4)/6;
        System.out.println(count);
        for (int i = 1; i < count; i++) {
            QuestionAdd.clickAddQuestionButton(driver);
        }
        for (int i = 1; i < count; i++) {


            String optionA = QuestionAdd.QuestionAndOptionTextAfterPart(OrderTheSentenceTextFilePath,i,"A)");
            String optionB = QuestionAdd.QuestionAndOptionTextAfterPart(OrderTheSentenceTextFilePath,i,"B)");
            String optionC = QuestionAdd.QuestionAndOptionTextAfterPart(OrderTheSentenceTextFilePath,i,"C)");
            String optionD = QuestionAdd.QuestionAndOptionTextAfterPart(OrderTheSentenceTextFilePath,i,"D)");

            QuestionAdd.setQuestionOption(driver, optionA,i,1);
            QuestionAdd.setQuestionOption(driver, optionB,i,2);
            QuestionAdd.setQuestionOption(driver, optionC,i,3);
            QuestionAdd.setQuestionOption(driver, optionD,i,4);
            String answer = FindCorrectLines.getAnswerFromLineNumber(FindCorrectLines.findCorrectLine(OrderTheSentenceTextFilePath, i)-1);
            QuestionAdd.SetQuestionAnswer(driver,i,answer);


        }



    }
}
