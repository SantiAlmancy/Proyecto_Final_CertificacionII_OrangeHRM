package pages;

import org.openqa.selenium.By;
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
    List<WebElement> adminButtons;
    @FindBys({
            @FindBy(css = "div[data-v-957b4417] input[data-v-1f99f73c]")
    })
    List<WebElement> textBoxesUserForm;
    @FindBys({
            @FindBy(css = "i[data-v-67d2aedf]")
    })
    List<WebElement> listDownButtons;
    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement buttonAddUser;
    @FindBy(css = "li[class='oxd-topbar-body-nav-tab --parent --visited']")
    WebElement buttonUserManagement;
    @FindBy(css = "ul[class='oxd-dropdown-menu']")
    WebElement buttonUsers;
    @FindBy(css = "span[class='oxd-text oxd-text--span']")
    WebElement textNumberOfUsers;
    @FindBy(css = "h6[class='oxd-text oxd-text--h6 orangehrm-main-title']")
    WebElement textAddUser;
    @FindBy(css = "button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement buttonSave;
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
    public boolean isAddUserTextVisible()
    {
        return textAddUser.isDisplayed();
    }
    public void setUserNameTextBox(String Username)
    {
        WebElement usernameTextBox = textBoxesUserForm.get(0);
        usernameTextBox.sendKeys(Username);
    }

    public void setPasswordTextBox(String Password)
    {
        WebElement passwordTextBox = textBoxesUserForm.get(1);
        passwordTextBox.sendKeys(Password);
    }
    public void setRepeatedPasswordTextBox(String Password)
    {
        WebElement usernameTextBox = textBoxesUserForm.get(2);
        usernameTextBox.sendKeys(Password);
    }
    public void selectUserRole(String role)
    {
        WebElement listDownButton = listDownButtons.get(0);
        listDownButton.click();

        WebElement listBox = driver.findElement(By.cssSelector("div[role='listbox']"));

        if(role.equals("Admin"))
        {
            WebElement optionToClick = listBox.findElements(By.cssSelector("div[role='option']")).get(1);
            optionToClick.click();
        }
        else if (role.equals("ESS"))
        {
            WebElement optionToClick = listBox.findElements(By.cssSelector("div[role='option']")).get(2);
            optionToClick.click();
        }
    }
    public void selectStatus(String status)
    {
        WebElement listDownButton = listDownButtons.get(1);
        listDownButton.click();
        WebElement listBox = driver.findElement(By.cssSelector("div[role='listbox']"));

        if(status.equals("Enabled"))
        {
            WebElement optionToClick = listBox.findElements(By.cssSelector("div[role='option']")).get(1);
            optionToClick.click();
        }
        else if (status.equals("Disabled"))
        {
            WebElement optionToClick = listBox.findElements(By.cssSelector("div[role='option']")).get(2);
            optionToClick.click();
        }
    }

    public void fillEmployee(String x) throws InterruptedException {
        WebElement autocompleteWrapper = driver.findElement(By.cssSelector("div.oxd-autocomplete-wrapper"));
        WebElement textBox = autocompleteWrapper.findElement(By.cssSelector("input[data-v-75e744cd]"));
        textBox.sendKeys(x);
        Thread.sleep(3000);
        WebElement firstOption = autocompleteWrapper.findElement(By.cssSelector("div.oxd-autocomplete-option"));
        firstOption.click();
    }

    public void clickButtonSave()
    {
        buttonSave.click();
    }

    public boolean UserCreated(String user)
    {
        List<WebElement> tableCards = driver.findElements(By.className("oxd-table-card"));

        for (WebElement tableCard : tableCards) {
            WebElement usernameElement = tableCard.findElement(By.xpath(".//div[@data-v-6c07a142]"));

            String username = usernameElement.getText();

            if (username.equals(user))
            {
                return true;
            }
        }
        return false;
    }
}
