package PreepDataAdd;

import Prepp_Login.LevelCreate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.CommonSelectorAdd;
import utils.FindCorrectLines;
import utils.QuestionAdd;

import java.util.List;

public class OrderTheSentenceAdd {

    private WebDriver driver;
    LevelCreate levelCreate;
    CommonSelectorAdd commonSelectorAdd;
    QuestionAdd questionAdd;
    FindCorrectLines findCorrectLines;


    public OrderTheSentenceAdd(WebDriver driver, String version, String OrderTheSentenceTextFilePath) throws InterruptedException {
        this.driver = driver;

        levelCreate = new LevelCreate(driver, 4);

        commonSelectorAdd = new CommonSelectorAdd(driver);
        findCorrectLines = new FindCorrectLines();

        commonSelectorAdd.setPracticeName(driver, "Order the Sentence");
        commonSelectorAdd.setPracticeDescription(driver, "Order the Sentence Description");
        commonSelectorAdd.setEditorNote(driver, version);
        int count = (findCorrectLines.countLines(OrderTheSentenceTextFilePath) / 2);

        questionAdd = new QuestionAdd(driver);

        for (int i = 1; i <= count; i++) {
            QuestionAdd.clickAddQuestionButton(driver);
            int wordCount = findCorrectLines.countSlashesInLine(OrderTheSentenceTextFilePath, (i * 2) + 1);
            int wordCount1 = wordCount;
            while (wordCount > 4) {

                questionAdd.clickAddOptionButton(driver, i);
                --wordCount;
            }
            int c = 1;
            while (wordCount1 > 0) {
                List<String> option = findCorrectLines.getWordsListFromLine(OrderTheSentenceTextFilePath, i * 2 + 1);
                questionAdd.setQuestionOption(driver, option.get(c - 1), i, c);
                System.out.println(i + ".question " + c + ".option " + option.get(c - 1));
                --wordCount1;
                ++c;

            }
        }
//        commonSelectorAdd.AddOptionButton.click();
        PageFactory.initElements(driver, this);
    }
}
