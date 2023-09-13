package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import pages.AdminPage;
import pages.ClaimPage;
import utilities.DriverManager;

public class ClaimSteps
{
    ClaimPage claimPage = new ClaimPage(DriverManager.getDriver().driver);
    @When("I click on the claim button")
    public void clickOnClaimButton() throws InterruptedException
    {
        claimPage.clickOnButtonClaim();
        Thread.sleep(1000);
    }
    @Then("I must be in the claim page")
    public void isClaimPageDisplayed()
    {
        Assertions.assertTrue(claimPage.isPageClaim());
    }

    @When("I click on submit claim button")
    public void clickOnSubmitButton() throws InterruptedException
    {
        claimPage.clickOnSubmitButton();
        Thread.sleep(1000);
    }
    @Then("I must be in the submit claim page")
    public void isSubmitClaimPageDisplayed()
    {
        Assertions.assertTrue(claimPage.isTextBoxCreateClaimDisplayed());
    }

    @When("I select the event {string} for the claim")
    public void selectEventForClaim(String event) throws InterruptedException
    {
        claimPage.selectUserEvent(event);
        Thread.sleep(1000);
    }

    @When("I select the currency {string} for the claim")
    public void selectCurrencyForClaim(String currency) throws InterruptedException
    {
        claimPage.selectCurrency(currency);
        Thread.sleep(1000);
    }
    @And("I give some remarks like {string}")
    public void sendRemarksForClaim(String remark) throws InterruptedException
    {
        claimPage.setRemarks(remark);
        Thread.sleep(1000);
    }
    @And("I click on the create claim button")
    public void clickOnCreateClaim() throws InterruptedException
    {
        claimPage.clickOnCreateButton();
        Thread.sleep(1000);
    }

    @Then("I must be in the add expenses page")
    public void isAddExpensesPageDisplayed()
    {
        Assertions.assertTrue(claimPage.isSubmitClaimButtonDisplayed());
    }
    @When("I click on Add Expense")
    public void clickOnAddExpense() throws InterruptedException
    {
        Thread.sleep(1000);
        claimPage.clickOnAddExpenses();
        Thread.sleep(1000);
    }
    @And("I select the expense type as {string}")
    public void selectExpenseType(String type) throws InterruptedException
    {
        claimPage.selectExpense(type);
        Thread.sleep(1000);
    }
    @And("I select the date as today")
    public void selectDate() throws InterruptedException
    {
        claimPage.selectDate();
        Thread.sleep(1000);
    }
    @And("I give the total amount of expense {string}")
    public void selectTotalOfExpense(String total) throws InterruptedException
    {
        claimPage.selectTotalExpense(total);
        Thread.sleep(1000);
    }
    @And("I add a note like {string}")
    public void addNote(String note) throws InterruptedException
    {
        claimPage.setNoteForExpense(note);
        Thread.sleep(1000);
    }

    @And("I click on Save the expense")
    public void clickOnSaveExpense() throws InterruptedException
    {
        claimPage.clickOnSubmitExpenseButton();
        Thread.sleep(1000);
    }

    @And("I click on submit claim")
    public void clickOnSubmitClaim() throws InterruptedException
    {
        Thread.sleep(1000);
        claimPage.clickOnSubmitClaimButton();
        Thread.sleep(1000);
    }
    @And("I click on the calendar icon")
    public void clickOnCalendarIcon()
    {
        claimPage.clickOnCalendarIcon();
    }

}
