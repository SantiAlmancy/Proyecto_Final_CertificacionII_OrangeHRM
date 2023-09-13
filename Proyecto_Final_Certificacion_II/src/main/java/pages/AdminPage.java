package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPage
{
    WebDriver driver;
    @FindBys({
            @FindBy(css = "li.oxd-main-menu-item-wrapper")
    })
    private List<WebElement> adminButtons;
    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement buttonAddUser;
    @FindBy(css = "li[class='oxd-topbar-body-nav-tab --parent --visited']")
    WebElement buttonUserManagement;
    @FindBy(css = "ul[class='oxd-dropdown-menu']")
    WebElement buttonUsers;
    @FindBy(css = "span[class='oxd-text oxd-text--span']")
    WebElement textNumberOfUsers;
    public AdminPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickButtonAdmin()
    {
        adminButtons.get(0).click();
    }
    public boolean isButtonUserManagementDisplayed()
    {
        return buttonUserManagement.isDisplayed();
    }
    public void clickButtonAddNewUser()
    {
        buttonAddUser.click();
    }
    public void clickButtonUserManagement()
    {
        buttonUserManagement.click();
    }
    public void clickButtonUsers()
    {
        buttonUsers.click();
    }
    public boolean isNumberOfUsersVisible()
    {
        return textNumberOfUsers.isDisplayed();
    }
}
