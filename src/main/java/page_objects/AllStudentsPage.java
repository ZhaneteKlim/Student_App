package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;
import java.util.ArrayList;
import java.util.List;
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
    @FindBy(how = How.CLASS_NAME, using = "ant-table-column-title")
    private WebElement clickIdNumberButton;
    public void waitAndClickIdNumberButton() {
        webDriverWait.until(elementToBeClickable(clickIdNumberButton));
      //  WebElement idNumberButton = driver.findElement(By.className("ant-table-column-title"));
        clickIdNumberButton.click();
    }
    @FindBy(how = How.XPATH, using = "//tr[@data-row-key='787']")
    private List<WebElement> studentNameElements;


    public List<String> getAllStudentNames() {
        List<String> studentNames = new ArrayList<>();

        for (WebElement element : studentNameElements) {
            studentNames.add(element.getText());
        }

        return studentNames;
    }
    @FindBy(how = How.LINK_TEXT, using = "acodemy @ 2023")
   public WebElement linkButton;

    public void clickLinkButton() {
        linkButton.click();
    }

    }



