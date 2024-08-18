package PreepDataAdd;

import Prepp_Login.LevelCreate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.CommonSelectorAdd;

public class WritingAdd {

    private WebDriver driver;
    LevelCreate levelCreate;

   CommonSelectorAdd commonSelectorAdd = new CommonSelectorAdd(driver);



    public WritingAdd(WebDriver driver) throws InterruptedException {
        this.driver = driver;

        levelCreate = new LevelCreate(driver,5);
        CommonSelectorAdd.setPracticeName(driver,"Writing");
        CommonSelectorAdd.setPracticeDescription(driver,"Writing");
        CommonSelectorAdd.setEditorNote(driver,1);


        PageFactory.initElements(driver, this);
    }
}
