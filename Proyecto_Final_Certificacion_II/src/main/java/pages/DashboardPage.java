package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;

import java.time.Duration;

public class DashboardPage
{
    WebDriver driver;
    @FindBy(className = "oxd-userdropdown-tab")
    WebElement dropDownUser;
    public DashboardPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isDropDownUserVisible()
    {
        //WebElement dropDownUser = new WebDriverWait(DriverManager.getDriver().driver, Duration.ofSeconds(10))
              //  .until(ExpectedConditions.elementToBeClickable(By.className("oxd-userdropdown-tab")));
        return dropDownUser.isDisplayed();
    }
}
