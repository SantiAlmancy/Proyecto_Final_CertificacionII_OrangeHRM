package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class ClaimPage
{
    WebDriver driver;
    @FindBy(css = "a[href='/web/index.php/claim/viewClaimModule']")
    WebElement buttonClaim;
    @FindBy(className = "oxd-topbar-header-breadcrumb")
    WebElement pageName;
    @FindBys({
            @FindBy(className = "oxd-topbar-body-nav-tab")
    })
    List<WebElement> menuButtons;
    @FindBys({
            @FindBy(css = "i[data-v-67d2aedf]")
    })
    List<WebElement> listDownButtons;
    @FindBy(css = "h6[class='oxd-text oxd-text--h6 orangehrm-main-title']")
    WebElement textBoxCreateClaim;
    @FindBy(css = "textarea[class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
    WebElement textBoxRemarks;
    @FindBy(css= "button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement createButton;
    @FindBys({
            @FindBy(css = "input[class='oxd-input oxd-input--active']")
    })
    List<WebElement> claimInformation;

    @FindBys({
            @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--text']")
    })
    List<WebElement> AddExpensesAndAttachments;
    @FindBy(css = "i[class='oxd-icon bi-calendar oxd-date-input-icon']")
    WebElement calendarIcon;
    @FindBy(css = "button[type='submit']")
    WebElement buttonSubmitExpense;
    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-sm-button']")
    WebElement submitClaimButton;
    @FindBy(css = "div[class='oxd-date-input-link --today']")
    WebElement todayButton;

    public ClaimPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickOnButtonClaim()
    {
        buttonClaim.click();
    }
    public boolean isPageClaim()
    {
        return (pageName.getText().equals("Claim"));
    }
    public void clickOnSubmitButton()
    {
        menuButtons.get(1).click();
    }
    public void selectUserEvent(String event) {
        WebElement listDownButton = listDownButtons.get(0);
        listDownButton.click();

        WebElement listBox = driver.findElement(By.cssSelector("div[role='listbox']"));

        List<WebElement> options = listBox.findElements(By.cssSelector("div[role='option']"));

        switch (event) {
            case "Accommodation" -> options.get(1).click();
            case "Medical Reimbursement" -> options.get(2).click();
            case "Travel Allowance" -> options.get(3).click();
            default -> {
            }
        }
    }

    public void selectCurrency(String currency) {
        WebElement listDownButton = listDownButtons.get(1);
        listDownButton.click();

        WebElement listBox = driver.findElement(By.cssSelector("div[role='listbox']"));

        List<WebElement> options = listBox.findElements(By.cssSelector("div[role='option']"));

        switch (currency) {
            case "Afghanistan Afghani" -> options.get(1).click();
            case "Albanian Lek" -> options.get(2).click();
            case "Algerian Dinar" -> options.get(3).click();
            default -> {
            }
        }
    }
    public boolean isTextBoxCreateClaimDisplayed()
    {
        return textBoxCreateClaim.isDisplayed();
    }
    public void setRemarks(String remarks)
    {
        textBoxRemarks.sendKeys(remarks);
    }
    public void clickOnCreateButton()
    {
        createButton.click();
    }
    public boolean isSubmitClaimButtonDisplayed()
    {
        return submitClaimButton.isDisplayed();
    }
    public List<String> getIdOfClaim()
    {
        List<String> info = new ArrayList<>();
        for ( WebElement element : claimInformation)
        {
            info.add(element.getText());
        }
        return info;
    }

    public void clickOnAddExpenses()
    {
        AddExpensesAndAttachments.get(0).click();
    }

    public void selectExpense(String expense) {
        WebElement listDownButton = listDownButtons.get(0);
        listDownButton.click();

        WebElement listBox = driver.findElement(By.cssSelector("div[role='listbox']"));

        List<WebElement> options = listBox.findElements(By.cssSelector("div[role='option']"));

        switch (expense) {
            case "Accommodation" -> options.get(1).click();
            case "Fuel Allowance" -> options.get(2).click();
            case "Planned Surgery" -> options.get(3).click();
            case "Transport" -> options.get(4).click();
            default -> {
            }
        }
    }
    public void selectTotalExpense(String total)
    {
        List<WebElement> texts = driver.findElements(By.cssSelector("input[class='oxd-input oxd-input--active']"));
        texts.get(5).sendKeys(total);
    }
    public void clickOnCalendarIcon()
    {
        calendarIcon.click();
    }
    public void selectDate()
    {
        todayButton.click();
    }
    public void setNoteForExpense(String note)
    {
        List<WebElement> textBoxes = driver.findElements(By.cssSelector("textarea[class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']"));
        WebElement notes = textBoxes.get(1);
        notes.sendKeys(note);
    }
    public void clickOnSubmitExpenseButton()
    {
        buttonSubmitExpense.click();
    }
    public void clickOnSubmitClaimButton()
    {
        submitClaimButton.click();
    }
}
