package step_definitions;
import io.cucumber.java.en.Given;
import utils.DriverManager;
public class CommonStepsDefs {
    @Given("user is on the app page")
    public void user_is_on_the_app_page() {
        DriverManager.getInstance().get("");
        // Write code here that turns the phrase above into concrete actions
        //   throw new io.cucumber.java.PendingException();

    }
}
