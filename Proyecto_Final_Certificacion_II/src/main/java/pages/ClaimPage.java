package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;

import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
            @FindBy(css = ".oxd-input.oxd-input--active")
    })
    List<WebElement> claimInformation;
    @FindBy(css = "i[class='oxd-icon bi-calendar oxd-date-input-icon']")
    WebElement calendarIcon;
    @FindBy(css = "button[type='submit']")
    WebElement buttonSubmitExpense;
    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-sm-button']")
    WebElement submitClaimButton;
    @FindBy(css = "div[class='oxd-date-input-link --today']")
    WebElement todayButton;
    @FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-item' and text()='My Claims']")
    WebElement myClaimsButton;

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
    public void selectCurrency(String currency)
    {
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = driver.findElement(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-sm-button']"));
        wait.until(ExpectedConditions.visibilityOf(element));

        return element.isDisplayed();
    }
    public List<String> getInformationOfClaim() throws InterruptedException
    {
        Thread.sleep(1000); //Servidor necesita esperar para cargar información
        List<String> info = new ArrayList<>();
        for ( WebElement element : claimInformation)
        {
            String inputValue = element.getAttribute("value");
            info.add(inputValue);
        }
        return info;
    }

    public void clickOnAddExpenses()
    {
        WebElement addExpense = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--text'][data-v-0faf90dd]")));
        boolean isClicked = false;
        int attempts = 0;
        while (!isClicked && attempts < 25)
        {
            try {
                addExpense.click();
                isClicked = true;
            } catch (Exception e) {
                attempts++;
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
        WebElement submitClaimButton = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-sm-button']")));
        boolean isClicked = false;
        int attempts = 0;
        while (!isClicked && attempts < 35)
        {
            try {
                submitClaimButton.click();
                isClicked = true;
            } catch (Exception e) {
                attempts++;
            }
        }
    }
    public String getTotalExpense()
    {
        WebElement paragraphElement = driver.findElement(By.cssSelector("p[data-v-7b563373][data-v-0faf90dd]"));
        String paragraphText = paragraphElement.getText();
        return paragraphText.replaceAll("[^0-9.]+", "");
    }
    public boolean isClaimRecorded(String[] valuesToMatch) throws InterruptedException {
        Thread.sleep(2000); //Servidor necesita esperar para cargar información
        List<WebElement> rows = driver.findElements(By.cssSelector(".oxd-table-row[data-v-0d5ef602]"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".oxd-table-cell"));
            int i = 0;
            for (WebElement cell : cells)
            {
                String value = cell.getText().trim();
                if (i != 2 && i!= 4 && !value.equals(valuesToMatch[i]))
                {
                    break;
                }
                if (i == 6)
                {
                    return true;
                }
                i ++;
            }
        }
        return false;
    }

    public void clickOnMyClaims()
    {
        myClaimsButton.click();
    }
    private void retryAction(Runnable action, int maxRetries)
    {
        for (int retry = 0; retry < maxRetries; retry++)
        {
            try
            {
                action.run();
                return;
            } catch (Exception e)
            {
                // ERROR
            }
        }
        throw new RuntimeException("ERROR.");
    }
    public void selectUserEventWithRetry(String event) throws InterruptedException
    {
        WebElement listDownButton = listDownButtons.get(0);
        retryAction(listDownButton::click, 10);
        Thread.sleep(1000); //Servidor necesita esperar para cargar información
        WebElement listBox = driver.findElement(By.cssSelector("div[role='listbox']"));

        List<WebElement> options = listBox.findElements(By.cssSelector("div[role='option']"));

        switch (event) {
            case "Accommodation" -> retryAction(() -> options.get(1).click(), 10);
            case "Medical Reimbursement" -> retryAction(() -> options.get(2).click(), 10);
            case "Travel Allowance" -> retryAction(() -> options.get(3).click(), 10);
            default -> {
            }
        }
    }
    public void selectExpenseWithRetry(String expense) throws InterruptedException
    {
        WebElement listDownButton = listDownButtons.get(0);
        retryAction(listDownButton::click, 10);
        Thread.sleep(1000); //Servidor necesita esperar para cargar información
        WebElement listBox = driver.findElement(By.cssSelector("div[role='listbox']"));

        List<WebElement> options = listBox.findElements(By.cssSelector("div[role='option']"));

        switch (expense) {
            case "Accommodation" -> retryAction(() -> options.get(1).click(), 10);
            case "Fuel Allowance" -> retryAction(() -> options.get(2).click(), 10);
            case "Planned Surgery" -> retryAction(() -> options.get(3).click(), 10);
            case "Transport" -> retryAction(() -> options.get(4).click(), 10);
            default -> {
            }
        }
    }
}
