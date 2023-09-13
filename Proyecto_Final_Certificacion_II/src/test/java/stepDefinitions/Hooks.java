package stepDefinitions;

import io.cucumber.java.AfterAll;
import utilities.DriverManager;

public class Hooks {

    @AfterAll
    public static void afterScenario()
    {
        DriverManager.getDriver().driver.close();
    }
}
