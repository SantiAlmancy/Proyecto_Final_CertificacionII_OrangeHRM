package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.jupiter.api.Assertions;
import pages.RecruitmentPage;
import utilities.DriverManager;

public class RecruitmentSteps
{
    RecruitmentPage recruitmentPage = new RecruitmentPage(DriverManager.getDriver().driver);
    String Vacancy = "";
    String JobTitle = "";
    String HiringManager = "";
    String Status = "";
    @When("I click on the recruitment button")
    public void clickOnRecruitmentButton()
    {
        recruitmentPage.clickOnButtonRecruitment();
    }
    @Then("I must be in the recruitment page")
    public void isRecruitmentPageDisplayed()
    {
        Assertions.assertTrue(recruitmentPage.isButtonVacanciesDisplayed());
    }
    @When("I click on the vacancies button")
    public void clickOnVacanciesButton()
    {
        recruitmentPage.clickOnButtonVacancies();
    }
    @Then("I must be in the vacancies page")
    public void isVacanciesPageDisplayed()
    {
        Assertions.assertTrue(recruitmentPage.isVacanciesPageDisplayed());
    }
    @When("I click on the add new vacancy button")
    public void clickOnAddNewVacancyButton()
    {
        recruitmentPage.clickOnButtonAddVacancy();
    }
    @And("I set the vacancy name as {string}")
    public void setVacancyName(String name)
    {
        recruitmentPage.setVacancyName(name);
        Vacancy = name;
    }
    @And("I set the number of positions as {string}")
    public void setPositionsNumber(String number)
    {
        recruitmentPage.setNumberOfPositions(number);
    }
    @And("I click on the job title for vacancy button")
    public void clickOnJobTitleVacancyButton()
    {
        recruitmentPage.clickOnButtonDisplayJobTitle();
    }
    @And("I select the job title for vacancy: {string}")
    public void setJobTitleForVacancy(String job)
    {
        recruitmentPage.selectJobTitle(job);
        JobTitle = job;
    }
    @And("I set the description for the vacancy as {string}")
    public void setDescriptionForVacancy(String description)
    {
        recruitmentPage.setDescriptionTextBox(description);
    }
    @And("I set the hiring manager in form field as {string}")
    public void setHiringManager(String name)
    {
        HiringManager = recruitmentPage.setHiringManager(name);
    }
    @And("I set the active option: {string}")
    public void setActiveOption(String option)
    {
        if(option.equals("yes"))
        {
            recruitmentPage.clickOnToggleButtonActive();
            Status = "Active";
        }
    }
    @And("I set the Publish in RSS Feed and Web Page option: {string}")
    public void setPublishOption(String option)
    {
        if(option.equals("yes"))
        {
            recruitmentPage.clickOnToggleButtonPublish();
        }
    }
    @Given("I click on the save vacancy button")
    public void clickOnSaveButton()
    {
        recruitmentPage.clickOnButtonSubmitVacancy();
    }
    @Then("The new created vacancy must have been recorded")
    public void isKPIRecorded()
    {
        String[] valuesToMatch = {
                Vacancy,
                JobTitle,
                HiringManager,
                Status
        };
        Assertions.assertTrue(recruitmentPage.isVacancyRecorded(valuesToMatch));
    }
}
