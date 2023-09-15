package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DashboardPage
{
    WebDriver driver;
    @FindBy(className = "oxd-userdropdown-tab")
    WebElement dropDownUser;
    @FindBy(css = "i[class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    WebElement buttonUserDropDown;
    @FindBy(css = "a[href='/web/index.php/auth/logout']")
    WebElement buttonLogout;
    public DashboardPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isDropDownUserVisible()
    {
        return dropDownUser.isDisplayed();
    }
    public void clickOnUserDropdown()
    {
        buttonUserDropDown.click();
    }

    public void clickOnLogout()
    {
        buttonLogout.click();
    }
}
