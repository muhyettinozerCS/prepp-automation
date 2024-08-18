package PreepDataAdd;

import Prepp_Login.LevelCreate;
import org.openqa.selenium.WebDriver;
import utils.CommonSelectorAdd;

public class FillInTheBlanksAdd {

    private WebDriver driver;

    CommonSelectorAdd commonSelectorAdd = new CommonSelectorAdd(driver);

    LevelCreate levelCreate;



    public FillInTheBlanksAdd(WebDriver driver) throws InterruptedException {


        levelCreate = new LevelCreate(driver, 1);

//        commonSelectorAdd.PracticeDescription.sendKeys("Test");
//        commonSelectorAdd.PracticeTextOption.sendKeys("Test");
//        commonSelectorAdd.EditorNote.sendKeys("Test");
//        commonSelectorAdd.PracticeName.sendKeys("Test");
    }
}
