package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PerformancePage
{
    WebDriver driver;
    @FindBy(css = "a[href='/web/index.php/performance/viewPerformanceModule']")
    WebElement buttonPerformance;
    @FindBy(css = "li[class='oxd-topbar-body-nav-tab --parent']")
    WebElement buttonConfigure;
    @FindBy(xpath = "//a[text()='KPIs']")
    WebElement buttonKPIs;
    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement buttonAddKPI;
    @FindBy(css = "span[class='oxd-switch-input oxd-switch-input--active --label-right']")
    WebElement buttonToggleDefaultScale;
    @FindBy(css = "button[type='submit']")
    WebElement buttonSaveKPI;
    @FindBys({
            @FindBy(css = "input[autcomplete='off']")
    })
    List<WebElement> textBoxesForm;
    @FindBy(className = "oxd-select-text--after")
    WebElement buttonDisplayJobTitles;
    public PerformancePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickOnButtonPerformance()
    {
        buttonPerformance.click();
    }
    public void clickOnButtonConfigure()
    {
        buttonConfigure.click();
    }
    public boolean isButtonConfigureDisplayed()
    {
        return buttonConfigure.isDisplayed();
    }
    public void clickOnButtonKPIs()
    {
        buttonKPIs.click();
    }
    public void clickOnButtonAddKPI()
    {
        buttonAddKPI.click();
    }
    public boolean isButtonAddKPIDisplayed()
    {
        return buttonAddKPI.isDisplayed();
    }
    public void clickOnButtonDisplayJobTitle()
    {
        buttonDisplayJobTitles.click();
    }
    public void clickOnButtonToggleDefaultScale()
    {
        buttonToggleDefaultScale.click();
    }
    public void clickOnButtonSaveKPI() throws InterruptedException {
        buttonSaveKPI.click();
        Thread.sleep(1500); //Servidor necesita esperar para guardar información
    }
    public void setKPI(String indicator)
    {
        textBoxesForm.get(0).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        textBoxesForm.get(0).sendKeys(Keys.DELETE);
        textBoxesForm.get(0).sendKeys(indicator);
    }
    public void setMinimumRating(String rating)
    {
        textBoxesForm.get(1).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        textBoxesForm.get(1).sendKeys(Keys.DELETE);
        textBoxesForm.get(1).sendKeys(rating);
    }
    public void setMaximumRating(String rating)
    {
        textBoxesForm.get(2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        textBoxesForm.get(2).sendKeys(Keys.DELETE);
        textBoxesForm.get(2).sendKeys(rating);
    }

    public void selectJobTitle(String job) throws InterruptedException
    {
        Thread.sleep(2000); //Servidor necesita esperar para cargar información
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

    public boolean isKPIRecorded(String[] valuesToMatch) throws InterruptedException
    {
        Thread.sleep(3000); //Servidor necesita esperar para cargar información
        List<WebElement> rows = driver.findElements(By.cssSelector(".oxd-table-row[data-v-f2168256]"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".oxd-table-cell"));
            cells.remove(0);
            int i = 0;
            for (WebElement cell : cells)
            {
                String value = cell.getText().trim();
                if (i!= 1 && !value.equals(valuesToMatch[i]))
                {
                    break;
                }
                if (i == 3)
                {
                    return true;
                }
                i ++;
            }
        }
        return false;
    }
}
