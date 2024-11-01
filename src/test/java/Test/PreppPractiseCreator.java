package Test;

import PreepDataAdd.*;
import Prepp_Login.Chapters;
import Prepp_Login.LevelCreate;
import Prepp_Login.Login;
import Prepp_Login.Practise;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonSelectorAdd;
import utils.WordReader;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static Prepp_Login.Login.FilePathWords;
import static Prepp_Login.Login.Keywords;


public class PreppPractiseCreator {
    public static String filePathExcel = "src/resources/test-data.xlsx";

    private static final Logger logger = LogManager.getLogger(PreppPractiseCreator.class);
    WebDriver driver;


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
    PreparationTest preparationTest;

    static int practiceNumber = 1;
    static int LCT = LevelCreate.LevelType;
    static int CCT = LevelCreate.ChapterType;

    static int getPracticeNumber() {
        return practiceNumber;
    }

    private static void incrementVersionNumber() {
        logger.trace("Incrementing version number..."+practiceNumber);
        practiceNumber = practiceNumber + 1;
    }


    static String version = LCT + "_" + CCT + "_";
    //   String levelName = LevelCreate.levelChoice(LCT);
//    String chapterXpath = LevelCreate.chapterChoice(CCT);
    public String getVersionLevelName = LevelCreate.getName(LCT, 0);
    public String getVersionChapterName = LevelCreate.getName(CCT, 1);
    String VLVCFullName = getVersionLevelName + "/" + getVersionChapterName;

    private void testPractiseSet() throws InterruptedException {

        logger.info("Testing Practise...");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        practise = new Practise(driver);
        practise.setPractise();
        logger.info("Testing Practise Created...");

    }
    public void TestDataConfigure() {
        logger.info("Testing Data Configuration...");


        WordReader.processWordDocument(FilePathWords, Keywords);

        logger.info("Testing Data Configuration Created...");

    }


    @Before
    public void TestHomePageLogin() {
        driver = new ChromeDriver();

        logger.info("home driver:" +driver);

        logger.info(">>>>>Starting search test..."+driver);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        login = new Login(driver);


    }


    @Test
    public void TestChapters() throws InterruptedException {
        TestDataConfigure();
        logger.info("Testing Chapters...");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        chapters = new Chapters(driver);
        chapters.chapterClick();
        logger.info("Testing Chapter Created...");
    }


    @Test
    public void TestCreateClozeTest() throws InterruptedException {


        logger.info("Testing Cloze Test...");
        testPractiseSet();

        clozeTestAdd = new ClozeTestAdd(driver, version + getPracticeNumber() + "   -   " + VLVCFullName + "/" + LevelCreate.getName(1, 2), "Grammar-ClozeTest-1.txt");
        incrementVersionNumber();
        logger.info("Testing Cloze Test Created...");
//        driver.quit();

        TestHomePageLogin();
        logger.info("Testing Cloze Test...");
        testPractiseSet();
        clozeTestAdd = new ClozeTestAdd(driver, version + getPracticeNumber() + "   -   " + VLVCFullName + "/" + LevelCreate.getName(1, 2), "Vocabulary-ClozeTest-1.txt");
        incrementVersionNumber();
        logger.info("Testing Cloze Test Created...");

//        driver.quit();

    }

    @Test
    public void TestCreateFillInTheBlanks() throws InterruptedException {
    logger.info("Testing Fill in the blanks...");
    testPractiseSet();
        fillInTheBlanksAdd = new FillInTheBlanksAdd(driver);
        incrementVersionNumber();
        logger.info("Testing Fill in the blanks Created...");
//        driver.quit();
    }

    @Test
    public void TestCreateMultipleChoice() throws InterruptedException, AWTException {
        String VersionX = (version + getPracticeNumber() + "   -   " + VLVCFullName + "/" + LevelCreate.getName(3, 2));

        logger.info("Testing Multiple Choices..."+VersionX);
        testPractiseSet();
        multipleChoicesAdd = new MultipleChoicesAdd(driver, VersionX, "Vocabulary-MultipleChoices-1.txt");
        incrementVersionNumber();
        logger.info("Testing Multiple Choices Created..."+VersionX);
//        driver.quit();

        TestHomePageLogin();
        logger.info("Testing Multiple Choices..."+VersionX);
        testPractiseSet();
        multipleChoicesAdd = new MultipleChoicesAdd(driver, version + getPracticeNumber() + "   -   " + VLVCFullName + "/" + LevelCreate.getName(3, 2), "Grammar-MultipleChoices-1.txt");
        incrementVersionNumber();
        logger.info("Testing Multiple Choices Created...");
//        driver.quit();


        TestHomePageLogin();
        logger.info("Testing Multiple Choices...");
        testPractiseSet();
        multipleChoicesAdd = new MultipleChoicesAdd(driver, version + getPracticeNumber() + "   -   " + VLVCFullName + "/" + LevelCreate.getName(3, 2), "Grammar-MultipleChoices-2.txt");
        incrementVersionNumber();
        logger.info("Testing Multiple Choices Created...");
//        driver.quit();
    }

    @Test
    public void TestCreateOrderTheSentence() throws InterruptedException {
        logger.info("Testing Order the sentence...");
        testPractiseSet();
        orderTheSentenceAdd = new OrderTheSentenceAdd(driver, version + getPracticeNumber() + "   -   " + VLVCFullName + "/" + LevelCreate.getName(4, 2), "OrdertheSentence.txt");
        incrementVersionNumber();
        logger.info("Testing Order the sentence Created...");

//        driver.quit();
    }

    @Test
    public void TestCreateReading() throws InterruptedException {


        logger.info("Testing Reading...");
        testPractiseSet();
        readingAdd = new ReadingAdd(driver, version + getPracticeNumber() + "   -   " + VLVCFullName + "/" + LevelCreate.getName(5, 2), "Vocabulary-Reading-1.txt");
        incrementVersionNumber();
        logger.info("Testing Reading Created...");

//        driver.quit();
    }

    @Test
    public void TestCreateGeneral() throws InterruptedException, AWTException {
        preparationTest = new PreparationTest();
        preparationTest.TestCreateAll();


    }


}