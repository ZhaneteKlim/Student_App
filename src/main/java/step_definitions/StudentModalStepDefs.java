package step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import page_objects.AddStudentPage;
import io.cucumber.java.en.When;
public class StudentModalStepDefs {
    AddStudentPage addStudentPage = new AddStudentPage();
    Faker faker = new Faker();

    @Given("user is on the app page")
    public void user_is_on_the_app_page() {
        throw new io.cucumber.java.PendingException();
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("user click on add student button")
    public void user_click_on_add_student_button() {
        throw new io.cucumber.java.PendingException();
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("user enters {string} in name field")
    public void user_enters_in_name_field() {
        addStudentPage.waitAndSetValueForNameField(faker.name().firstName());
        // Write code here that turns the phrase above into concrete actions
        //    throw new io.cucumber.java.PendingException();
    }

    @Given("user enters {string} in email field")
    public void user_enters_in_email_field() {
        addStudentPage.waitAndSetValueForEmailField(faker.internet().emailAddress());
        throw new io.cucumber.java.PendingException();
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("user enters {string} in gender field")
    public void user_enters_in_gender_field(String string) {
        throw new io.cucumber.java.PendingException();
        // Write code here that turns the phrase above into concrete actions
    }

    @When("user click on submit button")
    public void user_click_on_submit_button() {
        // Write code here that turns the phrase above into concrete actions

    }
}
