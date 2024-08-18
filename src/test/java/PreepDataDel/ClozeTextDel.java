package PreepDataDel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClozeTextDel {

    private WebDriver driver;


    public ClozeTextDel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
