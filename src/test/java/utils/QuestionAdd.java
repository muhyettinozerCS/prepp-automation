package utils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class QuestionAdd {
    WebDriver driver;
    public QuestionAdd(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public static void SetQuestionAnswer(WebDriver driver, int i, String j) {


        String CorrectOptions = "-checkbox-1";
        switch (j) {
            case "A":
                CorrectOptions = "-checkbox-1";

                break;
            case "B":
                CorrectOptions = "-checkbox-2";

                break;
            case "C":
                CorrectOptions = "-checkbox-3";

                break;
            case "D":
                CorrectOptions = "-checkbox-4";

                break;
        }
        String practiceXpath = CommonSelectorAdd.generatePracticeXpath("q-"+i+CorrectOptions);
         driver.findElement(By.xpath(practiceXpath)).click();
    }
    //input[@id='q-2-option-1']
    public static void setQuestionOption(WebDriver driver, String QuestionOption, int i, int j) {
        String Options = "-option-" + j;

            String practiceXpath = CommonSelectorAdd.generatePracticeXpath("q-"+i+Options);
            WebElement inputField = driver.findElement(By.xpath(practiceXpath));

            // Prepare text to paste
            StringSelection stringSelection = new StringSelection(QuestionOption);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);

            // Click the input field to focus it
            inputField.click();

            // Paste the text using the CTRL + V shortcut
            Actions actions = new Actions(driver);
            actions.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.CONTROL).perform();//for mac
            // actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();//for windows

//        driver.findElement(By.xpath(practiceXpath)).sendKeys(QuestionOther + " ");

    }
    public static void SetQuestionAdd(WebDriver driver, String QuestionOther,int QuestionNumber) {
            String practiceXpath = CommonSelectorAdd.generatePracticeXpath("question-"+QuestionNumber);
            WebElement inputField = driver.findElement(By.xpath(practiceXpath));
            // Prepare text to paste
            StringSelection stringSelection = new StringSelection(QuestionOther);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            // Click the input field to focus it
            inputField.click();
            // Paste the text using the CTRL + V shortcut
            Actions actions = new Actions(driver);
            actions.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.CONTROL).perform();//for mac
            // actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();//for windows
    }
    public static void clickAddQuestionButton(WebDriver driver) {
        // Find the element with the text "Add Question" and click it
        driver.findElement(By.xpath("//span[normalize-space()='Add Question']")).click();
    }
    public static void clickAddOptionButton(WebDriver driver, int questionNumber) {
        String practiceXpath = "//*[@id=\"add-option-q-";
        String questionXpath = "-btn\"]";
        System.out.println(practiceXpath+questionNumber+questionXpath);
        driver.findElement(By.xpath(practiceXpath+questionNumber+questionXpath)).click();
    }



    public static String QuestionAndOptionTextAfterPart(String filePath, int questionNumber, String OptionKey) {
        try {
            // Dosya içeriğini oku
            String fullText = new String(Files.readAllBytes(Paths.get(filePath)));
            // Satırlara ayır
            String[] lines = fullText.split("\n");
            // "A)" ile başlayan satırı bul ve sonrasındaki kısmı döndür
            String searchText = questionNumber+OptionKey ;
            for (String line : lines) {
                if (line.startsWith(searchText)) {
                    // "i." ifadesini bul ve ondan sonrasını döndür
                    System.out.println(line);
                    return (line.substring(line.indexOf(searchText) + searchText.length()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Hata durumunda istisnayı yazdır
        }
        return ""; // Hata durumunda veya aranan numara bulunamazsa boş string döner
    }
}
