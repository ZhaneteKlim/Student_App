package step_definitions;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import page_objects.AllStudentsPage;
public class MainPageStepsDefs {
    AllStudentsPage allStudentsPage = new AllStudentsPage();
    @Given("user is on the app page")
    public void userClickOnAllStudentButton() {
        allStudentsPage.waitAndClickOnAddStudentButton();
        throw new PendingException();
    }
}
