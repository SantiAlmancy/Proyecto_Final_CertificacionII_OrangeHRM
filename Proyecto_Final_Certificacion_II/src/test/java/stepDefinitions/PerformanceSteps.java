package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.jupiter.api.Assertions;
import pages.PerformancePage;
import utilities.DriverManager;

public class PerformanceSteps
{
    PerformancePage performancePage = new PerformancePage(DriverManager.getDriver().driver);
    String performance = "";
    String jobTitle = "";
    String minRate = "";
    String maxRate = "";
    String scale = "";
    @When("I click on the performance button")
    public void clickOnPerformanceButton()
    {
        performancePage.clickOnButtonPerformance();
    }
    @Then("I must be in the Performance Page")
    public void isPerformancePageDisplayed()
    {
        Assertions.assertTrue(performancePage.isButtonConfigureDisplayed());
    }
    @When("I click on the configure performance button")
    public void clickOnConfigurePerformanceButton()
    {
        performancePage.clickOnButtonConfigure();
    }
    @And("I select the KPIs option")
    public void clickOnKPIsOption()
    {
        performancePage.clickOnButtonKPIs();
    }
    @Then("I must be in the key performance indicator section")
    public void isPerformanceIndicatorSectionDisplayed()
    {
        Assertions.assertTrue(performancePage.isButtonAddKPIDisplayed());
    }
    @When("I click on the add new KPI button")
    public void clickOnAddNewKPIButton()
    {
        performancePage.clickOnButtonAddKPI();
    }
    @And("I set the key performance indicator as {string}")
    public void setKPIInForm(String indicator)
    {
        performancePage.setKPI(indicator);
        performance = indicator;
    }
    @And("I set the minimum rating as {string}")
    public void setMinimumRatingKPI(String rating)
    {
        performancePage.setMinimumRating(rating);
        minRate = rating;
    }
    @And("I set the maximum rating as {string}")
    public void setMaximumRatingKPI(String rating)
    {
        performancePage.setMaximumRating(rating);
        maxRate = rating;
    }
    @And("I click on the job title button")
    public void clickOnJobTitleButton()
    {
        performancePage.clickOnButtonDisplayJobTitle();
    }
    @Given("I select the job title: {string}")
    public void setJobTitleForKPI(String job)
    {
        performancePage.selectJobTitle(job);
        jobTitle = job;
    }
    @And("I set the default scale: {string}")
    public void setDefaultScale(String x)
    {
        if (x.equals("yes"))
        {
            performancePage.clickOnButtonToggleDefaultScale();
            scale = x;
        }
    }
    @And("I click on the save KPI button 12")
    public void clickOnSaveKPIButton()
    {
        performancePage.clickOnButtonSaveKPI();
    }
    @Then("The new created KPI must haven been recorded 13")
    public void isKPIRecorded()
    {
        String[] valuesToMatch = {
                performance,
                jobTitle,
                minRate,
                maxRate,
                scale
        };
        Assertions.assertTrue(performancePage.isKPIRecorded(valuesToMatch));
    }
}
