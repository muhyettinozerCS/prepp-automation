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


    public OrderTheSentenceAdd(WebDriver driver, int version,String OrderTheSentenceTextFilePath) throws InterruptedException {
        this.driver = driver;

        levelCreate = new LevelCreate(driver, 3);
        CommonSelectorAdd.setPracticeName(driver, "Order the Sentence");
        CommonSelectorAdd.setPracticeDescription(driver, "Order the Sentence Description");
        CommonSelectorAdd.setEditorNote(driver, version);
        int count = (FindCorrectLines.countLines(OrderTheSentenceTextFilePath) / 2);
        System.out.println(count);

        for (int i = 1; i <= count; i++) {
            QuestionAdd.clickAddQuestionButton(driver);
            int wordCount = FindCorrectLines.countSlashesInLine(OrderTheSentenceTextFilePath, (i * 2) + 1);
            int wordCount1 = wordCount;
            System.out.println(wordCount);
            while (wordCount > 4) {

                QuestionAdd.clickAddOptionButton(driver, i);
                --wordCount;
            }
            int c = 1;
            while (wordCount1 > 0) {
                List<String> option = FindCorrectLines.getWordsListFromLine(OrderTheSentenceTextFilePath, i * 2 + 1);
                QuestionAdd.setQuestionOption(driver, option.get(c - 1), i, c);
                --wordCount1;
                ++c;

            }
        }

//        commonSelectorAdd.AddOptionButton.click();
        PageFactory.initElements(driver, this);
    }
}
