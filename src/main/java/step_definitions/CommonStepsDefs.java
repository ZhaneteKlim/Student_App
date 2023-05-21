package step_definitions;
import io.cucumber.java.en.Given;
import utils.DriverManager;

import static utils.ConfigHelper.getConfig;
import static utils.DriverManager.getInstance;

public class CommonStepsDefs {
  //  @Given("user is on the app page")
   // public void user_is_on_the_app_page() {
   //     getInstance().get("");
        // Write code here that turns the phrase above into concrete actions
        //   throw new io.cucumber.java.PendingException();
   //     public class CommonStepDefs {
            @Given("user is on the app page")
            public void userIsOnTheAppPage() {
                getInstance()
                        .get(getConfig().getString("student.app.hostname"));
    }
}
