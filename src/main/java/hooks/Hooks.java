package hooks;
import io.cucumber.java.After;
import static utils.DriverManager.closeDriver;

public class Hooks {
    @After
    public void afterTest() {
        closeDriver();
    }
}
