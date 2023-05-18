package page_objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

import static org.openqa.selenium.support.How.XPATH;

import java.time.Duration;

public class Notifications {
    private final WebDriverWait webDriverWait;
    // singleton pattern
    public Notifications() {
        WebDriver driver = DriverManager.getInstance();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = "ant-notification-notice-message")
    private WebElement notificationMessageElement;

    @FindBy(how = How.CLASS_NAME, using = "ant-notification-notice-description")
    //  private WebElement notificationDescriptionElement;
    // @FindBy(how = XPATH, using = "//div[@class='ant-notification-notice ant-notification-notice-error css-diro6f ant-notification-notice-closable']");
    private WebElement notificationDescriptionElement;
    private WebElement getValidationMessages;

    @FindBy(how = How.CLASS_NAME, using = "ant-notification-notice-close")
    private WebElement popUpCloseButton;





    public WebElement getPopUpCloseButton() {
        return popUpCloseButton;
    }

    public String getMessageFromNotification() {
        webDriverWait.until(ExpectedConditions.visibilityOf(notificationMessageElement));
        return notificationMessageElement.getText();
    }

    public String getDescriptionFromNotification() {
        webDriverWait.until(ExpectedConditions.visibilityOf(notificationDescriptionElement));
        return notificationDescriptionElement.getText();
    }

    //TODO HomeTask:
    public String getValidationMessages() {
        webDriverWait.until(ExpectedConditions.visibilityOf(getValidationMessages));
        return getValidationMessages.getText();
    }

}

//popup close
// create tests


