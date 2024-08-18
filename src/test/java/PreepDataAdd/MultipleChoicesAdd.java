package PreepDataAdd;

import Prepp_Login.LevelCreate;
import org.openqa.selenium.WebDriver;
import utils.CommonSelectorAdd;
import utils.FindCorrectLines;
import utils.QuestionAdd;

public class MultipleChoicesAdd {

    LevelCreate levelCreate;

    public MultipleChoicesAdd(WebDriver driver,int version,String MultipleChoicesTextFilePath) throws InterruptedException {


        levelCreate = new LevelCreate(driver,2);
        Thread.sleep(1000); // 1 saniye bekle



        CommonSelectorAdd.setPracticeName(driver,"Vocabulary - Multiple Choices");
        CommonSelectorAdd.setPracticeDescription(driver,"Vocabulary - Multiple Choice Questions");
        CommonSelectorAdd.setEditorNote(driver,version);
        FindCorrectLines.addBlockNumbersToText(MultipleChoicesTextFilePath,0);

        int count=(FindCorrectLines.countLines(MultipleChoicesTextFilePath)+5)/6;

        for (int i = 1; i < count; i++) {
            QuestionAdd.clickAddQuestionButton(driver);

        }
        for (int i = 1; i < count; i++) {

            String Questions = QuestionAdd.QuestionAndOptionTextAfterPart(MultipleChoicesTextFilePath,i,".");

            String optionA = QuestionAdd.QuestionAndOptionTextAfterPart(MultipleChoicesTextFilePath,i,"A)");
            String optionB = QuestionAdd.QuestionAndOptionTextAfterPart(MultipleChoicesTextFilePath,i,"B)");
            String optionC = QuestionAdd.QuestionAndOptionTextAfterPart(MultipleChoicesTextFilePath,i,"C)");
            String optionD = QuestionAdd.QuestionAndOptionTextAfterPart(MultipleChoicesTextFilePath,i,"D)");

            QuestionAdd.SetQuestionAdd(driver, Questions,i);
//input[@id='q-2-option-1']

            QuestionAdd.setQuestionOption(driver, optionA,i,1);
            QuestionAdd.setQuestionOption(driver, optionB,i,2);
            QuestionAdd.setQuestionOption(driver, optionC,i,3);
            QuestionAdd.setQuestionOption(driver, optionD,i,4);
            String answer = FindCorrectLines.getAnswerFromLineNumber(FindCorrectLines.findCorrectLine(MultipleChoicesTextFilePath, i));
            QuestionAdd.SetQuestionAnswer(driver,i,answer);


        }


    }
}
