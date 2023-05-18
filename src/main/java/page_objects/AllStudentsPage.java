package page_objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class AllStudentsPage {
    private final WebDriverWait webDriverWait;

    public AllStudentsPage() {
        WebDriver driver = DriverManager.getInstance();
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//div[@class='ant-table-title']//button")
    private WebElement addStudentButton;

    public void waitAndClickOnAddStudentButton() {
        webDriverWait.until(elementToBeClickable(addStudentButton));
        addStudentButton.click();
    }

    public WebElement getAddStudentButton() {
        return addStudentButton;

    }
}
