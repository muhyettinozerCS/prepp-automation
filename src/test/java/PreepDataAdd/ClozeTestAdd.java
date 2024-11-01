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
    CommonSelectorAdd commonSelectorAdd;
    QuestionAdd questionAdd;
    FindCorrectLines findCorrectLines;

    public ClozeTestAdd(WebDriver driver, String version, String OrderTheSentenceTextFilePath) throws InterruptedException {


        levelCreate = new LevelCreate(driver, 1);
        commonSelectorAdd = new CommonSelectorAdd(driver);
        questionAdd = new QuestionAdd(driver);
        findCorrectLines = new FindCorrectLines();

        commonSelectorAdd.setPracticeName(driver, "Cloze Test");
        commonSelectorAdd.setPracticeDescription(driver, "Cloze Test Description");
        commonSelectorAdd.setEditorNote(driver, version);
        List<String> lines = findCorrectLines.getSpecificLines(OrderTheSentenceTextFilePath, 2, 3);
        commonSelectorAdd.setPracticeTextOption(driver, lines.get(0) + "\n");

        findCorrectLines.addBlockNumbersToText(OrderTheSentenceTextFilePath, 5);
        int count = (findCorrectLines.countLines(OrderTheSentenceTextFilePath) + 4) / 6;
        System.out.println(count);
        for (int i = 1; i < count; i++) {
            QuestionAdd.clickAddQuestionButton(driver);
        }
        for (int i = 1; i < count; i++) {


            String optionA = questionAdd.QuestionAndOptionTextAfterPart(OrderTheSentenceTextFilePath, i, "A)");
            String optionB = questionAdd.QuestionAndOptionTextAfterPart(OrderTheSentenceTextFilePath, i, "B)");
            String optionC = questionAdd.QuestionAndOptionTextAfterPart(OrderTheSentenceTextFilePath, i, "C)");
            String optionD = questionAdd.QuestionAndOptionTextAfterPart(OrderTheSentenceTextFilePath, i, "D)");

            questionAdd.setQuestionOption(driver, optionA, i, 1);
            questionAdd.setQuestionOption(driver, optionB, i, 2);
            questionAdd.setQuestionOption(driver, optionC, i, 3);
            questionAdd.setQuestionOption(driver, optionD, i, 4);
            String answer = findCorrectLines.getAnswerFromLineNumber(findCorrectLines.findCorrectLine(OrderTheSentenceTextFilePath, i) - 1);
            questionAdd.SetQuestionAnswer(driver, i, answer);


        }


    }
}
