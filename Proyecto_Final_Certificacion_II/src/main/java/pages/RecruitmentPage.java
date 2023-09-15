package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RecruitmentPage
{
    WebDriver driver;
    @FindBy(css = "a[href='/web/index.php/recruitment/viewRecruitmentModule']")
    WebElement buttonRecruitment;
    @FindBy(css = "li[class='oxd-topbar-body-nav-tab']")
    WebElement buttonVacancies;
    @FindBy(className = "oxd-table-filter-header")
    WebElement titlePageVacancies;
    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement buttonAddVacancies;
    @FindBys({
            @FindBy(css = "input[data-v-1f99f73c='']")
    })
    List<WebElement> textBoxesForm;
    @FindBy(className = "oxd-select-text--after")
    WebElement buttonDisplayJobTitles;
    @FindBy(css = "textarea[placeholder='Type description here']")
    WebElement textBoxDescription;
    @FindBys({
            @FindBy(css = "span[class='oxd-switch-input oxd-switch-input--active --label-right']")
    })
    List<WebElement> toggleButtons;
    @FindBy(css = "button[type='submit']")
    WebElement buttonSubmitVacancy;
    public RecruitmentPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnButtonRecruitment()
    {
        buttonRecruitment.click();
    }
    public boolean isButtonVacanciesDisplayed()
    {
        return (buttonVacancies.isDisplayed() && buttonVacancies.getText().equals("Vacancies"));
    }
    public void clickOnButtonVacancies()
    {
        buttonVacancies.click();
    }
    public boolean isVacanciesPageDisplayed()
    {
        return (titlePageVacancies.isDisplayed() && titlePageVacancies.getText().equals("Vacancies"));
    }
    public void clickOnButtonAddVacancy()
    {
        buttonAddVacancies.click();
    }
    public void setVacancyName(String name)
    {
        textBoxesForm.get(1).sendKeys(name);
    }
    public void setNumberOfPositions(String number)
    {
        textBoxesForm.get(2).sendKeys(number);
    }
    public void clickOnButtonDisplayJobTitle()
    {
        buttonDisplayJobTitles.click();
    }
    public void selectJobTitle(String job)
    {
        WebElement listBox = driver.findElement(By.cssSelector("div[role='listbox']"));

        List<WebElement> options = listBox.findElements(By.cssSelector("div[role='option']"));

        switch (job)
        {
            case "Account Assistant" -> options.get(1).click();
            case "Chief Executive Officer" -> options.get(2).click();
            case "Chief Financial Officer" -> options.get(3).click();
            case "Chief Technical Officer" -> options.get(4).click();
            case "Content Specialist" -> options.get(5).click();
            case "Customer Success Manager" -> options.get(6).click();
            default -> {
            }
        }
    }
    public void setDescriptionTextBox(String description)
    {
        textBoxDescription.sendKeys(description);
    }
    public String setHiringManager(String manager) throws InterruptedException {
        WebElement autocompleteWrapper = driver.findElement(By.cssSelector("div.oxd-autocomplete-wrapper"));
        WebElement textBox = autocompleteWrapper.findElement(By.cssSelector("input[data-v-75e744cd]"));
        textBox.sendKeys(manager);
        Thread.sleep(3000);
        WebElement firstOption = autocompleteWrapper.findElement(By.cssSelector("div.oxd-autocomplete-option"));
        String managerName = firstOption.getText();
        firstOption.click();
        return managerName;
    }
    public void clickOnToggleButtonActive()
    {
        toggleButtons.get(0).click();
    }
    public void clickOnToggleButtonPublish()
    {
        toggleButtons.get(toggleButtons.size() - 1).click();
    }
    public void clickOnButtonSubmitVacancy()
    {
        buttonSubmitVacancy.click();
    }
    public boolean isVacancyRecorded(String[] valuesToMatch)
    {
        List<WebElement> rows = driver.findElements(By.cssSelector(".oxd-table-row[data-v-f2168256]"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".oxd-table-cell"));
            cells.remove(0);
            int i = 0;
            for (WebElement cell : cells)
            {
                System.out.println(cell.getText().trim());
                String value = cell.getText().trim();
                if (i!=1 && i!=2 && !value.equals(valuesToMatch[i]))
                {
                    break;
                }
                if (i == 3)
                {
                    return true;
                }
                System.out.println(cell.getText().trim());
                i ++;
            }
        }
        return false;
    }
}
