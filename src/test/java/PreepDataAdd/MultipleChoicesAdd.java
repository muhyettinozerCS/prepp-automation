package PreepDataAdd;

import Prepp_Login.LevelCreate;
import org.openqa.selenium.WebDriver;
import utils.CommonSelectorAdd;
import utils.FindCorrectLines;
import utils.QuestionAdd;


public class MultipleChoicesAdd {

    LevelCreate levelCreate;
    CommonSelectorAdd commonSelectorAdd;
    QuestionAdd questionAdd;
    FindCorrectLines findCorrectLines;

    public MultipleChoicesAdd(WebDriver driver, String version, String MultipleChoicesTextFilePath) throws InterruptedException {


        levelCreate = new LevelCreate(driver, 3);
        questionAdd = new QuestionAdd(driver);
        findCorrectLines = new FindCorrectLines();
        commonSelectorAdd = new CommonSelectorAdd(driver);
        Thread.sleep(1000); // 1 saniye bekle


        commonSelectorAdd.setPracticeName(driver, "Vocabulary - Multiple Choices");
        commonSelectorAdd.setPracticeDescription(driver, "Vocabulary - Multiple Choice Questions");
        commonSelectorAdd.setEditorNote(driver, version);
        findCorrectLines.addBlockNumbersToText(MultipleChoicesTextFilePath, 0);

        int count = (findCorrectLines.countLines(MultipleChoicesTextFilePath) + 5) / 6;

        for (int i = 1; i < count; i++) {
            QuestionAdd.clickAddQuestionButton(driver);

        }
        for (int i = 1; i < count; i++) {

            String Questions = questionAdd.QuestionAndOptionTextAfterPart(MultipleChoicesTextFilePath, i, ".");

            String optionA = questionAdd.QuestionAndOptionTextAfterPart(MultipleChoicesTextFilePath, i, "A)");
            String optionB = questionAdd.QuestionAndOptionTextAfterPart(MultipleChoicesTextFilePath, i, "B)");
            String optionC = questionAdd.QuestionAndOptionTextAfterPart(MultipleChoicesTextFilePath, i, "C)");
            String optionD = questionAdd.QuestionAndOptionTextAfterPart(MultipleChoicesTextFilePath, i, "D)");

            questionAdd.SetQuestionAdd(driver, Questions, i);
//input[@id='q-2-option-1']

            questionAdd.setQuestionOption(driver, optionA, i, 1);
            questionAdd.setQuestionOption(driver, optionB, i, 2);
            questionAdd.setQuestionOption(driver, optionC, i, 3);
            questionAdd.setQuestionOption(driver, optionD, i, 4);
            String answer = findCorrectLines.getAnswerFromLineNumber(findCorrectLines.findCorrectLine(MultipleChoicesTextFilePath, i));
            questionAdd.SetQuestionAnswer(driver, i, answer);


        }


    }
}
