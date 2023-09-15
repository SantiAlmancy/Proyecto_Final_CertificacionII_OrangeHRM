package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.ClaimPage;
import utilities.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class ClaimSteps
{
    // LOS THREAD SLEEPS SON PARA VER MEJOR EL PROCESO DE LOS TESTCASES Y LOS VIDEOS
    ClaimPage claimPage = new ClaimPage(DriverManager.getDriver().driver);
    List<String> information = new ArrayList<>();
    String totalExpense;
    String description;
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
        claimPage.selectUserEventWithRetry(event);
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
        description = remark;
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
        claimPage.clickOnAddExpenses();
        Thread.sleep(1000);
    }
    @And("I select the expense type as {string}")
    public void selectExpenseType(String type) throws InterruptedException
    {
        claimPage.selectExpenseWithRetry(type);
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
        claimPage.clickOnSubmitClaimButton();
        Thread.sleep(1000);
    }
    @And("I click on the calendar icon")
    public void clickOnCalendarIcon()
    {
        claimPage.clickOnCalendarIcon();
    }

    @When("I save my claim information and total expense")
    public void infoOfClaim() throws InterruptedException {
        information = claimPage.getInformationOfClaim();
        totalExpense = claimPage.getTotalExpense();
    }

    @Then("The claim information and total expense must be correct")
    public void isClaimInformationCorrect() throws InterruptedException {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(currentDate);

        String[] valuesToMatch = {
                information.get(1),
                information.get(2),
                description,
                information.get(4),
                formattedDate,
                "Submitted",
                totalExpense
        };
        Assertions.assertTrue(claimPage.isClaimRecorded(valuesToMatch));
        Thread.sleep(1000);
    }

    @And("I click on my claims button")
    public void clickOnMyClaimsButton() throws InterruptedException
    {
        claimPage.clickOnMyClaims();
        Thread.sleep(1000);
    }
}
