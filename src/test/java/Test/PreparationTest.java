package Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class PreparationTest {

    private WebDriver driver;
    PreppPractiseCreator preppPractiseCreator;




    @Test
    public void TestCreateAll() throws InterruptedException, AWTException {

        preppPractiseCreator = new PreppPractiseCreator();
        preppPractiseCreator.TestDataConfigure();

        preppPractiseCreator.TestHomePageLogin();
        preppPractiseCreator.TestCreateClozeTest();

        preppPractiseCreator.TestHomePageLogin();
        preppPractiseCreator.TestCreateOrderTheSentence();

        preppPractiseCreator.TestHomePageLogin();
        preppPractiseCreator.TestCreateReading();

        preppPractiseCreator.TestHomePageLogin();
        preppPractiseCreator.TestCreateMultipleChoice();

    }
}