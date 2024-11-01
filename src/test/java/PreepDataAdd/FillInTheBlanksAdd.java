package PreepDataAdd;

import Prepp_Login.LevelCreate;
import org.openqa.selenium.WebDriver;
import utils.CommonSelectorAdd;

public class FillInTheBlanksAdd {

    private WebDriver driver;

    CommonSelectorAdd commonSelectorAdd;

    LevelCreate levelCreate;


    public FillInTheBlanksAdd(WebDriver driver) throws InterruptedException {


        levelCreate = new LevelCreate(driver, 2);
        commonSelectorAdd = new CommonSelectorAdd(driver);

        commonSelectorAdd.setPracticeName(driver, "Fill in the Blanks");
        commonSelectorAdd.setPracticeDescription(driver, " Fill in the Blanks-Description");
        commonSelectorAdd.setEditorNote(driver, "Test");
//        commonSelectorAdd.PracticeName.sendKeys("Test");
    }
}
