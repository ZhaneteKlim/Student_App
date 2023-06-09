import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.AddStudentPage;
import page_objects.AllStudentsPage;
import page_objects.Notifications;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static constants.AllConstants.GenderConstants.MALE;
import static constants.AllConstants.Messages.STUDENT_SUCCESSFULLY_ADDED;
import static constants.AllConstants.Messages.WAS_ADDED_TO_THE_SYSTEM;
import static org.testng.Assert.*;
import static utils.ConfigHelper.getConfig;
import static utils.DriverManager.*;
public class StudentAppTest {

    private WebDriverWait driverWait;

    private AllStudentsPage allStudentsPage;
    private AddStudentPage addStudentPage;
    private Notifications notifications;


    private final Faker dataFaker = new Faker();
    private final String APP_URL = "http://app.acodemy.lv/";

    @BeforeMethod(alwaysRun = true)
    public void initialize(Method method) {
        testName = (method.getName());
        driverWait = new WebDriverWait(getInstance(), Duration.ofSeconds(10));
        getInstance().get(getConfig().getString("student.app.hostname"));
        allStudentsPage = new AllStudentsPage();
        addStudentPage = new AddStudentPage();
        notifications = new Notifications();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (!getConfig().getBoolean("student.app.run.locally")) markRemoteTest(result);
        closeDriver();
    }

    @Test(description = "Add student and check successful message")
    public void openStudentApp() {
        allStudentsPage.waitAndClickOnAddStudentButton();

        String name = dataFaker.name().firstName();
        String email = dataFaker.internet().emailAddress();
        addStudentPage.waitAndSetValueForNameField(name);
        addStudentPage.waitAndSetValueForEmailField(email);
        addStudentPage.waitAndSetGender(MALE);
        addStudentPage.clickOnSubmitButton();

        assertEquals(notifications.getMessageFromNotification(), STUDENT_SUCCESSFULLY_ADDED);
        assertEquals(notifications.getDescriptionFromNotification(), String.format(WAS_ADDED_TO_THE_SYSTEM, name));

        notifications.getPopUpCloseButton().click();
        assertTrue(driverWait.until(ExpectedConditions.invisibilityOf(notifications.getPopUpCloseButton())));
    }

    @Test()
    public void checkTitle() {
        assertEquals(getInstance().getTitle(), "acodemy - React App");
    }

    @Test(description = "Check popup massages for invalid dates in registration field (e-mail is already taken)")
    public void checkValidationMessages() {
        allStudentsPage.waitAndClickOnAddStudentButton();
        addStudentPage.waitAndSetValueForNameField("Abcdefg");
        addStudentPage.waitAndSetGender(MALE);
        addStudentPage.waitAndSetValueForEmailField("janete.klim@gmail.com");
        addStudentPage.clickOnSubmitButton();
        Notifications notifications = new Notifications();
        String validationMessages = notifications.getValidationMessages();
        System.out.println(validationMessages);
    }

    @Test(description = "Submit form with empty field and check validation message")
    public void submitFormWithEmptyField() {
        allStudentsPage.waitAndClickOnAddStudentButton();
        String name = dataFaker.name().firstName();
        //  String email = dataFaker.internet().emailAddress();
        addStudentPage.waitAndSetValueForNameField(name);
        addStudentPage.waitAndSetValueForEmailField(""); // empty e-mail field
        addStudentPage.waitAndSetGender(MALE);
        addStudentPage.clickOnSubmitButton();
        String explainError = notifications.getExplainError();
        System.out.println(explainError);
    }

    @Test(description = "Submit form with email without domain part")
    public void submitFormWithWrongEmail() {
        allStudentsPage.waitAndClickOnAddStudentButton();
        String name = dataFaker.name().firstName();
        String email = dataFaker.internet().emailAddress();
        addStudentPage.waitAndSetValueForNameField(name);
        addStudentPage.waitAndSetValueForEmailField("qqq@qqq"); //incorrect e-mail
        addStudentPage.waitAndSetGender(MALE);
        addStudentPage.clickOnSubmitButton();
        String validationMessages = notifications.getValidationMessages();
        System.out.println(validationMessages);
    }


    @Test(description = "Submit form with name exceeding 10 characters and check for validation")
    public void submitFormWithNameExceedingLimit() {
        allStudentsPage.waitAndClickOnAddStudentButton();

        String longName = "ThisIsALongName"; // this name is longer than 10 characters
        String email = dataFaker.internet().emailAddress();
        addStudentPage.waitAndSetValueForNameField(longName);
        addStudentPage.waitAndSetValueForEmailField(email);
        addStudentPage.waitAndSetGender(MALE);
        addStudentPage.clickOnSubmitButton();

        String validationMessages = notifications.getValidationMessages();

        System.out.println(validationMessages);
    }


  //  @Test(description = "Check the ID number button is clickable and changes the student list order")
  //  public void checkIdNumberButton() {

    //    List<String> initialStudentList = allStudentsPage.getAllStudentNames();
    //    notifications.clickIdNumberButton();
    //    List<String> updatedStudentList = allStudentsPage.getAllStudentNames();
    //    assertNotEquals(initialStudentList, updatedStudentList);
   // }

  //  @Test
  //  public void testLinkNavigation() {
  //      allStudentsPage.clickLinkButton();
  //      List<String> windowHandles = new ArrayList<>(getInstance().getWindowHandles()); // get all windows
  //      getInstance().switchTo().window(windowHandles.get(windowHandles.size() - 1)); // get last open window
  //      String currentUrl = getInstance().getCurrentUrl();
  //      String expectedUrl = APP_URL;
  //      System.out.println("Current URL: " + currentUrl);
  //      System.out.println("Expected URL: " + expectedUrl);
  //      assertTrue(currentUrl.contains(expectedUrl));
  //  }

  //  @Test
  //  public void testNextPageNavigation() {
  //      List<String> initialStudentList = allStudentsPage.getAllStudentNames();
  //      allStudentsPage.clickNextPageButton();
  //      WebDriverWait wait = new WebDriverWait(getInstance(), Duration.ofSeconds(10));
  //      wait.until(ExpectedConditions.stalenessOf(allStudentsPage.getAddStudentButton()));
  //      List<String> newStudentList = allStudentsPage.getAllStudentNames();
  //      assertNotEquals(newStudentList, initialStudentList);
  //  }
}




