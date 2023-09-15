package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
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

    @Given("I click on the profile toggle button")
    public void clickOnToggleProfileButton()
    {
        dashboardPage.clickOnUserDropdown();
    }
    @And("I click on the logout button")
    public void clickOnLogoutButton()
    {
        dashboardPage.clickOnLogout();
    }
}
