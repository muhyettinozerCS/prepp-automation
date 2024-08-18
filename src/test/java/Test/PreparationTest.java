package Test;

import PreepDataAdd.*;
import Prepp_Login.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonSelectorAdd;
import utils.WordReader;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PreparationTest {
    public static String filePath = "src/resources/test-data.xlsx";

    private static final Logger logger = LogManager.getLogger(PreparationTest.class);
    WebDriver driver;

    LevelCreate levelCreate;
    MultipleChoicesAdd multipleChoicesAdd;
    ReadingAdd readingAdd;
    WritingAdd writingAdd;
    ClozeTestAdd clozeTestAdd;
    OrderTheSentenceAdd orderTheSentenceAdd;
    FillInTheBlanksAdd fillInTheBlanksAdd;
    CommonSelectorAdd commonSelectorAdd;
    Chapters chapters;
    Login login;
    WordReader wordReader;
    Practise practise;
    WebDriverWait wait;


    @Before
    public void TestHomePageLogin() {
        driver = new ChromeDriver();

        System.out.println("home driver: " + driver);
        System.out.println("login driver: " + driver);
        logger.info(">>>>>Starting search test...");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        login = new Login(driver);

    }

    @Test
    public void TestPractise() throws InterruptedException {

        logger.info(">>>>>Starting search test...");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        practise = new Practise(driver);

    }

    @Test
    public void TestChapters() throws InterruptedException {
        logger.info(">>>>>Starting search test...");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        chapters = new Chapters(driver);
    }

    @Test
    public void TestCreateClozeTest() throws InterruptedException {
        logger.info(">>>>>Starting search test...");
        TestPractise();
        clozeTestAdd = new ClozeTestAdd(driver, 1, "Grammar-ClozeTest-1.txt");

        TestHomePageLogin();
        TestPractise();
        clozeTestAdd = new ClozeTestAdd(driver, 2, "Vocabulary-ClozeTest-1.txt");
//        TestHomePageLogin();
//        TestPractise();
//        clozeTestAdd = new ClozeTestAdd(driver, 3, "Continuous3ClozeTest.txt");
    }

    @Test
    public void TestCreateFillInTheBlanks() throws InterruptedException {
        logger.info(">>>>>Starting search test...");
        TestPractise();
        fillInTheBlanksAdd = new FillInTheBlanksAdd(driver);
    }

    @Test
    public void TestCreateMultipleChoice() throws InterruptedException, AWTException {

        logger.info(">>>>>Starting search test...");
        TestPractise();
        multipleChoicesAdd = new MultipleChoicesAdd(driver, 1, "Vocabulary-MultipleChoices-1.txt");
        TestHomePageLogin();
        TestPractise();
        multipleChoicesAdd = new MultipleChoicesAdd(driver, 2, "Grammar-MultipleChoices-1.txt");
        TestHomePageLogin();
        TestPractise();
        multipleChoicesAdd = new MultipleChoicesAdd(driver, 3, "Grammar-MultipleChoices-2.txt");
//        driver.quit();
    }

    @Test
    public void TestCreateOrderTheSentence() throws InterruptedException {
        logger.info(">>>>>Starting search test...");
        TestPractise();
        orderTheSentenceAdd = new OrderTheSentenceAdd(driver, 1, "OrdertheSentence.txt");
//        TestPractise();
//        orderTheSentenceAdd = new OrderTheSentenceAdd(driver,2,"Continuous2OrderTheSentence.txt");
    }

    @Test
    public void TestCreateReading() throws InterruptedException {

        logger.info(">>>>>Starting search test...");
        TestPractise();
        readingAdd = new ReadingAdd(driver, 1, "Vocabulary-Reading-1.txt");
//        driver.quit();
    }

    @Test
    public void TestCreateGeneral() throws InterruptedException, AWTException {

        String filePath = "src/resources/5. Narrative Tenses.docx";
        List<String> keywords = Arrays.asList(
                "Vocabulary-Reading-1", "Vocabulary-MultipleChoices-1", "Vocabulary-ClozeTest-1",
                "Grammar-MultipleChoices-1", "Grammar-MultipleChoices-2", "Grammar-ClozeTest-1",
                "OrdertheSentence"
        );

        wordReader.processWordDocument(filePath, keywords);

        TestCreateMultipleChoice();

        TestHomePageLogin();
        TestCreateOrderTheSentence();

        TestHomePageLogin();
        TestCreateReading();

        TestHomePageLogin();
        TestCreateClozeTest();

    }


}