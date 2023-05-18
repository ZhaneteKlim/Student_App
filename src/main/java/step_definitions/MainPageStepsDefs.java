package step_definitions;

import io.cucumber.java.en.Given;
import page_objects.AllStudentsPage;
public class MainPageStepsDefs {
    AllStudentsPage allStudentsPage = new AllStudentsPage();
    @Given("user is on the app page")
    public void userClickOnAllStudentButton() {
        allStudentsPage.waitAndClickOnAddStudentButton();
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
    }

}
