package stepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.AdminPage;
import utilities.DriverManager;


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
    @Then("I must be in New User form")
    public void isNewUserFormDisplayed()
    {
        Assertions.assertTrue(adminPage.isAddUserTextVisible());
    }
    @When("I set the username in form field with {string}")
    public void setUserNameInForm(String Username) throws InterruptedException {
        adminPage.setUserNameTextBox(Username);
        Thread.sleep(1000);
    }
    @And("I set the password in form field with {string}")
    public void setPasswordInForm(String Password) throws InterruptedException {
        adminPage.setPasswordTextBox(Password);
        Thread.sleep(1000);
    }
    @And("I set the repeated password in form field with {string}")
    public void setRepeatedPasswordInForm(String Password) throws InterruptedException {
        adminPage.setRepeatedPasswordTextBox(Password);
        Thread.sleep(1000);
    }
    @And("I set de role in form with {string}")
    public void setRoleInForm(String role) throws InterruptedException {
        adminPage.selectUserRole(role);
        Thread.sleep(1000);
    }

    @And("I set the status in form with {string}")
    public void setStatusInForm(String status) throws InterruptedException {
        adminPage.selectStatus(status);
        Thread.sleep(1000);
    }
    @And("I set the employee whose name starts with {string}")
    public void setEmployeeName(String firstLetter) throws InterruptedException
    {
        adminPage.fillEmployee(firstLetter);
        Thread.sleep(1000);
    }

    @When("I click on the save button")
    public void saveButtonClick() throws InterruptedException {
        adminPage.clickButtonSave();
        Thread.sleep(1000);
    }

    @Then("The user of username {string} from employee must be created")
    public void isUserCreated(String user) throws InterruptedException
    {
        Assertions.assertTrue(adminPage.UserCreated(user));
        Thread.sleep(1000);
    }

}

