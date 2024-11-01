package PreepDataAdd;

import Prepp_Login.LevelCreate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.CommonSelectorAdd;

public class WritingAdd {
    private WebDriver driver;
    LevelCreate levelCreate;
    CommonSelectorAdd commonSelectorAdd;



    public WritingAdd(WebDriver driver,String version,String WritingTextFilePath) throws InterruptedException {
        this.driver = driver;
        levelCreate = new LevelCreate(driver,6);

        commonSelectorAdd.setPracticeName(driver,"Writing");
        commonSelectorAdd.setPracticeDescription(driver,"Writing");
        commonSelectorAdd.setEditorNote(driver,version);


        PageFactory.initElements(driver, this);
    }
}
