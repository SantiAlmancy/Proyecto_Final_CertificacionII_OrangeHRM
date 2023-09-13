package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.AdminPage;
import utilities.DriverManager;

import java.sql.Driver;

public class AdminSteps
{
    AdminPage adminPage = new AdminPage(DriverManager.getDriver().driver);

    @When("I click on the admin button")
    public void clickOnAdminButton() throws InterruptedException
    {
        Thread.sleep(1000);
        adminPage.clickButtonAdmin();
    }
    @Then("I must be in the Admin Page")
    public void isAdminPageDisplayed()
    {
        Assertions.assertTrue(adminPage.isButtonUserManagementDisplayed());
    }

    @When("I click on the new user button")
    public void clickOnAddUserButton() throws InterruptedException
    {
        adminPage.clickButtonAddNewUser();
        Thread.sleep(1000);
    }

    @When("I click on the User Management button")
    public void clickOnManagementButton() throws InterruptedException
    {
        adminPage.clickButtonUserManagement();
        Thread.sleep(1000);
    }
    @And("I click on the User button")
    public void clickOnUsersButton() throws InterruptedException
    {
        adminPage.clickButtonUsers();
        Thread.sleep(1000);
    }

    @Then("I must be in System Users")
    public void isSystemUsersDisplayed()
    {
        Assertions.assertTrue(adminPage.isNumberOfUsersVisible());
    }
}

