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

import java.time.Duration;

import static org.openqa.selenium.support.How.XPATH;
import static org.testng.AssertJUnit.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Notifications {
    private final WebDriverWait webDriverWait;

    private WebDriver driver;

    public Notifications() {
        this.driver = DriverManager.getInstance();
        // WebDriver driver = DriverManager.getInstance();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.CLASS_NAME, using = "ant-notification-notice-message")
    private WebElement notificationMessageElement;

    @FindBy(how = How.CLASS_NAME, using = "ant-notification-notice-description")
    private WebElement notificationDescriptionElement;

    @FindBy(how = How.CLASS_NAME, using = "ant-notification-notice-with-icon")
    private WebElement validationMessages;

    @FindBy(how = How.CLASS_NAME, using = "ant-notification-notice-close")
    private WebElement popUpCloseButton;

    @FindBy(how = How.CLASS_NAME, using = "ant-form-item-explain-error")
    private WebElement explainError;

    public WebElement getPopUpCloseButton() {
        return popUpCloseButton;
    }
    public String getMessageFromNotification() {
        webDriverWait.until(ExpectedConditions.visibilityOf(notificationMessageElement));
        return notificationMessageElement.getText();
    }
    public String getExplainError() {
        webDriverWait.until(ExpectedConditions.visibilityOf(explainError));
        return explainError.getText();
    }

    public String getDescriptionFromNotification() {
        webDriverWait.until(ExpectedConditions.visibilityOf(notificationDescriptionElement));
        return notificationDescriptionElement.getText();
    }

    // HomeTask:
    public String getValidationMessages() {
        webDriverWait.until(ExpectedConditions.visibilityOf(validationMessages));
        WebElement validationMessages = driver.findElement((By.className("ant-notification-notice-with-icon")));
        return validationMessages.getText();
    }

    public void closePopup() {
        WebElement closeButton = driver.findElement(By.className("ant-notification-notice-close"));
        closeButton.click();
    }

    public void clickIdNumberButton() {
        WebElement idNumberButton = driver.findElement(By.className("ant-table-column-title"));
        idNumberButton.click();
    }

    public void testLinkNavigation() {
        WebElement linkButton = driver.findElement(By.linkText("acodemy @ 2023"));

    }

}






