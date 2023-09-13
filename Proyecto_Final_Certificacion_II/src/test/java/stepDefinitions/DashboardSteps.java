package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.DashboardPage;
import utilities.DriverManager;

public class DashboardSteps
{
    DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver().driver);

    @Then("I must be in the Home Page")
    public void verifyDashBoardIsDisplayed()
    {
        Assertions.assertTrue(dashboardPage.isDropDownUserVisible());
    }
}
